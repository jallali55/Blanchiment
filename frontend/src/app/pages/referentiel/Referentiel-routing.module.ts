import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ReferentielComponent } from './Referentiel.component';
import { ClientmoraleComponent } from './clientmorale/clientmorale.component';
import { ClientphysiqueComponent } from './clientphysique/clientphysique.component';
import { NewComponent } from './clientphysique/new/new.component';
import { NewmoraleComponent } from './clientmorale/newmorale/newmorale/newmorale.component';
import {EditphysiqueComponent} from './clientphysique/editphysique/editphysique.component';
import {EditmoraleComponent} from './clientmorale/editmorale/editmorale.component';
const routes: Routes = [{
  path: '',
  component: ReferentielComponent,
  children: [
    {
      path: 'clientmorale',
      component: ClientmoraleComponent,
    },
    {
      path: 'clientmorale/new',
      component: NewmoraleComponent,
    },
    {
      path: 'clientmorale/edit/:id',
      component: EditmoraleComponent,
    },
    {
      path: 'clientphysique',
      component: ClientphysiqueComponent,
    },
    {
      path: 'clientphysique/new',
      component: NewComponent,
    },
    {
      path: 'clientphysique/edit/:id',
      component: EditphysiqueComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ReferentielRoutingModule { }

export const routedComponents = [
  ReferentielComponent,
  ClientmoraleComponent,
  ClientphysiqueComponent,
];
