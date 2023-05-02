import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg: string = "";
  //@ViewChild('username') nameKey!: ElementRef;
  
  constructor(
    private router: Router,
    private builder: FormBuilder,
    private userService:UserServiceService) {sessionStorage.clear(); }

  ngOnInit(): void {
  }

  loginForm = this.builder.group({
    username: this.builder.control('', Validators.required),
    password: this.builder.control('', Validators.required)
  });

  CheckUser() {
    if (this.loginForm.valid) {
      //localStorage.setItem("name",this.nameKey.nativeElement.value);
      if (this.loginForm.value.username == "admin" && this.loginForm.value.password == "12345") {
        {
          sessionStorage.setItem('userdetails', this.loginForm.value.username);
          this.router.navigate(['/adminWelcome']);
        }
           
      }
      else
        {
          this.userService.getAllUsers().subscribe(data=>{
            const user = data.find((a:any)=>{
              return a.username === this.loginForm.value.username && a.password === this.loginForm.value.password
            });
            if(user)
            {
              this.msg = "Login Success";
              sessionStorage.setItem('userdetails', this.loginForm.value.username);
              sessionStorage.setItem('userId', user.id);
              this.router.navigate(['/userWelcome']);
            }
            else
              this.msg = "Invalid Username";
          });

        }
    }
    else
      this.msg = "Please fill the login credentials.";
  }

}


