import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ChequebookRequest } from '../classes/chequebook-request';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChequebookrequestService {

  private apiUrl ="http://localhost:8080/chequebook";

  constructor(private http:HttpClient) { }

  addRequest(req:ChequebookRequest)
  {
    return this.http.post(`${this.apiUrl}`,req);
  }

  getAllRequests()   :   Observable<ChequebookRequest[]>
  {
    return this.http.get<ChequebookRequest[]>(`${this.apiUrl}`);
  }
  getPendingRequests()   :   Observable<ChequebookRequest[]>
  {
    return this.http.get<ChequebookRequest[]>(`${this.apiUrl+"/pending"}`);
  }
  getAllRequestsByUser(user:string):   Observable<ChequebookRequest[]>
  {
    return this.http.get<ChequebookRequest[]>(`${this.apiUrl+"/pending"}/${user}`);
  }
}
