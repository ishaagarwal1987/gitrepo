import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:User = new User;
  userCreated : User = new User;
  constructor(
    private builder:FormBuilder,
    private userService:UserService
    ) { }

  ngOnInit(): void {
  }

  registerForm = this.builder.group({
    
    name : this.builder.control('',[Validators.required,Validators.minLength(3)]),
    address : this.builder.control('',[Validators.required]),
    phoneNo : this.builder.control('',[Validators.minLength(10),Validators.maxLength(10),Validators.required]),
    email : this.builder.control('',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
    password : this.builder.control('',[Validators.required])
  })
  registerUser(){
    this.user = this.registerForm.value;
    this.user.role = "client";
    this.user.createdon = new Date();
    this.user.isactive = true;
    this.user.permissionGranted=true;
    
    this.userService.saveUser(this.user).subscribe((data:any)=>{
      this.userCreated = data;
      alert("Account Created. Your Account Number is : " + this.userCreated.accountno);
    },(error)=>{
      alert(error.error?.message);
    });
  }
}
