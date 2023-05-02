import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../services/user-service.service';
import { Router } from '@angular/router';
import { ResultService } from '../services/result.service';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  users:any=[];

  constructor(
    private router: Router,
    private userService:UserServiceService,
    private resultService:ResultService
    ) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers()
  {
     this.userService.getAllUsers().subscribe(data=>{
      this.users=data;
     });
  }
  viewResult(userid:string)
  {
    sessionStorage.setItem('userId', userid);
    this.router.navigate(['/viewResult']);
  }

  deleteUser(userid:any)
  {
    this.userService.deleteUser(userid).subscribe(data=>{
      this.getUsers();
    });
    this.resultService.deleteResult(userid);
    
  }

}
