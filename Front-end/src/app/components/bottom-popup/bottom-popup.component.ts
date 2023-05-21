import { Component, Input, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Parking } from 'src/app/shared/models/parking';
import { Vehicle } from 'src/app/shared/models/vehicle';
import { MapService } from 'src/app/shared/services/map.service';
import { ParkingDisplayService } from 'src/app/shared/services/parking-display.service';
import { VehicleService } from 'src/app/shared/services/vehicle.service';
import { ZoneService } from 'src/app/shared/services/zone.service';

@Component({
  selector: 'app-bottom-popup',
  templateUrl: './bottom-popup.component.html',
  styleUrls: ['./bottom-popup.component.scss']
})

export class BottomPopupComponent implements OnInit {

  parking?: Parking;
  vehicle?: Vehicle;
  showPopup: boolean = false;

  @Input() currentUser!: any;
  @Input() endNavigation!: boolean;

  constructor(
    private parkingDisplayService: ParkingDisplayService,
    private vehiculeservice: VehicleService) { }

  ngOnInit(): void {
    this.parkingDisplayService.selectedParking$.subscribe(value => {
      this.parking = value;
    });

    this.vehiculeservice.currentVehicle$.subscribe(value => {
      this.vehicle = value;
    });
  }
}





