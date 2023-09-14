import { Component, OnInit } from '@angular/core';
import { Complaint } from '../classes/complaint';
import { ComplaintService } from '../services/complaint.service';
import { Feedback } from '../classes/feedback';
import { FeedbackService } from '../services/feedback;.service';
import { User } from '../classes/user';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})
export class ComplaintsComponent implements OnInit {

  complaints:Complaint[]=[];
  feedbackInput:string;
  displayStyle:string = "none";
  comp:Complaint = new Complaint;
  feedback:Feedback = new Feedback;
  user:User = new User;

  constructor(
    private complaintService:ComplaintService,
    private feedbackService:FeedbackService
    ) { }

  ngOnInit(): void {
    this.displayComplaints();
  }

  displayComplaints()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user.role == "admin")
    {
      this.complaintService.getAllComplaints().subscribe(data=>{
        this.complaints = data;
      })
    }
    else if(this.user.role == "client")
    {
      this.getComplaints();
    }

  }

  getComplaints()
  {
    this.complaintService.getComplaintsByUser(sessionStorage.getItem("user")).subscribe(data=>{
      this.complaints = data;
    });
  }

  openFeedbackPopup(complaint:Complaint)
  {
    this.comp = complaint;
    this.displayStyle="block"
  }
  closePopup() {
    this.displayStyle = "none";
  }
  sendFeedback()
  {
    this.feedback.complaint = this.comp;
    this.feedback.feedback = this.feedbackInput;
    //this.comp.feedback = this.feedback;
    this.feedbackService.addFeedback(this.feedback).subscribe((data:any)=>{
      alert(data?.message);
      this.closePopup();
    });

  }
}
