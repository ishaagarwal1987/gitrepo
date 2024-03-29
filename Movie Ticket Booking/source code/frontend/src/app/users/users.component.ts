import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users:User[] = [];
  constructor(private userService:UserService) { }

  ngOnInit(): void {
    this.displayUsers();
  }

  displayUsers()
  {
    this.userService.getAllUsers().subscribe(data=>{
      this.users = data;
    });

  }

}
