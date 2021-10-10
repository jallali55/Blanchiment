import { NgModule } from '@angular/core';
import { NbCardModule, NbIconModule, NbInputModule, NbTreeGridModule } from '@nebular/theme';
import { Ng2SmartTableModule } from 'ng2-smart-table';

import { ThemeModule } from '../../@theme/theme.module';
import {  routedComponents} from './Referentiel-routing.module';

import { ClientmoraleComponent } from './clientmorale/clientmorale.component';
import { ClientphysiqueComponent } from './clientphysique/clientphysique.component';
import { ReferentielRoutingModule } from './Referentiel-routing.module';
import { NewComponent } from './clientphysique/new/new.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewmoraleComponent } from './clientmorale/newmorale/newmorale/newmorale.component';
import { DataTablesModule } from "angular-datatables";
import { EditphysiqueComponent } from './clientphysique/editphysique/editphysique.component';
import { EditmoraleComponent } from './clientmorale/editmorale/editmorale.component'; 

@NgModule({
  imports: [
    FormsModule, ReactiveFormsModule,
    NbCardModule,
    NbTreeGridModule,
    NbIconModule,
    NbInputModule,
    ThemeModule,
    ReferentielRoutingModule,
    Ng2SmartTableModule,
    DataTablesModule,
  ],
  declarations: [
    ...routedComponents,
    
    ClientmoraleComponent,
    ClientphysiqueComponent,
    NewComponent,
    NewmoraleComponent,
    EditphysiqueComponent,
    EditmoraleComponent,
  ],
})
export class ReferentielModule { }
