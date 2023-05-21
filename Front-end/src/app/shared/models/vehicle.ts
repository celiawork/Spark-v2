import { Energy } from "./energy";
import { TypeVehicle } from "./type-vehicle";
import { User } from "./user";

export interface Vehicle {

idVehicle: number;
consomation: number;
energy: Energy;
vehicleUser: User;
typeVehicle: TypeVehicle;

}
