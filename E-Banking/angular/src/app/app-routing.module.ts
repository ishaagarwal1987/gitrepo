import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { UsersComponent } from './users/users.component';
import { BalanceComponent } from './balance/balance.component';
import { TransferMoneyComponent } from './transfer-money/transfer-money.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { ChequebookComponent } from './chequebook/chequebook.component';
import { ProfilesettingsComponent } from './profilesettings/profilesettings.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { ViewChequebookRequestComponent } from './view-chequebook-request/view-chequebook-request.component';


const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"register",component:RegisterComponent},
  {path:"users",component:UsersComponent},
  {path:"balance",component:BalanceComponent},
  {path:"transfer",component:TransferMoneyComponent},
  {path:"transaction",component:TransactionsComponent},
  {path:"chequebook",component:ChequebookComponent},
  {path:"profileSettings",component:ProfilesettingsComponent},
  {path:"changePassword",component:ChangepasswordComponent},
  {path:"viewRequests",component:ViewChequebookRequestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
