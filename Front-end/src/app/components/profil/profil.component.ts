import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicle } from 'src/app/shared/models/vehicle';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { GainService } from 'src/app/shared/services/gain.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { VehicleService } from 'src/app/shared/services/vehicle.service';


@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss'],
})
export class ProfilComponent implements OnInit {

  @Input() showProfil!: boolean;
  @Input() currentUser!: any;
 
  isLoggedIn = false;
  gain!: number;
  vehicle! : Vehicle | undefined;

  constructor(
    private authservice : AuthService, 
    private  gainservice : GainService,
    private vehiculeservice : VehicleService
   ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.authservice.isLoggedIn;
    setTimeout (() => {
      this.showGAin();
   }, 2000);

   this.vehiculeservice.currentVehicle$.subscribe(value => {
    this.vehicle = value;
   });
  }

  showGAin() {
    this.gainservice.getGain(this.currentUser.id).subscribe({
      next: (res) => {
        this.gain = res;
       },
       error: (err: any) => { 
         throw err.message;
       },
       complete: () => { 
       }
    })
  }
  
  handleLogout() {
    this.authservice.logout();
  }
}


