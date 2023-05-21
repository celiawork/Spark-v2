import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { Vehicle } from '../models/vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  public currentVehicle$ = new BehaviorSubject<Vehicle | undefined>(undefined);

  constructor(
    private http: HttpClient) { }

  /**
   * Get all vehicles from database
   */
  getAllVehicle(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(environment.apis.vehicle.url);
  }

  /**
   * Get the informations of user's vehicle
   * @param id : user id
   */
  getVehicleUser(id: number) {
    this.getAllVehicle().subscribe((arrayResult) => {
      let result = arrayResult.find(
        (vehicle) => vehicle.vehicleUser.id == id
      )!;
      this.currentVehicle$.next(result);
    });
  }
}





