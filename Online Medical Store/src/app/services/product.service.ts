import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../classes/product';
import { Observable } from 'rxjs';
import { Category } from '../classes/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl ="http://localhost:8080/products";

  constructor(private http:HttpClient) { }

  saveProduct(formData:FormData):Observable<any>
  {
    return this.http.post(`${this.apiUrl}`,formData);
  }
  getProducts(): Observable<Product[]>
  {
    return this.http.get<Product[]>(`${this.apiUrl}`);
  }
  deleteProduct(id:number)  : Observable<any>
  { 
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }
  updateProduct(formData:FormData)  : Observable<any>
  {
    return this.http.post(`${this.apiUrl+"/update"}`,formData);
  }
  updateStatus(product:Product)  : Observable<any>
  {
    return this.http.patch(`${this.apiUrl}/${product.pid}`,product);
  }
  getActiveProducts()    : Observable<Product[]>
  {
    return this.http.get<Product[]>(`${this.apiUrl+"/active"}`);
  }
  getProductByCategory(category:number)  : Observable<Product[]>
  {
    return this.http.get<Product[]>(`${this.apiUrl+"/category"}/${category}`);
  }
  getFewProducts()  : Observable<Product[]>
  {
    return this.http.get<Product[]>(`${this.apiUrl+"/few"}`);
  }
}
