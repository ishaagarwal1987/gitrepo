import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../classes/user';

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css']
})
export class ClientDashboardComponent implements OnInit {

  user:User = new User;
  constructor(private router :Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("user"));
  }
  logout(){
    sessionStorage.clear();
    this.router.navigate(['']);
  }
  isActive()
  {
    if(this.user.isactive)
    {
      this.router.navigate(['transfer']);
    }
    else
    {
      alert("Sorry!! You are not authorized to do any transactions. Please Contact your branch.");
    }
  }
}
