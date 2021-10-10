import { NgModule } from '@angular/core';
import { NbCardModule, NbIconModule, NbInputModule, NbTreeGridModule } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { ThemeModule } from '../../@theme/theme.module';
import {  routedComponents} from './Settings-routing.module';

import { DevisesComponent } from './devises/devises.component';
import { PaysComponent } from './pays/pays.component';
import { SettingsRoutingModule } from './Settings-routing.module';
import { DataTablesModule } from "angular-datatables"; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListComponent } from './agences/list/list.component';
import { NewagenceComponent } from './agences/newagence/newagence.component';

@NgModule({
  imports: [
    FormsModule, ReactiveFormsModule ,
    NbCardModule,
    NbTreeGridModule,
    NbIconModule,
    NbInputModule,
    ThemeModule,
    SettingsRoutingModule,
    Ng2SmartTableModule,
    DataTablesModule
  ],
  declarations: [
    ...routedComponents,
    
    DevisesComponent,
    PaysComponent,
    ListComponent,
    NewagenceComponent,
  ],
})
export class SettingsModule { }
