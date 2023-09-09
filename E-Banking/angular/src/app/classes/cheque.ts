import { User } from "./user";

export class Cheque {
    chequeid:number;
    chequenumber:number;
    bank:string;
    chequedate:Date;
    amount:number;
    ifsccode:string;
    payee:User;
}
