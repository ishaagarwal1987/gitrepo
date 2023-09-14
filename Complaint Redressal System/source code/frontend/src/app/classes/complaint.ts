import { Feedback } from "./feedback";
import { Fieldwork } from "./fieldwork";
import { User } from "./user";

export class Complaint {
    complaintid:number;
    user:User;
    complaint:string;
    engineerAssigned:User;
    status:string;
    timestamp:Date;
    feedback:Feedback;
    fieldwork:Fieldwork;
}
