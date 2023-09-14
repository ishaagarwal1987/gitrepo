import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl ="http://localhost:8080/users";

  constructor(private http:HttpClient) { }

  saveUser(user:User) 
  {
    return this.http.post(`${this.apiUrl}`,user);
  }
  getUser(formData :FormData) : Observable<User>
  {
    return this.http.post<User>(`${this.apiUrl+"/login"}`,formData);
  }
  
  getUsersByUserType(usertype:string): Observable<User[]>
  {
    return this.http.get<User[]>(`${this.apiUrl+"/usertype"}/${usertype}`);
  }
  updateUser(id: number, value: User)
  {
    return this.http.put(`${this.apiUrl}/${id}`,value);
  }
  deleteUser(id:number)
  {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
