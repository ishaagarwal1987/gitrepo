import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Result } from '../result';


@Injectable({
  providedIn: 'root'
})
export class ResultService {

  private apiUrl =" http://localhost:3000/results";
  constructor(private http:HttpClient) { }

  saveResult(result: Result) : Observable<any>
  {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(result);
    return this.http.post(this.apiUrl,body,{'headers':headers});
  }

  getResult(userid:string) : Observable<any>
  {
    return this.http.get(this.apiUrl+"?userid="+userid);
  }
  deleteResult(userid:string) : Observable<any>
  {
    return this.http.delete(this.apiUrl+"?userid="+userid);
  }

}
