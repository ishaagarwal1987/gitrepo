import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from '../classes/feedback';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private apiUrl ="http://localhost:8080/feedbacks";

  constructor(private http:HttpClient) { }

  addFeedback(feedback:Feedback)
  {
    return this.http.post(`${this.apiUrl}`,feedback);
  }
  getFeedback() : Observable<Feedback[]>
  {
    return this.http.get<Feedback[]>(`${this.apiUrl}`);
  }
}
