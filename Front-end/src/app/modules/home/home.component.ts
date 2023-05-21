import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Vehicle } from 'src/app/shared/models/vehicle';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { UserService } from 'src/app/shared/services/user.service';
import { VehicleService } from 'src/app/shared/services/vehicle.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-home',
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.scss']
})
export class HomeComponent implements OnInit {

  token!: any;
  showProfil = false;
  showAddressBar = false;
  currentUserToken!: any;
  mailUser!: any;
  currentUser!: any;


  constructor(
    private tokenstorage: TokenStorageService,
    private userservice: UserService,
    private vehicleSercice: VehicleService) { }

  ngOnInit(): void { this.getCurrentUser(); }

  showprofil() {
    if (this.showProfil == false) {
      this.showProfil = true;
    } else {
      this.showProfil = false;
    }
  }


  showABar() {

    console.log(this.showAddressBar);
    
    if (this.showAddressBar == false) {
      this.showAddressBar = true;
    } else {
      this.showAddressBar = false;
    }
  }

  /**
   * Get informations of current user
   */
  getCurrentUser() {

    this.token = this.tokenstorage.getToken();
    this.currentUserToken = this.tokenstorage.decodeToken(this.token);
    this.mailUser = this.tokenstorage.getEmailUser(this.currentUserToken);
    this.userservice.getUser(this.mailUser).subscribe({
      next: (res) => {
        this.currentUser = JSON.parse(res);
        this.vehicleSercice.getVehicleUser(this.currentUser.id)
      },
      error: (err: any) => {
        throw err.message;
      },

      complete: () => {
      }
    }
    )
  }

  getDetailUser(id: number) {

    this.userservice.getUserDetails(id).subscribe({
      next: (res) => {
        console.log('profilDetails ' + JSON.stringify(res));
      },
      error: (err: any) => {
        throw err.message;
      },

      complete: () => {

      }

    })

  }


}

