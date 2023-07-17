import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { User } from '../classes/user';
import { CartService } from '../services/cart.service';
import { Cart } from '../classes/cart';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  cart : Cart = new Cart();
  user:User =new User();
  username :string;
  password:string;
  msg:string;

  constructor(
    private cartService : CartService,
    private userService :UserServiceService,
    private router :Router
    ) { }

  ngOnInit(): void {
  }

  checkUser()
  {
    if(this.username=="admin" && this.password=="12345")
    {
      sessionStorage.setItem('userdetails', this.username);
      this.router.navigate(['/products']);
    }
    else{
      this.userService.getAllUsers().subscribe(data=>{
         this.user = data.find((a:any)=>{
          return a.username === this.username && a.password === this.password
        });
        if(this.user)
        {
          sessionStorage.setItem('userdetails', this.username);
          sessionStorage.setItem('user',JSON.stringify(this.user));
          this.cart = JSON.parse(sessionStorage.getItem('cart'));
          this.cart.user = this.user;
          //this.msg= sessionStorage.getItem('cart');
          this.cartService.saveToCart(this.cart).subscribe(data1=>{});
          this.router.navigate(['cart']);
         
        }
        else
          this.msg = "Invalid Username and password.";
      });
    }
  }

}
