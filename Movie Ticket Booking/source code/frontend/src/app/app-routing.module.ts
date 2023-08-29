import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MoviesComponent } from './movies/movies.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { UsersComponent } from './users/users.component';
import { GenresComponent } from './genres/genres.component';
import { TicketsComponent } from './tickets/tickets.component';
import { ViewmoviesComponent } from './viewmovies/viewmovies.component';
import { MoviedetailsComponent } from './moviedetails/moviedetails.component';
import { BookticketsComponent } from './booktickets/booktickets.component';
import { ShowComponent } from './show/show.component';
import { CinemaSeatComponent } from './cinema-seat/cinema-seat.component';
import { PaymentComponent } from './payment/payment.component';
import { HistoryComponent } from './history/history.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"movies",component:MoviesComponent},
  {path:"changepassword",component:ChangepasswordComponent},
  {path:"users",component:UsersComponent},
  {path:"genres",component:GenresComponent},
  {path:"tickets",component:TicketsComponent},
  {path:"viewMovies",component:ViewmoviesComponent},
  {path:"movieDetails",component:MoviedetailsComponent},
  {path:"bookTickets",component:BookticketsComponent},
  {path:"show",component:ShowComponent},
  {path:"cinemaseat",component:CinemaSeatComponent},
  {path:"payment",component:PaymentComponent},
  {path:"history",component:HistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
