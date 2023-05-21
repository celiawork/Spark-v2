// -- Gestion de l'affichage de la map (affichage de la carte 'OpenStreetMap' et de ses dépendances) -- //
import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
// -> Imports 'leaflet'
import * as L from "leaflet";
// -> imports 'routing-machine' & 'Graphhopper'
import 'leaflet-routing-machine';
import { MapService } from 'src/app/shared/services/map.service';
import { Map } from "leaflet";


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})

export class MapComponent implements OnDestroy {
  @Output() map$: EventEmitter<L.Map> = new EventEmitter;
  @Output() zoom$: EventEmitter<number> = new EventEmitter;
  @Input() currentUser!: any;
  @Input() options!: L.MapOptions;

  public map!: L.Map;
  public zoom!: number;
  navigationState !: boolean;

  receiveMap(map: Map) {
    this.map = map;
  }
  receiveZoom(zoom: number) {
    this.zoom = zoom;
  }

  constructor(
    public mapService: MapService
    ) {
    this.setMapOptions();
  }

  setMapOptions() {
    this.options = this.mapService.setMapOptions();
  }

  /**
   * Call to leaflet map initializer & param
   * @param map Leaflet 'Map'
   */
  onMapReady(map: L.Map) {
    this.mapService.MapReady(map);
    console.log("after on map ready");
  }

  endNavigation() {
    
    this.navigationState = true;
    console.log("end of navigation");
    
  }

  ngOnDestroy() {
    this.mapService.map.clearAllEventListeners();
    this.mapService.map.remove();
  }

}
