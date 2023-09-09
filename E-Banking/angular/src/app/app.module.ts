import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomenavbarComponent } from './homenavbar/homenavbar.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { UsersComponent } from './users/users.component';

import { TransferMoneyComponent } from './transfer-money/transfer-money.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { ChequebookComponent } from './chequebook/chequebook.component';
import { BalanceComponent } from './balance/balance.component';
import { ProfilesettingsComponent } from './profilesettings/profilesettings.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { ViewChequebookRequestComponent } from './view-chequebook-request/view-chequebook-request.component';

@NgModule({
  declarations: [
    AppComponent,
    HomenavbarComponent,
    HomeComponent,
    RegisterComponent,
    AdminDashboardComponent,
    ClientDashboardComponent,
    UsersComponent,
    TransferMoneyComponent,
    TransactionsComponent,
    ChequebookComponent,
    BalanceComponent,
    ProfilesettingsComponent,
    ChangepasswordComponent,
    ViewChequebookRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
