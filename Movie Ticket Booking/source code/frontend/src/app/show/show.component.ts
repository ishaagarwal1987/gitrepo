import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Show } from '../classes/show';

import { Movie } from '../classes/movie';
import { ShowService } from '../services/show.service';
import { MovieService } from '../services/movie.service';



@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  displayStyle = "none";
  shows:Show[]=[];
  show:Show = new Show();
  movies:Movie[]=[];
  showdate: string;
  startTime: string;
  endTime: string;
  movie:Movie;
  constructor(
    private builder:FormBuilder,
    private showService:ShowService,
    private movieService:MovieService
  ) { }

  ngOnInit(): void {
    this.getMovies();
    this.getshows();
  }

  showForm = this.builder.group({
    
    date : this.builder.control('',[Validators.required]),
    startTime : this.builder.control('',[Validators.required]),
    endTime : this.builder.control('',[Validators.required]),
    movie : this.builder.control('',[Validators.required])
  })

  getMovies()
  {
    this.movieService.getMovies().subscribe((data) => {
      this.movies = data;
    });
  }
  addShow(){

    this.show.movie = this.movie;
    this.show.showdate = this.showdate;
    this.show.startTime = this.startTime;
    this.show.endTime = this.endTime;

    this.showService.saveShow(this.show).subscribe(data=>{
      this.getshows();
    });

    this.movie=null;
    this.showdate="";
    this.startTime="";
    this.endTime="";
    this.show=null;
  }
  getshows()
  {
    this.showService.getShows().subscribe(data=>{
      this.shows=data;
    });
  }
  openModifyPopup(show:Show)
  {
    this.movie=show.movie;
    this.showdate=show.showdate;
    this.startTime=show.startTime;
    this.endTime=show.endTime;   
    this.show = show; 
    this.displayStyle="block"
  }
  closePopup() {
    this.displayStyle = "none";
    this.show=null;
  }
  deleteShow(id:number)
  {
    this.showService.deleteShow(id).subscribe(data=>{
      this.getshows();
    });
  }
  updateShow()
  {
    this.show.movie = this.movie;
    this.show.showdate = this.showdate;
    this.show.startTime = this.startTime;
    this.show.endTime = this.endTime;

    this.showService.updateShow(this.show).subscribe(data=>{
      this.getshows();
    });

    this.movie=null;
    this.showdate="";
    this.startTime="";
    this.endTime="";
    this.show=null;
  }
}
