import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorCsrfService implements HttpInterceptor {

  constructor(private cookieService: CookieService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    const token = this.cookieService.get('XSRF-TOKEN');

    if (token !== null && token !== undefined) {
      request = request.clone({
        headers: request.headers.set('X-XSRF-TOKEN', token)
      });
    }

    return next.handle(request);
  }
}
