import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../classes/user';

@Component({
  selector: 'app-client-navbar',
  templateUrl: './client-navbar.component.html',
  styleUrls: ['./client-navbar.component.css']
})
export class ClientNavbarComponent implements OnInit {

  user:User = new User;

  
  constructor(private router :Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("user"));
  }

  logout()
  {
    sessionStorage.clear();
    this.router.navigate(['']);
  }
}
