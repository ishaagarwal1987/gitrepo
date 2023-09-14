import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeNavbarComponent } from './home-navbar/home-navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { ClientNavbarComponent } from './client-navbar/client-navbar.component';
import { EmployeeNavbarComponent } from './employee-navbar/employee-navbar.component';
import { UsersComponent } from './users/users.component';
import { RaiseTicketComponent } from './raise-ticket/raise-ticket.component';
import { ComplaintsComponent } from './complaints/complaints.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ComplaintEmployeePageComponent } from './complaint-employee-page/complaint-employee-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeNavbarComponent,
    LoginComponent,
    RegisterComponent,
    AdminNavbarComponent,
    ClientNavbarComponent,
    EmployeeNavbarComponent,
    UsersComponent,
    RaiseTicketComponent,
    ComplaintsComponent,
    ChangePasswordComponent,
    ComplaintEmployeePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
