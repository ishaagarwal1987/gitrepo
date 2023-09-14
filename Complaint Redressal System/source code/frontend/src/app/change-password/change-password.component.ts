import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  user:User = new User;
  pass:string;

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }
  updatePassword()
  {
    this.user=JSON.parse(sessionStorage.getItem("user"));
    this.user.password = this.pass;
    this.userService.updateUser(this.user.userid,this.user).subscribe((data:any)=>{
      alert(data?.message);
    },(error:any)=>{
      alert(error?.message);
    });
  }
}
