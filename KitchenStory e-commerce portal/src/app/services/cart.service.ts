import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from '../classes/cart';
import { Observable } from 'rxjs';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private apiUrl ="http://localhost:8080/carts";
  
  constructor(private http:HttpClient) { }

  saveToCart(cart:Cart) : Observable<Object>
  {
    
    return this.http.post(`${this.apiUrl}`,cart);
  }
  getCartByUser(user:string) : Observable<Cart[]>
  {   
    return this.http.get<Cart[]>(`${this.apiUrl}/${user}`);
  }
  deleteProductFromCart(id:number) : Observable<Cart[]>
  {
    return this.http.delete<Cart[]>(`${this.apiUrl}/${id}`);
  }
}
