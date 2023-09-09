import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../services/transaction.service';
import { User } from '../classes/user';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent implements OnInit {

  //user:User = new User;
  balance:number;
  constructor(
    private transactionService : TransactionService
  ) { }

  ngOnInit(): void {
   this.getBalance();
  }

  getBalance()
  {
    this.transactionService.getBalance(sessionStorage.getItem("user")).subscribe(data=>{
      this.balance = Number(data);
      sessionStorage.setItem("balance",data.toString());
    });

    
  }
}
