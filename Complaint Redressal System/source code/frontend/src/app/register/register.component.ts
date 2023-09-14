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

  newUser:User = new User;
  
  constructor(
    private builder:FormBuilder,
    private userService:UserService
  ) { }

  ngOnInit(): void {
  }

  registerForm = this.builder.group({
    
    username : this.builder.control('',[Validators.required,Validators.minLength(3)]),
    address : this.builder.control('',[Validators.required]),
    phoneNo : this.builder.control('',[Validators.minLength(10),Validators.maxLength(10),Validators.required]),
    email : this.builder.control('',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
    password : this.builder.control('',[Validators.required]),
    pincode : this.builder.control('',[Validators.required])
  })

  registerUser()
  {
    this.newUser = this.registerForm.value;
    this.newUser.role = "client";
    this.userService.saveUser(this.newUser).subscribe((data:any)=>{
      alert(data?.message);
    },(error)=>{
      alert(error.error?.message);
    });
  }
}
