import { Component, OnInit } from '@angular/core';
import { OrderService } from '../services/order.service';
import { Order } from '../classes/order';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders : Order[] = [];
  constructor(private orderService : OrderService) { }

  ngOnInit(): void {
    this.getOrders();
  }

  getOrders()
  {
    if(sessionStorage.getItem('userdetails')=='admin')
    {
      this.orderService.getOrder().subscribe(data=>{this.orders = data;});
    }
    else{
      this.orderService.getOrderUser(sessionStorage.getItem('user')).subscribe(data=>{this.orders = data;});
    }
  }
  openModifyPopup(id:number)
  {

  }
}
