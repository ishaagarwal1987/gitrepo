import { Component, OnInit } from '@angular/core';
import { Movie } from '../classes/movie';
import { Router } from '@angular/router';
import { ShowService } from '../services/show.service';
import { Show } from '../classes/show';
import { User } from '../classes/user';

@Component({
  selector: 'app-moviedetails',
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.css']
})
export class MoviedetailsComponent implements OnInit {

  movieObj : Movie = new Movie();
  math = Math;
  showdate:string;
  shows:Show[] = [];
  user:User;

  constructor(
    private router :Router,
    private showService : ShowService
  ) { }

  ngOnInit(): void {
    this.details();
  }

  details()
  {
    this.movieObj = JSON.parse(sessionStorage.getItem("movie"));
    this.user = JSON.parse(sessionStorage.getItem("user"));
   
  }
  getShows()
  {
    const formdata = new FormData();
    formdata.append("movie", JSON.stringify(this.movieObj));
    formdata.append("date", this.showdate);
    this.showService.getShowsByMovieAndDate(formdata).subscribe(data=>{
      this.shows = data;
    });
  }
  bookTickets(show:Show){
    sessionStorage.setItem("show",JSON.stringify(show));
    if(this.user)
      this.router.navigate(['bookTickets']);
    else
      this.router.navigate(['login']);
  }

  convertMinuteToHour(minute: number) {
    var hours = this.math.floor(minute / 60);
    var minutes = minute % 60;
    var duration = hours + " Hours : " + minutes + "Minutes";
    return duration;
  }
  
}

