import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { ComplaintService } from '../services/complaint.service';
import { Complaint } from '../classes/complaint';
import { UserService } from '../services/user.service';
import { Fieldwork } from '../classes/fieldwork';
import { FieldworkService } from '../services/fieldwork.service';

@Component({
  selector: 'app-complaint-employee-page',
  templateUrl: './complaint-employee-page.component.html',
  styleUrls: ['./complaint-employee-page.component.css']
})
export class ComplaintEmployeePageComponent implements OnInit {

  engineers:User[]=[];
  complaints:Complaint[]=[];
  user:User = new User;
  eng:User = new User;
  fieldWorkers:User[] =[];
  fieldWork:Fieldwork=new Fieldwork;
  fieldWorker:User = new User;
  
  constructor(
    private complaintService:ComplaintService,
    private userService:UserService,
    private fieldworkService : FieldworkService
  ) { }

  ngOnInit(): void {
    this.displayComplaints();
  }

  displayComplaints()
  {
    
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user.role=="manager"){
      this.complaintService.getAllComplaints().subscribe(data=>{
        this.complaints = data;
      })
  
      this.userService.getUsersByUserType("engineer").subscribe(data=>{
        this.engineers=data;
      });
    }
    else if(this.user.role=="engineer")
    {
      this.complaintService.getComplaintsByEngineerAssigned(sessionStorage.getItem("user")).subscribe(data=>{
        this.complaints = data;
      });
      this.userService.getUsersByUserType("fieldworker").subscribe(data=>{
        this.fieldWorkers=data;
      });
    }
    
  }
  onSelected(value:string,complaint:Complaint)
  {
    complaint.status = value;
  }
  onEngineerAssigned(e:any,complaint:Complaint)
  {
    for(this.eng of this.engineers)
    {
      if(this.eng.userid == Number(e.target.value))
      {
        complaint.engineerAssigned = this.eng;
        break;
      }
    }
    //alert(complaint.engineerAssigned.username);
  }
  updateComplaint(complaint:Complaint)
  {//alert("hello");
   this.complaintService.updateComplaint(complaint.complaintid,JSON.stringify(complaint)).subscribe((data:any)=>{
    alert(data?.message);
   });
   //alert(this.fieldWork);
   if(this.user.role=="engineer" && this.fieldWork!=null)
   {
    this.fieldworkService.addFieldwork(this.fieldWork).subscribe((data:any)=>{
      alert(data?.message);
    });
   }
  }
  onFieldWorkerAssigned(e:any,complaint:Complaint)
  {
    
    for(this.fieldWorker of this.fieldWorkers)
    {
      if(this.fieldWorker.userid == Number(e.target.value))
      {
        this.fieldWork.complaint=complaint;
        this.fieldWork.fieldworker = this.fieldWorker;
        break;
      }
    }

  }
}
