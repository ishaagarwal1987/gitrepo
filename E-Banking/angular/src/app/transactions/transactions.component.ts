import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TransactionService } from '../services/transaction.service';
import { Transaction } from '../classes/transaction';
import { User } from '../classes/user';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  transactions : Transaction[] = [];
  user :User = new User;

  constructor(
    private transactionService : TransactionService
  ) { }

  ngOnInit(): void {
    this.getTransactions();
  }

  getTransactions()
  {
    this.transactionService.getTransactions(sessionStorage.getItem("user")).subscribe(data=>{
      this.transactions = data;
    });
  }
}
