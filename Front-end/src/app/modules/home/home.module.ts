import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { NavbarComponent } from 'src/app/components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { AddressBarComponent } from 'src/app/components/address-bar/address-bar.component';
import { MapModule } from '../map/map.module';
import { BottomPopupComponent } from 'src/app/components/bottom-popup/bottom-popup.component';
import { ProfilComponent } from 'src/app/components/profil/profil.component';


@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    AddressBarComponent,
    ProfilComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    MapModule   
  ],
})
export class HomeModule { }
