import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { Router } from '@angular/router';
import { Cart } from '../classes/cart';

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css']
})
export class ClientDashboardComponent implements OnInit {

  //cartCount:number = Cart.count ;
  user:User = new User;
  constructor(private router :Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    //this.cartCount = JSON.parse(sessionStorage.getItem("cartCount"));
  }
  logout(){
    sessionStorage.clear();
    this.router.navigate(['']);
  }
}
