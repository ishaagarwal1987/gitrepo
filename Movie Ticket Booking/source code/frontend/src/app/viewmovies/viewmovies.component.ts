import { Component, OnInit } from '@angular/core';
import { Movie } from '../classes/movie';
import { MovieService } from '../services/movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewmovies',
  templateUrl: './viewmovies.component.html',
  styleUrls: ['./viewmovies.component.css']
})
export class ViewmoviesComponent implements OnInit {

  movies : Movie[] = [];

  constructor(
    private moviesService : MovieService,
    private router :Router
  ) { }

  ngOnInit(): void {
    this.getMovies();
  }

  getMovies(){
    this.moviesService.getMovies().subscribe((data) => {
      this.movies = data;
    });
  }

  moviedetail(m:Movie)
  {
    sessionStorage.setItem('movie',JSON.stringify(m));
    this.router.navigate(['movieDetails']);

  }
}
