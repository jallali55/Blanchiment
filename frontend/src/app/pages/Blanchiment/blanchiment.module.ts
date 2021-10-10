import { NgModule } from '@angular/core';
import { NbCardModule, NbIconModule, NbInputModule, NbTreeGridModule } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { ThemeModule } from '../../@theme/theme.module';
import {  routedComponents, BlanchimentRoutingModule } from './blanchiment-routing.module';

import { ListeNoireComponent } from './liste-noire/liste-noire.component';
import { ChargerFichierComponent } from './charger-fichier/charger-fichier.component';
import { DataTablesModule } from "angular-datatables";

@NgModule({
  imports: [
    DataTablesModule,
    NbCardModule,
    NbTreeGridModule,
    NbIconModule,
    NbInputModule,
    ThemeModule,
    BlanchimentRoutingModule,
    Ng2SmartTableModule,
  ],
  declarations: [
    ...routedComponents,
    
    ListeNoireComponent,
    ChargerFichierComponent,
  ],
})
export class BlanchimentModule { }
