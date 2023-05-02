import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private apiUrl =" http://localhost:3000/users";
  
  constructor(private http:HttpClient) { }
  
  saveUser(user:any) : Observable<any>
  {
    return this.http.post(this.apiUrl,user);
  }

  getAllUsers() : Observable<any>
  {
    return this.http.get(this.apiUrl);
  }

  deleteUser(id:any) : Observable<any>
  {
    return this.http.delete(this.apiUrl+"/"+id);
  }

}
