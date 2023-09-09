import { User } from "./user";

export class ChequebookRequest {
    requestid:number;
    accountno:User;
    chequebookstatus:string;
    requestdate:Date;
    acceptedDate:Date
}
