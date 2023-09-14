import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  user: User = new User;
  saveUserBlock: boolean = false;
  displayUserBlock: boolean = false;
  heading: string = "Users";
  btnvalue: string;

  constructor(
    private builder: FormBuilder,
    private userService: UserService) { }

  ngOnInit(): void {
  }

  registerForm = this.builder.group({
    userid: this.builder.control(''),
    username: this.builder.control('', [Validators.required, Validators.minLength(3)]),
    address: this.builder.control('', [Validators.required]),
    phoneNo: this.builder.control('', [Validators.minLength(10), Validators.maxLength(10), Validators.required]),
    email: this.builder.control('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
    password: this.builder.control('', [Validators.required]),
    pincode: this.builder.control('', [Validators.required]),
    role: this.builder.control('', [Validators.required])
  })


  displayUsers(usertype: string) {
    this.saveUserBlock = false;
    this.displayUserBlock = true;
    this.btnvalue = "Register User";
    this.userService.getUsersByUserType(usertype).subscribe(data => {
      this.users = data;
      this.heading = "All " + usertype + "s";
    });
  }
  saveUser() {
    this.saveUserBlock = true;
    this.displayUserBlock = false;
    this.heading = "Add User";
    this.registerForm.reset();
    this.btnvalue = "Register"
  }

  registerUser() {
    this.user = this.registerForm.value;
    if (this.btnvalue == "Register") {

      this.userService.saveUser(this.user).subscribe((data: any) => {
        alert(data?.message);
      }, (error) => {
        alert(error.error?.message);
      });
    }
    else if (this.btnvalue == "Update User") {
      this.userService.updateUser(this.user.userid, this.user).subscribe((data: any) => {
        alert(data?.message);
      }, (error) => {
        alert(error.error?.message);
      });
    }
  }
  deleteUser(user: User) {
    this.userService.deleteUser(user.userid).subscribe((data: any) => {
      alert(data?.message);
      this.displayUsers(user.role);
    });
  }
  updateUser(user: User) {
    this.registerForm.controls["userid"].setValue(user.userid);
    this.registerForm.controls["username"].setValue(user.username);
    this.registerForm.controls["password"].setValue(user.password);
    this.registerForm.controls["address"].setValue(user.address);
    this.registerForm.controls["phoneNo"].setValue(user.phoneNo);
    this.registerForm.controls["email"].setValue(user.email);
    this.registerForm.controls["pincode"].setValue(user.pincode);
    this.registerForm.controls["role"].setValue(user.role);
    this.saveUserBlock = true;
    this.displayUserBlock = false;
    this.heading = "Update User";
    this.btnvalue = "Update User";
  }

}
