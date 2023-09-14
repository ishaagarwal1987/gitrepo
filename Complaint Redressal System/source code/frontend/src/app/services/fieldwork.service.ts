import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Fieldwork } from '../classes/fieldwork';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class FieldworkService {

  private apiUrl ="http://localhost:8080/fieldworks";

  constructor(private http:HttpClient) { }

  addFieldwork(fieldwork:Fieldwork)
  {
    return this.http.post(`${this.apiUrl}`,fieldwork);
  }

  getFieldworks(): Observable<Fieldwork[]>
  {
    return this.http.get<Fieldwork[]>(`${this.apiUrl}`);
  }
}
