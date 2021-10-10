import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtHelperService } from "@auth0/angular-jwt";


@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = localStorage.getItem('token');
    const helper = new JwtHelperService();
    if (!helper.isTokenExpired(localStorage.getItem('token'))) {
      request = request.clone({
        setHeaders: {
          Authorization: token
        }
      });

    }
    return next.handle(request);
  }
}
