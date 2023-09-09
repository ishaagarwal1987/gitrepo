import { Cheque } from "./cheque";
import { User } from "./user";

export class Transaction {
    transactionid:number;
    accountno:User;
    timestamp:Date;
    particulars:string;
    cheque:Cheque;
    debitamount:number;
    creditamount:number;
    balance:number;
}
