import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User;
  username: string;
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
    formdata.append("username", this.username);
    formdata.append("password", this.password);
    this.userService.getUser(formdata).subscribe(data => {
      this.user = data;
    });
    if (this.user == null) {
      this.msg = "Invalid Username and Password."
    }
    else if (this.user.role == "admin") {
      sessionStorage.setItem("user", JSON.stringify(this.user));
      //alert("Hii admin");
      this.router.navigate(['users']);
    }
    else if (this.user.role == "manager") {
      
      sessionStorage.setItem("user", JSON.stringify(this.user));
      this.router.navigate(['/complaintsEmployees']);
    }
    else if (this.user.role == "engineer") {
      sessionStorage.setItem("user", JSON.stringify(this.user));
      this.router.navigate(['/complaintsEmployees']);
    }
    else if (this.user.role == "client"){
      sessionStorage.setItem("user", JSON.stringify(this.user));
      this.router.navigate(['/raiseTicket']);
    }


  }
}
