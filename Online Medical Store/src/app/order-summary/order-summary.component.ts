import { Component, OnInit } from '@angular/core';
import { Order } from '../classes/order';
import { OrderService } from '../services/order.service';
import { Orderdetails } from '../classes/orderdetails';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {

  counter:number =0;
  orderDetails:Orderdetails[] = [];
  order:Order = new Order;
  
  constructor(
    private orderService : OrderService
  ) { }

  ngOnInit(): void {
    this.getDetails();
  }

  getDetails()
  {
    this.order = JSON.parse(sessionStorage.getItem("order"));

    this.orderService.getOrderDetails(this.order.orderid).subscribe(data=>{
    this.orderDetails = data;
    });
  }

}
