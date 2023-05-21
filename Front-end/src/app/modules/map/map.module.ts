import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { ItineraryComponent } from 'src/app/components/itinerary/itinerary.component';
import { ParkingComponent } from 'src/app/components/parkings/parking/parking.component';
import { ParkingsComponent } from 'src/app/components/parkings/parkings.component';
import { MapComponent } from 'src/app/modules/map/map.component';
import { MapRoutingModule } from './map-routing.module';
import { BottomPopupComponent } from 'src/app/components/bottom-popup/bottom-popup.component';
import { MessageStandardComponent } from 'src/app/components/bottom-popup/messageStandard/messageStandard.component';
import { FavoriteMessageComponent } from 'src/app/components/bottom-popup/favoriteMessage/favoriteMessage.component';
import { AddFavoritesComponent } from 'src/app/components/bottom-popup-interactive/add-favorites/add-favorites.component';
import { MessageComponent } from 'src/app/components/bottom-popup-interactive/message/message.component';
import { BottomPopupInteractiveComponent } from 'src/app/components/bottom-popup-interactive/bottom-popup-interactive.component';


/**
 * Map Module and sub components
 */
@NgModule({
  declarations: [
    MapComponent,
    ItineraryComponent,
    ParkingsComponent,
    ParkingComponent,
    BottomPopupComponent,
    MessageStandardComponent,
    FavoriteMessageComponent,
    AddFavoritesComponent,
    MessageComponent,
    BottomPopupInteractiveComponent


  ],
  imports: [
    CommonModule,
    LeafletModule,
    MapRoutingModule,
  ],
  exports: [
    MapComponent,
    ItineraryComponent,
    ParkingsComponent,
    ParkingComponent,
    BottomPopupComponent,
    MessageStandardComponent,
    FavoriteMessageComponent,
    AddFavoritesComponent,
    BottomPopupInteractiveComponent
  ]
})
export class MapModule { }
