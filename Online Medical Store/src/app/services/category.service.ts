import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../classes/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apiUrl ="http://localhost:8080/categories";

  constructor(private http:HttpClient) { }

  saveCategory(category:string)
  {
    return this.http.post(`${this.apiUrl+"/add"}`,category);
  }
  getCategories() : Observable<Category[]>
  {
    return this.http.get<Category[]>(`${this.apiUrl}`);
  }
  editCategory(id: number, value: any) : Observable<Category[]>
  {
    return this.http.put<Category[]>(`${this.apiUrl}/${id}`,value);
  }
  removeCategory(id: number) : Observable<any>
  {
    return this.http.delete(`${this.apiUrl}/${id}`, {responseType: 'text'});
  }

}
