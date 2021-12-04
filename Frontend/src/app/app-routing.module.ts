import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "../app/home/home.component";
import {SignupComponent} from "../app/signup/signup.component";
import {SigninComponent} from "../app/signin/signin.component";
import {AppComponent} from "../app/app.component";


const routes: Routes = [

  {path: '', redirectTo:'home-component', pathMatch: 'full'},

  {path: 'home-component', component: HomeComponent},

  {path: 'signup-component', component: SignupComponent},

  {path: 'signin-component', component: SigninComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
