import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../services/user-service.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  msg : string;
  constructor( private builder:FormBuilder,
    private userService:UserServiceService) { }

  ngOnInit(): void {
  }

  userRegForm = this .builder.group({
    username:this.builder.control('',Validators.required),
    password:this.builder.control('',Validators.required),
    email:this.builder.control('',Validators.required),
    phoneNo:this.builder.control('',Validators.required)
  });

  addUser()
  {
    this.userService.saveUser(this.userRegForm.value).subscribe(data=>{
      this.msg = "Registration Successfull."
      this.userRegForm.reset();
    });
  }
}
