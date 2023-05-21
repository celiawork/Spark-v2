import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorResponse implements HttpInterceptor {

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const startTime = (new Date()).getTime();
    return next.handle(req).pipe(map(event => {
      if (event instanceof HttpResponse) {
        const endTime = (new Date).getTime();
        const responseTime = endTime - startTime;
        console.log(`${event.url} succeed in ${responseTime} ms`)
      }
      return event;
    }));
  }
}
