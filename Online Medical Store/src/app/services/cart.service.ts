import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from '../classes/cart';
import { Observable } from 'rxjs';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private apiUrl ="http://localhost:8080/cart";

  constructor(private http:HttpClient) { }

  saveToCart(cart:Cart) 
  {
    return this.http.post(`${this.apiUrl}`,cart);
  }
  getCartByUser(user:String) : Observable<Cart[]>
  {   
    return this.http.get<Cart[]>(`${this.apiUrl}/${user}`);
  }
  deleteProductFromCart(id:number) 
  {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  updateCart(cart:Cart)
  {
    return this.http.put(`${this.apiUrl}/${cart.cartid}`,cart);
  }
  
}
