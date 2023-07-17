import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  user:User =new User();
  username :string;
  password:string;
  msg:string;
  constructor(
    private userService :UserServiceService
  ) { }

  ngOnInit(): void {
  }

  updatePassword()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.user.password = this.password;
    this.userService.updateUser(this.user).subscribe(data=>{this.msg = "Password Updated!!";});
  }
}
