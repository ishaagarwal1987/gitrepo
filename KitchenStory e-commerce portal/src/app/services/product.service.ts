import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl ="http://localhost:8080/products";
  constructor() { }

  saveProduct(formData :FormData) : Observable<Object>
  {
  
   // return this.http.post(`${this.apiUrl}`,formData, { responseType: 'text'});
   return null;
  }
}
