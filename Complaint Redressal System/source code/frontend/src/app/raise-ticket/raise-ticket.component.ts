import { Component, OnInit } from '@angular/core';
import { Complaint } from '../classes/complaint';
import { ComplaintService } from '../services/complaint.service';
import { FormBuilder, Validators } from '@angular/forms';
import { tick } from '@angular/core/testing';

@Component({
  selector: 'app-raise-ticket',
  templateUrl: './raise-ticket.component.html',
  styleUrls: ['./raise-ticket.component.css']
})
export class RaiseTicketComponent implements OnInit {

  ticket:Complaint = new Complaint;
  complaint:string;
  msg:string;
  constructor(
    private complaintService:ComplaintService
  ) { }

  ngOnInit(): void {
  }

  raiseTicket(){
    this.ticket.complaint = this.complaint;
    this.ticket.status = "Raised";
    this.ticket.timestamp = new Date();
    this.ticket.user = JSON.parse(sessionStorage.getItem("user"));
    this.complaintService.saveComplaint(this.ticket).subscribe((data:any)=>{
      alert(data?.message);
      this.complaint=null;
    });
  }

}
