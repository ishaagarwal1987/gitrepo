import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Show } from '../classes/show';
import { Observable } from 'rxjs';
import { Movie } from '../classes/movie';

@Injectable({
  providedIn: 'root'
})
export class ShowService {
  private apiUrl ="http://localhost:8080/shows";
  
  constructor(private http:HttpClient) { }

  saveShow(show:Show)  : Observable<any>
  {
    return this.http.post(`${this.apiUrl}`,show);
  }
  getShows(): Observable<Show[]>
  {
    return this.http.get<Show[]>(`${this.apiUrl}`);
  }
  getShowsByMovieAndDate(formData :FormData): Observable<Show[]>
  {
    return this.http.post<Show[]>(`${this.apiUrl+"/shows"}`,formData);
  }
  deleteShow(id:number)  : Observable<any>
  { 
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }
  updateShow(show:Show)  : Observable<any>
  {
    return this.http.post(`${this.apiUrl}`,show);
  }
}
