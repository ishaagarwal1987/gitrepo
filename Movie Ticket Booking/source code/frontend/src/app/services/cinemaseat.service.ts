import { Injectable } from '@angular/core';
import { CinemaSeat } from '../classes/cinema-seat';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CinemaseatService {

  private apiUrl ="http://localhost:8080/cinemaseats";

  constructor(private http:HttpClient) { }

  saveSeat(seat:CinemaSeat)
  {
    return this.http.post(`${this.apiUrl}`,seat);
  }
  getSeats() : Observable<CinemaSeat[]>
  {
    return this.http.get<CinemaSeat[]>(`${this.apiUrl}`);
  }
  editSeat(seat:CinemaSeat) 
  {
    return this.http.put<CinemaSeat[]>(`${this.apiUrl}`,seat);
  }
  removeSeat(id: number) 
  {
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }

}
