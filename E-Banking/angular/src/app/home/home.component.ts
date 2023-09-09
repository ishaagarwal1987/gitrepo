import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../classes/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user: User = new User;
  accountno: string;
  password: string;
  msg: string;
  
  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  checkUser() {
    const formdata = new FormData();
    formdata.append("accountNo", this.accountno);
    formdata.append("password", this.password);
    this.userService.getUser(formdata).subscribe(data => {
      this.user = data;
    });
    if (this.user == null) {
      alert("Invalid Username and Password.")
    }
    else if(!this.user.permissionGranted)
    {
      alert("Sorry!! Your account has been blocked.");
    }
    else if (this.user.role == "admin") {
      sessionStorage.setItem("user", JSON.stringify(this.user));
      //alert("Hii admin");
      this.router.navigate(['users']);
    }
    else if (this.user.role == "client") {
      sessionStorage.setItem("user", JSON.stringify(this.user));
      
       this.router.navigate(['balance']);
      }
  }  
}
