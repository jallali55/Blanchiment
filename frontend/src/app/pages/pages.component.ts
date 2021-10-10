import { Component } from '@angular/core';
import { LoginService } from '../service/auth/login.service';
import { MENU_ITEMS } from './pages-menu';
import { MENU_ITEMS_ADMIN } from './pages-menu-admin';


@Component({
  selector: 'ngx-pages',
  styleUrls: ['pages.component.scss'],
  template: `
    <ngx-one-column-layout>
      <nb-menu [items]="menu"></nb-menu>
      <router-outlet></router-outlet>
    </ngx-one-column-layout>
  `,
})
export class PagesComponent {

  menu;
  constructor(private loginService:LoginService) {
    this.menu = MENU_ITEMS;
    if(loginService.isAdmin()){
        this.menu=MENU_ITEMS_ADMIN
    }
   }

}
