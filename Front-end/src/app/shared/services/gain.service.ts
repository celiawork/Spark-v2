import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';


@Injectable({
	providedIn: 'root',
})
export class GainService {

	constructor(private http: HttpClient) { }

	/**Calculate the gain with the CO2 emissions saved
	 * @param emissionCarbon : the CO2 emissions saved
	 * @returns The result of the gain calculation
	 */
	public calGain(emissionCarbon: number) {
		let cal = Math.ceil(emissionCarbon / 100);
		return cal;
	}

	/**
	 * Get user'gain from DB
	 * @param id : id of user
	 * @returns the gain in in json format
	 */
	public getGain(id: number) {
		return this.http.get<number>(environment.apis.users.url + '/gain/' + id, { responseType: 'json' });
	}

	/**
	 * Save gain to user in DB
	 * @param id : id of user
	 * @param newGain : gain : gain earned by the user
	 * @returns 
	 */
	public addGainToUser(id: number, newGain: number) {
		return this.http.patch(environment.apis.users.url + '/gain/' + id + "/" + newGain, { responseType: 'json' });
	}
}

