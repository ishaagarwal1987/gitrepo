import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Transaction } from '../classes/transaction';
import { User } from '../classes/user';
import { TransactionService } from '../services/transaction.service';
import { Cheque } from '../classes/cheque';
import { UserService } from '../services/user.service';
import { map, mergeMap} from 'rxjs/operators';

@Component({
  selector: 'app-transfer-money',
  templateUrl: './transfer-money.component.html',
  styleUrls: ['./transfer-money.component.css']
})
export class TransferMoneyComponent implements OnInit {

  anotherTransaction: Transaction = new Transaction;
  cheque: Cheque = new Cheque;
  selectedOption: string;
  particularvalue: string = "";
  user: User = new User;
  transaction: Transaction = new Transaction;
  previousBalance: number;

  anotherUser: User = new User;
  anotherUserBalance: number = 0;


  constructor(
    private builder: FormBuilder,
    private transactionService: TransactionService,
    private userService: UserService
  ) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.transactionService.getBalance(sessionStorage.getItem("user")).subscribe(data => {
      this.previousBalance = Number(data);
    });
  }

  transactionForm = this.builder.group({
    particulars: this.builder.control('', [Validators.required]),
    debitamount: this.builder.control(''),
    creditamount: this.builder.control(''),
    chequenumber: this.builder.control(''),
    chequedate: this.builder.control(''),
    ifsccode: this.builder.control(''),
    payee: this.builder.control(''),
    bank: this.builder.control(''),
    amount: this.builder.control(''),
    receiverAccountNo: this.builder.control('')
  })
  doTransaction() {
    this.particularvalue = this.transactionForm.value.particulars;
    if (this.particularvalue == '1') {
      this.cashDeposit();
    }
    else if (this.particularvalue == '2') {
      this.cashWithdraw();
    }
    else if (this.particularvalue == '3') {
      this.getAnotherUser(Number(this.transactionForm.value.payee));
        
     
      
    }
    else if (this.particularvalue == '4') {
      this.getAnotherUser(Number(this.transactionForm.value.receiverAccountNo)); 
      
    }
  }

  cashDeposit() {
    const formData = new FormData();
    this.transaction.accountno = this.user;
    this.transaction.timestamp = new Date();
    this.transaction.particulars = "Cash Deposit By Self";
    this.transaction.creditamount = Number(this.transactionForm.value.creditamount);
    this.transaction.balance = this.previousBalance + Number(this.transaction.creditamount);
    this.transaction.cheque = null;
    this.transaction.debitamount = null;

    formData.append("cheque", null);
    formData.append("transaction", JSON.stringify(this.transaction));

    this.transactionService.saveTransaction(formData).subscribe((data:any) => {
      alert(data?.message);
    });
  }

  cashWithdraw() {
    if (this.previousBalance < Number(this.transactionForm.value.debitamount)) {
      alert("Insufficient Balance.");
    }
    else {
      const formData = new FormData();
      this.transaction.accountno = this.user;
      this.transaction.timestamp = new Date();
      this.transaction.particulars = "Cash Withdraw By Self";
      this.transaction.creditamount = null;
      this.transaction.cheque = null;
      this.transaction.debitamount = Number(this.transactionForm.value.debitamount);
      this.transaction.balance = this.previousBalance - Number(this.transaction.debitamount);
      formData.append("cheque", null);
      formData.append("transaction", JSON.stringify(this.transaction));
      this.transactionService.saveTransaction(formData).subscribe(data => {
        alert("Transaction Done Successfully. Your balance is " + this.transaction.balance + " INR");
      });
    }
  }

  chequeDeposit() {
    //this.getAnotherUser(Number(this.transactionForm.value.payee));
    //this.getAnotherUserBalance(this.anotherUser);
    //alert("Payee Balance = "+this.anotherUserBalance);
    //alert("dEBIT Amount : " + Number(this.transactionForm.value.amount));
    //if (this.anotherUserBalance < Number(this.transactionForm.value.amount)) {
    //  alert("Insufficient Balance.");
    //}
    //else {
      {alert("Payee Balance = "+this.anotherUserBalance);
    const formData = new FormData();
    this.transaction.accountno = this.user;
    this.transaction.timestamp = new Date();
    this.transaction.particulars = "Cheque Received from " + this.anotherUser.name;
    
    this.cheque.chequenumber = this.transactionForm.value.chequenumber;
    this.cheque.chequedate = this.transactionForm.value.chequedate;
    this.cheque.bank = this.transactionForm.value.bank;
    this.cheque.ifsccode = this.transactionForm.value.ifsccode;
    this.cheque.payee = this.anotherUser;
    this.cheque.amount = Number(this.transactionForm.value.amount);
    
    this.transaction.debitamount = null;
    this.transaction.creditamount = this.cheque.amount;
    this.transaction.cheque = this.cheque;
    this.transaction.balance = this.previousBalance + Number(this.transaction.creditamount);
    //alert("Receiver Transaction : " + JSON.stringify(this.transaction));
    formData.append("cheque", JSON.stringify(this.cheque));
    formData.append("transaction", JSON.stringify(this.transaction));
    this.transactionService.saveTransaction(formData).subscribe((data:any) => {
      alert(data?.message);
    });

    this.anotherTransaction.timestamp = new Date();
    this.anotherTransaction.particulars = "Cheque Transfer to " + this.user.name;
    this.anotherTransaction.debitamount=this.cheque.amount;
    this.anotherTransaction.creditamount = null;
    this.anotherTransaction.balance = this.anotherUserBalance - this.cheque.amount;
    this.anotherTransaction.accountno = this.cheque.payee
    this.anotherTransaction.cheque =this.cheque;
   // alert("Payee Transaction : " + JSON.stringify(this.anotherTransaction));
    const formData1 = new FormData();

    formData1.append("transaction", JSON.stringify(this.anotherTransaction));
    formData1.append("cheque", JSON.stringify(this.cheque));

    this.transactionService.saveTransaction(formData1).subscribe((data:any) => {
      alert(data?.message);
    });
  }
  }
  moneyTransferToAnotherAccount() {
    if (this.previousBalance < Number(this.transactionForm.value.debitamount)) {
      alert("Insufficient Balance.");
    }
    else {
      // this.getAnotherUser(Number(this.transactionForm.value.receiverAccountNo));   
      //this.getAnotherUserBalance(this.anotherUser);

      const formData = new FormData();
      this.transaction.accountno = this.user;
      this.transaction.timestamp = new Date();
      this.transaction.particulars = "Money Transfer To " + this.anotherUser.name;
      this.transaction.creditamount = null;
      this.transaction.cheque = null;
      this.transaction.debitamount = this.transactionForm.value.debitamount;
      this.transaction.balance = this.previousBalance - Number(this.transaction.debitamount);
      //alert(this.transaction);
      formData.append("cheque", null);
      formData.append("transaction", JSON.stringify(this.transaction));
      this.transactionService.saveTransaction(formData).subscribe((data:any) => {
        alert(data?.message);
      });

      //Another Acoount Transaction

      this.anotherTransaction.timestamp = new Date();
      this.anotherTransaction.particulars = "Money Transfer from " + this.user.name;
      this.anotherTransaction.cheque = null;
      this.anotherTransaction.debitamount = null;
      this.anotherTransaction.creditamount = this.transactionForm.value.debitamount;
      this.anotherTransaction.accountno = this.anotherUser;
      this.anotherTransaction.balance = this.anotherUserBalance + Number(this.anotherTransaction.creditamount);

      const formData1 = new FormData();
      formData1.append("transaction", JSON.stringify(this.anotherTransaction));
      formData1.append("cheque", null);
      //alert(this.anotherTransaction);
      this.transactionService.saveTransaction(formData1).subscribe(data => {
        alert("Money Transfered to " + this.anotherUser.name + " Your Balance is " + this.transaction.balance);
      });
    }
  }

  getAnotherUser(accountno: number) {
    this.userService.getUserByAccountNo(accountno).subscribe(data => {
      this.anotherUser = data;
      //alert("User " + this.anotherUser.name);
      this.transactionService.getBalance(JSON.stringify(this.anotherUser)).subscribe(data => {
        this.anotherUserBalance = Number(data);
        //alert("Another User Balance : "+this.anotherUserBalance );
        if (this.particularvalue == '3') {
        this.chequeDeposit();}
        else if (this.particularvalue == '4') {
        this.moneyTransferToAnotherAccount();}
      });
      
    });
  }
  selectedvalue() {
    this.particularvalue = this.transactionForm.value.particulars;
    // alert(this.particularvalue);
  }

}


