import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './auth/login/login.component';
import {AuthGuard} from './service/auth/auth.guard'

export const routes: Routes = [
  {
    path: 'pages',
    loadChildren: () => import('./pages/pages.module')
      .then(m => m.PagesModule),
      canActivate: [ AuthGuard ],
      runGuardsAndResolvers: 'always',


  },
  {
    path: 'auth',
    component: LoginComponent,
  },
  { path: '', redirectTo: 'pages', pathMatch: 'full',  canActivate: [ AuthGuard ],   runGuardsAndResolvers: 'always',
},
  { path: '**', redirectTo: 'pages',  canActivate: [ AuthGuard ],   runGuardsAndResolvers: 'always',},
  
];

const config: ExtraOptions = {
  useHash: false,
  onSameUrlNavigation : "reload"
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
