import { Component, OnInit } from '@angular/core';
import { Order } from '../classes/order';
import { OrderService } from '../services/order.service';
import { Router } from '@angular/router';
import { User } from '../classes/user';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders:Order[] = [];
  user : User;
  
  constructor(
    private orderService : OrderService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));

    if(this.user.role=="admin")
    {
      this.orderService.getOrder().subscribe(data=>{
        this.orders = data;
      });
    }
    else{
      this.orderService.getOrderByUser(sessionStorage.getItem("user")).subscribe(data=>{
        this.orders = data;
      });
    }
    
  }

  viewdetail(orderObj : Order)
  {
    sessionStorage.setItem("order",JSON.stringify(orderObj));
    this.router.navigate(['/orderSummary']);
  }
}
