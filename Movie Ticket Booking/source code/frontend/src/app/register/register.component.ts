import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:User = new User;
  
  constructor(
    private builder:FormBuilder,
    private userService:UserService
  ) { }

  ngOnInit(): void {
  }

  registerForm = this.builder.group({
    
    username : this.builder.control('',[Validators.required,Validators.minLength(3)]),
    phoneNo : this.builder.control('',[Validators.minLength(10),Validators.maxLength(10),Validators.required]),
    email : this.builder.control('',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
    password : this.builder.control('',[Validators.required])
  })

  registerUser()
  {
    this.user = this.registerForm.value;
    this.user.role = "client";
    this.userService.saveUser(this.user).subscribe((data:any)=>{
      alert(data?.message);
    },(error)=>{
      alert(error.error?.message);
    });
  }

}
