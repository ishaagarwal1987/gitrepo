import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from '../classes/transaction';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private apiUrl ="http://localhost:8080/transaction";

  constructor(private http:HttpClient) { }

  saveTransaction(formData:FormData)
  {
    return this.http.post(`${this.apiUrl}`,formData);
  }

  getTransactions(user:string): Observable<Transaction[]>
  {
    return this.http.get<Transaction[]>(`${this.apiUrl}/${user}`);
  }
  getBalance(user:string)
  {
    return this.http.get(`${this.apiUrl+"/balance"}/${user}`);
  }
}
