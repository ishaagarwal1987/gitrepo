import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../classes/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private apiUrl ="http://localhost:8080/movies";

  constructor(private http:HttpClient) { }

  saveMovie(formData:FormData)  : Observable<any>
  {
    return this.http.post(`${this.apiUrl}`,formData);
  }
  getMovies(): Observable<Movie[]>
  {
    return this.http.get<Movie[]>(`${this.apiUrl}`);
  }
  deleteMovie(id:number)  : Observable<any>
  { 
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }
  updateMovie(formData:FormData)  : Observable<any>
  {
    return this.http.post(`${this.apiUrl+"/update"}`,formData);
  }
  
  getMovieByGenre(genre:number)  : Observable<Movie[]>
  {
    return this.http.get<Movie[]>(`${this.apiUrl+"/genres"}/${genre}`);
  }
  getFewMovies()  : Observable<Movie[]>
  {
    return this.http.get<Movie[]>(`${this.apiUrl+"/few"}`);
  }
}
