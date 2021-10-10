import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';


import { CompteComponent } from './compte/compte.component';
import { ClientmoraleComponent } from './referentiel/clientmorale/clientmorale.component';

import { OperationsComponent } from './operations/operations.component';
import { DevisesComponent } from './Settings/devises/devises.component';
import { PaysComponent } from './Settings/pays/pays.component';
import {ListComponent} from './Settings/agences/list/list.component'
import {NewagenceComponent} from './Settings/agences/newagence/newagence.component'
import { NewcompteComponent } from './compte/newcompte/newcompte/newcompte.component';
import { NewOperationComponent } from './operations/new/new-operation/new-operation.component';
import {UsersComponent} from './users/users/users.component'
import {NewuserComponent} from './users/newuser/newuser.component'
import {EdituserComponent} from './users/edituser/edituser.component'
import { StatComponent } from './stat/stat.component';
const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'dashboard',
      component: StatComponent,
    },
    {
      path: 'referentiel',
      loadChildren: () => import('./referentiel/Referentiel.module')
        .then(m => m.ReferentielModule),
    },
    {
      path: 'settings',
      loadChildren: () => import('./Settings/Settings.module')
        .then(m => m.SettingsModule),
    },
    {
      path: 'blanchiment',
      loadChildren: () => import('./Blanchiment/blanchiment.module')
        .then(m => m.BlanchimentModule),
    },
   
    {
      path: 'compte',
      component: CompteComponent,
    },
    {
      path: 'compte/new',
      component: NewcompteComponent,
    },
    {
      path: 'operations',
      component:OperationsComponent,
    },
    {
      path: 'operations/new',
      component:NewOperationComponent,
    },
    {
      path:'devises',
      component:DevisesComponent,
    },
    {
      path:'users',
      component:UsersComponent,
    },
    {
      path:'users/edit/:id',
      component:EdituserComponent,
    },
    {
      path: 'users/new',
      component: NewuserComponent,
    },
    {path:'pays',
     component:PaysComponent,},
     {path:'agences',
     component:ListComponent,},
     {path:'agences/new',
     component:NewagenceComponent,},

     
   
    {
      path: '',
      redirectTo: 'dashboard',
      pathMatch: 'full',
    },
    {
      path: '**',
      component: StatComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
