import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  userobj: User = new User();
  users: User[] = [];
  constructor(private userService : UserServiceService) { }

  ngOnInit(): void {
    this.displayUsers();
  }

  displayUsers()
  {
    this.userService.getAllUsers().subscribe(data=>{
    this.users=data;
    });
  }
}
