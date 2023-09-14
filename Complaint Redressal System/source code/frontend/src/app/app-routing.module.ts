import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UsersComponent } from './users/users.component';
import { RaiseTicketComponent } from './raise-ticket/raise-ticket.component';
import { ComplaintsComponent } from './complaints/complaints.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ComplaintEmployeePageComponent } from './complaint-employee-page/complaint-employee-page.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"users",component:UsersComponent},
  {path:"raiseTicket",component:RaiseTicketComponent},
  {path:"complaints",component:ComplaintsComponent},
  {path:"complaintsEmployees",component:ComplaintEmployeePageComponent},
  {path:"changePassword",component:ChangePasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
