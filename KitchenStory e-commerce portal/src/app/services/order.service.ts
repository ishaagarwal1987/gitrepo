import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Order } from '../classes/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl ="http://localhost:8080/orders";
  
  constructor(private http:HttpClient) { }

  saveOrder(order : Order) : Observable<Object>
  {
    return this.http.post(`${this.apiUrl}`,order);
  }
  getOrder() : Observable<Order[]>
  {
    return this.http.get<Order[]>(`${this.apiUrl}`);
  }
  getOrderUser(user:string) : Observable<Order[]>
  {
    return this.http.get<Order[]>(`${this.apiUrl}/${user}`);
  }
}
