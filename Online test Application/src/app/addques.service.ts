import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddquesService {

  private apiUrl =" http://localhost:3000/questions";
  constructor(private http:HttpClient) { }

  saveQuestion(ques:any) : Observable<any>
  {
    return this.http.post(this.apiUrl,ques);
  }

  getQuestions() : Observable<any>
  {
    return this.http.get(this.apiUrl);
  }
  getQuestionById(id:any) : Observable<any>
  {
    return this.http.get(this.apiUrl + '/' + id);
  }
}
