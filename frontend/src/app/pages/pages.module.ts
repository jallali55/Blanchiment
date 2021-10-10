import { NgModule } from '@angular/core';
import { NbMenuModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { CompteComponent } from './compte/compte.component';
import { OperationsComponent } from './operations/operations.component';
import { NewcompteComponent } from './compte/newcompte/newcompte/newcompte.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewOperationComponent } from './operations/new/new-operation/new-operation.component';
import { DataTablesModule } from "angular-datatables"; 

import { NbCardModule, NbIconModule, NbInputModule, NbTreeGridModule } from '@nebular/theme';
import { UsersComponent } from './users/users/users.component';
import { NewuserComponent } from './users/newuser/newuser.component';

import { EdituserComponent } from './users/edituser/edituser.component';
import { StatComponent } from './stat/stat.component';
import { GoogleChartsConfig, GoogleChartsModule, GOOGLE_CHARTS_LAZY_CONFIG } from 'angular-google-charts';
import {  ReplaySubject } from 'rxjs';


@NgModule({
  
  imports: [
    GoogleChartsModule,
    NbCardModule, NbIconModule, NbInputModule, NbTreeGridModule,
    Ng2SmartTableModule,
    FormsModule,
    ReactiveFormsModule,
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    DataTablesModule
  ],
  declarations: [
    PagesComponent,
  
  
    CompteComponent,
  
  
  
    OperationsComponent,
  
  
  
    NewcompteComponent,
  
  
  
    NewOperationComponent,
  
  
  
    UsersComponent,
  
  
  
    NewuserComponent,
  
  
  
    EdituserComponent,
  
  
  
    StatComponent,
  
  
  
    
  ],
  
})
//googleChartsConfigSubject.next(config);

export class PagesModule {
}
