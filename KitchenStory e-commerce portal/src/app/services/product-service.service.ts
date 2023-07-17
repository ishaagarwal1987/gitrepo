import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Product } from '../classes/product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private apiUrl ="http://localhost:8080/products";
  constructor(private http:HttpClient) { }

  getAllProducts() : Observable<Product[]>
  {
      return this.http.get<Product[]>(`${this.apiUrl}`);
  }

  saveProduct(formData :FormData) : Observable<Object>
  {
  
    return this.http.post(`${this.apiUrl}`,formData);
  }

  deleteProduct(id:number):Observable<any>
  {
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }
  updateProduct(id:any,formData :FormData) {
    return this.http.put<Product>(`${this.apiUrl}/${id}`,formData);
  }

}
