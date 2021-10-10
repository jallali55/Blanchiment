import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SettingsComponent } from './Settings.component';
import { DevisesComponent } from './devises/devises.component';
import { PaysComponent } from './pays/pays.component';
import {ListComponent} from './agences/list/list.component'
import {NewagenceComponent} from './agences/newagence/newagence.component'
const routes: Routes = [{
  path: '',
  component: SettingsComponent,
  children: [
    {
      path: 'devises',
      component: DevisesComponent,
    },
    {
      path: 'pays',
      component: PaysComponent,
    },
    {
      path: 'agences',
      component: ListComponent,
    },
    {
      path: 'agences/new',
      component: NewagenceComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SettingsRoutingModule { }

export const routedComponents = [
  SettingsComponent,
  DevisesComponent,
  ListComponent,
  NewagenceComponent,
  PaysComponent,
];
