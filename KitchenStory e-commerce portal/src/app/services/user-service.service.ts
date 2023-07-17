import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../classes/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private apiUrl ="http://localhost:8080/users";

  constructor(private http:HttpClient) { }

  getAllUsers() : Observable<User[]>
  {
    return this.http.get<User[]>(`${this.apiUrl}`);
  }

  saveUser(user:User) : Observable<Object>
  {
    return this.http.post(`${this.apiUrl}`,user);
  }

  getUserById(id:number) : Observable<User>
  {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }

  deleteUserById(id:number) : Observable<Object>
  {
    return this.http.delete<User>(`${this.apiUrl}/${id}`);
  }

  updateUser(user:User) : Observable<Object>
  {
    return this.http.put<User>(`${this.apiUrl}`,user);
  }


}
