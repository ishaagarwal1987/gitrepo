import { Component, OnInit } from '@angular/core';
import { ChequebookRequest } from '../classes/chequebook-request';
import { ChequebookrequestService } from '../services/chequebookrequest.service';

@Component({
  selector: 'app-view-chequebook-request',
  templateUrl: './view-chequebook-request.component.html',
  styleUrls: ['./view-chequebook-request.component.css']
})
export class ViewChequebookRequestComponent implements OnInit {

  requests:ChequebookRequest[] = [];
  
  constructor(private requestsService : ChequebookrequestService) { }

  ngOnInit(): void {
    this.getPendingRequests();
  }

  getPendingRequests()
  {
    this.requestsService.getPendingRequests().subscribe(data=>{
      this.requests = data;
    });
  }

  getAllRequests()
  {
    this.requestsService.getAllRequests().subscribe(data=>{
      this.requests = data;
    });
  }
  acceptRequest(req:ChequebookRequest)
  {
    req.acceptedDate = new Date();
    req.chequebookstatus = "Approved"
    this.requestsService.addRequest(req).subscribe(data=>{
      
    });
  }

}
