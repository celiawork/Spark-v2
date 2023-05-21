import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { BehaviorSubject, Subscription } from 'rxjs';
import { ParkingClass } from 'src/app/shared/models/parkingMooc';
import { Zone } from 'src/app/shared/models/zone';
import { EmissionService } from 'src/app/shared/services/emission.service';
import { ZoneService } from 'src/app/shared/services/zone.service';
import { Vehicle } from 'src/app/shared/models/vehicle';
import { VehicleService } from 'src/app/shared/services/vehicle.service';
import { GainService } from 'src/app/shared/services/gain.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { Parking } from 'src/app/shared/models/parking';
import { Router } from '@angular/router';

@Component({
  selector: 'app-messageStandard',
  templateUrl: './messageStandard.component.html',
  styleUrls: ['./messageStandard.component.scss'],
})
export class MessageStandardComponent implements OnInit, OnDestroy {

  message: string = 'Bravo, vous avez fait des économies et gagné des points'; //to be modified as appropriate
  emission!: number;
  gain!: number;
  zone!: any;
  sub!: Subscription;
  @Input() parking!: Parking | undefined;
  @Input() currentUser!: any;
  @Input() vehicle!: any;
  public currentZone$ = new BehaviorSubject<Zone | null>(null);


  constructor(
    private zoneService: ZoneService,
    private emissionService: EmissionService,
    private gainService: GainService,
    public router: Router
  ) { }


  ngOnInit(): void {

    if (this.parking !== undefined) {
      this.getZoneDetailsOfParking(this.parking);
      setTimeout(() => {
        this.calculEmission(this.zone);}, 500);
      setTimeout(() => {
        this.calGain(this.emission);}, 600);
      setTimeout(() => {
        this.saveGAin();}, 700);
    }
  }

  /**
   *Get details zone of parking
   * @param parkingparking choosed by user
   */
  getZoneDetailsOfParking(parking: Parking | undefined) {
    this.sub = this.zoneService.getAllZone().subscribe((arrayResult) => {
      let result = arrayResult.find((zone) => zone.nom == parking?.typo_fonct)!;
      if (result !== null) {
        this.currentZone$.next(result);
        this.zone = this.currentZone$.value;
      }
    });
  }

  /**
   * calculate the emissions consumed when user looking for a parking
   */
  calculEmission(zone: Zone) {
    let distanceKmDone = this.emissionService.distanceLookForPark(zone);
    this.emission = this.emissionService.emissionConsumedByRoute(distanceKmDone, this.vehicle
    );
  }

  /**
   *Calculate the gain 
   * @param emissionCarbon the emission consume when looking for parking
   */
  public calGain(emissionCarbon: number) {
    this.gain = this.gainService.calGain(emissionCarbon);

  }
  /**
   * Save gain to current user in the database
   */
  saveGAin() {
    this.sub = this.gainService.addGainToUser(this.currentUser.id, this.gain).subscribe({
      next: (res) => { },
      error: (err: any) => {
        console.log(err.error.message);
      },
      complete: () => {
        console.log("success update gain in DB");
      }
    });
  }

  /**
   * Destroy observer
   */
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}

