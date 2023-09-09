import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users : User[]=[];
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

  onActiveCheckboxChange(e, u: User)
  {
    if (e.target.checked) {
      u.isactive = true;

    } else {
      u.isactive = false;
    }

    this.userService.updateAutorization(u.accountno,u).subscribe((data:any) => {
      if(u.isactive)alert("User has been given permissions to do transactions.");
      else{alert("User has been blocked to do any transactions.")}
    }, (error) => {
      alert(error?.message);
    });

  }

  onPermissionCheckboxChange(e, u: User)
  {
    if (e.target.checked) {
      u.permissionGranted = true;

    } else {
      u.permissionGranted = false;
    }
    this.userService.updateAutorization(u.accountno,u).subscribe((data:any) => {
      if(u.permissionGranted)
      {alert("User has been unblocked.");}
      else{alert("User has been blocked.");}
    }, (error) => {
      alert(error?.message);
    });
  }
}
