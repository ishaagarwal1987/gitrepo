import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Generes } from '../classes/genres';

@Injectable({
  providedIn: 'root'
})
export class GenresService {
  private apiUrl ="http://localhost:8080/genres";

  constructor(private http:HttpClient) { }

  saveGenre(genre:string)
  {
    return this.http.post(`${this.apiUrl+"/add"}`,genre);
  }
  getGenre() : Observable<Generes[]>
  {
    return this.http.get<Generes[]>(`${this.apiUrl}`);
  }
  editGenre(id: number, value: any) : Observable<Generes[]>
  {
    return this.http.put<Generes[]>(`${this.apiUrl}/${id}`,value);
  }
  removeGenre(id: number) : Observable<any>
  {
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }

}
