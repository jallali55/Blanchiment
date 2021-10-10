import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BlanchimentComponent } from './blanchiment.component';
import { ListeNoireComponent } from './liste-noire/liste-noire.component';
import { ChargerFichierComponent } from './charger-fichier/charger-fichier.component';

const routes: Routes = [{
  path: '',
  component: BlanchimentComponent,
  children: [
    {
      path: 'liste-noire',
      component: ListeNoireComponent,
    },
    {
      path: 'charger-fichier',
      component: ChargerFichierComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BlanchimentRoutingModule { }

export const routedComponents = [
  BlanchimentComponent,
  ListeNoireComponent,
  ChargerFichierComponent,
];
