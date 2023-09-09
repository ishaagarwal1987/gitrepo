import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-profilesettings',
  templateUrl: './profilesettings.component.html',
  styleUrls: ['./profilesettings.component.css']
})
export class ProfilesettingsComponent implements OnInit {

  user:User = new User;
  constructor(
    private builder:FormBuilder,
    private userService:UserService
  ) { }

  ngOnInit(): void {
    this.getDetails();
  }

  registerForm = this.builder.group({
    
    name : this.builder.control('',[Validators.required,Validators.minLength(3)]),
    address : this.builder.control('',[Validators.required]),
    phoneNo : this.builder.control('',[Validators.minLength(10),Validators.maxLength(10),Validators.required]),
    email : this.builder.control('',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
    })
  updateUser()
  {
    this.user.name = this.registerForm.value.name;
    this.user.address = this.registerForm.value.address;
    this.user.phoneNo = this.registerForm.value.phoneNo;
    this.user.email = this.registerForm.value.email;

    this.userService.saveUser(this.user).subscribe((data:any)=>{
      alert("Details Updated.");
    },(error)=>{
      alert(error.error?.message);
    });
  }
  getDetails()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.registerForm.controls["name"].setValue(this.user.name);
    this.registerForm.controls["address"].setValue(this.user.address);
    this.registerForm.controls["phoneNo"].setValue(this.user.phoneNo);
    this.registerForm.controls["email"].setValue(this.user.email);
  }
}
