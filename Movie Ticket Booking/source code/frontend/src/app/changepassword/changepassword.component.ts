import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  user:User = new User;
  pass:string;
  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  updatePassword()
  {
    this.user=JSON.parse(sessionStorage.getItem("user"));
    this.user.password = this.pass;
    this.userService.updatePassword(this.user.userid,this.user).subscribe((data:any)=>{
      alert(data?.message);
    },(error:any)=>{
      alert(error?.message);
    });
  }
  

}
