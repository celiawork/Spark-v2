import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

import { catchError, map, Observable, ReplaySubject, tap, throwError } from 'rxjs';
import { LoginComponent } from 'src/app/modules/login/login.component';

import { environment } from 'src/environments/environment';

import { TokenStorageService } from '../token-storage.service';


@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient, private tokenService: TokenStorageService, private router: Router) {
  }

  signIn(username: string, password: string) {
    return this.http
      .post<any>(environment.apis.login.url, {}, {
        params: new HttpParams({
          fromObject: {
            username: username,
            password: password
          }
        })
      })
  }
/**
 * Request HTTP POST to register the user
 * @param firstname : form value firstname
 * @param lastname : form value lastname
 * @param email : form value username
 * @param password : form value password
 * @returns Observable type text
 */
  register(firstname: string, lastname: string, email: string, password: string): Observable<any> {
    return this.http
      .post(environment.apis.register.url, {
        firstname,
        lastname,
        email,
        password
      }, { responseType: 'text' });
  }

  get isLoggedIn(): boolean {
    let authToken = this.tokenService.getToken();
    return authToken !== null ? true : false;
  }

  confirmationTokenRegister(token: string): Observable<any> {
    return this.http
      .get(environment.apis.register.url + "confirm?token=" + token);
  }

  refreshToken(token: string) {
    return this.http.post(environment.apis.token.url, {
      refreshToken: token
    });
  }

  logout() {
    sessionStorage.removeItem("acces_token");
  }
}


