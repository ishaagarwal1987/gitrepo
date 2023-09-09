import { Component, OnInit } from '@angular/core';
import { ChequebookRequest } from '../classes/chequebook-request';
import { User } from '../classes/user';
import { ChequebookrequestService } from '../services/chequebookrequest.service';

@Component({
  selector: 'app-chequebook',
  templateUrl: './chequebook.component.html',
  styleUrls: ['./chequebook.component.css']
})
export class ChequebookComponent implements OnInit {

  requests:ChequebookRequest[] = [];
  req:ChequebookRequest = new ChequebookRequest;
  user:User = new User;

  constructor(
    private requestsService : ChequebookrequestService
  ) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.getRequests();
  }

  sendRequest()
  {
    this.req.accountno = this.user;
    this.req.chequebookstatus="Pending";
    this.req.requestdate=new Date();

    this.requestsService.addRequest(this.req).subscribe((data:any)=>{
      alert(data?.message);
      this.getRequests();
    },(error)=>{
      alert(error.error?.message);
    });
    
  }
  getRequests()
  {
    this.requestsService.getAllRequestsByUser(sessionStorage.getItem("user")).subscribe(data=>{
      this.requests = data;
    });
  }

}
