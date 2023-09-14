import { Injectable } from '@angular/core';
import { Complaint } from '../classes/complaint';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../classes/user';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {
  private apiUrl ="http://localhost:8080/complaints";

  constructor(private http:HttpClient) { }

  saveComplaint(complaint:Complaint) 
  {
    return this.http.post(`${this.apiUrl}`,complaint);
  }
  getAllComplaints() : Observable<Complaint[]>
  {
    return this.http.get<Complaint[]>(`${this.apiUrl}`);
  }
  
  getComplaintsByUser(user:string): Observable<Complaint[]>
  {
    return this.http.get<Complaint[]>(`${this.apiUrl+"/user"}/${user}`);
  }
  updateComplaint(id: number, value: String)
  {
    return this.http.put(`${this.apiUrl}/${id}`,value);
  }
  getComplaintsByEngineerAssigned(engineer:string): Observable<Complaint[]>
  {
    return this.http.get<Complaint[]>(`${this.apiUrl+"/engineer"}/${engineer}`);
  }
}
