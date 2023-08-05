import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { User } from '../classes/user';
import { CartService } from '../services/cart.service';
import { Cart } from '../classes/cart';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  cart: Cart = new Cart;
  user: User = new User;
  username: string;
  password: string;
  msg: string;

  constructor(
    private userService: UserService,
    private router: Router,
    private cartService: CartService
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
      this.router.navigate(['products']);
    }
    else if (this.user.role == "client") {
      sessionStorage.setItem("user", JSON.stringify(this.user));
      this.cart = JSON.parse(sessionStorage.getItem("cart"));
      if (this.cart != null) {
        this.cart.user = this.user;
        this.cartService.saveToCart(this.cart).subscribe((data: any) => {
          alert(data?.message);
          //Cart.count++;
        }, (error) => {
          alert(error?.message);
        });
        this.router.navigate(['/productdetails']);
      }
      else{
        this.router.navigate(['/viewProducts']);
      }

    }
  }
}
