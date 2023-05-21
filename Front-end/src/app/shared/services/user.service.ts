import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, find, Observable, retry, tap, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {


  constructor(private http: HttpClient) {}

  getPublicContent(): Observable<any> {
    return this.http.get(environment.apis.users.url + 'all', { responseType: 'text' });
  }

  getUser(email: string): Observable<any> {
    return this.http.get(environment.apis.users.url  + "/" + email , { responseType: 'text' });
  }

  getUserDetails(id: number): Observable<any> {
    return this.http.get(environment.apis.users.url  + "/profile/" + id , { responseType: 'text' });
  }

  addUserDetails(id : number): Observable<any> {
    return this.http.post(environment.apis.users.url  + "/profile/" + id , { responseType: 'text' });
  }

}
