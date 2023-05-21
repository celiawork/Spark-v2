import { HttpClientModule, HttpClientXsrfModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { MapModule } from './modules/map/map.module';
import { AuthInterceptorCsrfService } from './shared/services/auth/auth-interceptor-csrf.service';
import { AuthInterceptorResponse } from './shared/services/auth/auth-interceptor-response.service';
import { AuthInterceptor } from './shared/services/auth/auth-interceptor.service';




@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClientXsrfModule.withOptions({
      cookieName: "XSRF-TOKEN",
      headerName: "X-XSRF-TOKEN"
    })
  ],

  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorResponse,
      multi: true
    }
    ,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorCsrfService,
      multi: true
    }
  ],

  bootstrap: [AppComponent]

})
export class AppModule { }
