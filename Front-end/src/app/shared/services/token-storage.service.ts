import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';

const TOKEN_KEY = 'acces_token';
const REFRESHTOKEN_KEY = 'refresh_token';
const USER_KEY = 'username';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() {}

  jwtToken!: string;
  decodedToken!: { [key: string]: string };



  public setToken(token: string) {
    if (token) {
      this.jwtToken = token;
    }
  }

  public getDecodeToken() {
    return jwt_decode(this.jwtToken);
  }


  public getToken(): string | null {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public decodeToken(token: string | null) {
    if (token) {
     return jwt_decode(token);
    }
  }
  
  public getEmailUser(decodeToken : any) {
    return decodeToken ? decodeToken['sub'] : null;
  }

  
  public getIdUser(decodeToken : any) {
    return decodeToken ? decodeToken['id'] : null;
  }


  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }



  public saveRefreshToken(token: string): void {
    window.sessionStorage.removeItem(REFRESHTOKEN_KEY);
    window.sessionStorage.setItem(REFRESHTOKEN_KEY, token);
  }

  public getRefreshToken(): string | null {
    return window.sessionStorage.getItem(REFRESHTOKEN_KEY);
  }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }


  
}
