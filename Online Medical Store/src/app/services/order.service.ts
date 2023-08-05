import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../classes/order';
import { Orderdetails } from '../classes/orderdetails';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl ="http://localhost:8080/orders";

  constructor(private http:HttpClient) { }

  saveOrder(order : Order) : Observable<any>
  {
    return this.http.post(`${this.apiUrl}`,order);
  }
  getOrder() : Observable<Order[]>
  {
    return this.http.get<Order[]>(`${this.apiUrl}`);
  }
  getOrderByUser(user:string) : Observable<Order[]>
  {
    return this.http.get<Order[]>(`${this.apiUrl}/${user}`);
  }
  getOrderDetails(id:number) : Observable<Orderdetails[]>
  {
    return this.http.get<Orderdetails[]>(`${this.apiUrl+"/details"}/${id}`);
  }


}
