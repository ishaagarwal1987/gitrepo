import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from '../services/user-service.service';


@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  msg:string ="";
  constructor(
    private builder: FormBuilder,
    private userService :UserServiceService
  ) { }

  ngOnInit(): void {
  }

  regForm = this.builder.group({
    username: this.builder.control('', Validators.required),
    password: this.builder.control('', Validators.required),
    email: this.builder.control('', Validators.required),
    phoneNo: this.builder.control('', Validators.required)
  });

  registerUser()
  {
    this.userService.saveUser(this.regForm.value).subscribe(data=>{
      this.msg="User registered Successfully!";
    });

    this.regForm.reset;
    
  }

}
