import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../classes/booking';
import { Observable } from 'rxjs';
import { User } from '../classes/user';
import { Showseat } from '../classes/showseat';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private apiUrl ="http://localhost:8080/booking";

  constructor(private http:HttpClient) { }

  addTickets(formData:FormData)
  {
    return this.http.post(`${this.apiUrl}`,formData);
  }
  getTickets(): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiUrl}`);
  }
  getTicketsByUser(user:User): Observable<Booking[]>
  {
    return this.http.get<Booking[]>(`${this.apiUrl+"/user"}/${user.userid}`);
  }
  getSeatByBooking(booking:number): Observable<Showseat[]>
  {
    return this.http.get<Showseat[]>(`${this.apiUrl+"/seat"}/${booking}`);
  }
  getSeatsByShow(showid:number) : Observable<Showseat[]>
  {
    return this.http.get<Showseat[]>(`${this.apiUrl+"/show"}/${showid}`);
  }
}
