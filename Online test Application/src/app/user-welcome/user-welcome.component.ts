import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-welcome',
  templateUrl: './user-welcome.component.html',
  styleUrls: ['./user-welcome.component.css']
})
export class UserWelcomeComponent implements OnInit {

  name:string="";
  constructor() { }

  ngOnInit(): void {
    this.name = localStorage.getItem("name");
  }

}
