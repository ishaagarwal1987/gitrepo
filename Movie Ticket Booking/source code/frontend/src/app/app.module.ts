import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeNavbarComponent } from './home-navbar/home-navbar.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MoviesComponent } from './movies/movies.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { GenresComponent } from './genres/genres.component';
import { TicketsComponent } from './tickets/tickets.component';
import { ViewmoviesComponent } from './viewmovies/viewmovies.component';
import { MoviedetailsComponent } from './moviedetails/moviedetails.component';
import { BookticketsComponent } from './booktickets/booktickets.component';
import { ShowComponent } from './show/show.component';
import { CinemaSeatComponent } from './cinema-seat/cinema-seat.component';
import { PaymentComponent } from './payment/payment.component';
import { ClientNavbarComponent } from './client-navbar/client-navbar.component';
import { HistoryComponent } from './history/history.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeNavbarComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    MoviesComponent,
    AdminDashboardComponent,
    UsersComponent,
    ChangepasswordComponent,
    GenresComponent,
    TicketsComponent,
    ViewmoviesComponent,
    MoviedetailsComponent,
    BookticketsComponent,
    ShowComponent,
    CinemaSeatComponent,
    PaymentComponent,
    ClientNavbarComponent,
    HistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    RouterModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
