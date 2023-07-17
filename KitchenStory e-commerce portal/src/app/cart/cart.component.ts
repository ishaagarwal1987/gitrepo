import { Component, OnDestroy, OnInit } from '@angular/core';
import { Cart } from '../classes/cart';
import { CartService } from '../services/cart.service';
import { Subscription, pipe } from 'rxjs';
import { Order } from '../classes/order';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
 
  orderObj : Order = new Order();
  user : string ="";
  carts:Cart[] = [];
  subtotal:number=0;
  discount:number=45;
  deliveryCharges:number = 0;
  total:number=0;

  address:string;
  
  constructor(private cartService : CartService,private orderService : OrderService) { }
 
  ngOnInit(): void {
    this.getcart();
    //this.calculateBill();
  }

  getcart()
  {
    this.user = sessionStorage.getItem("user");
    this.cartService.getCartByUser(this.user).subscribe(ref=>{
      this.carts=ref;
      //console.log("carts1 = " +this.carts );
    });
    
  }
  
  deleteFromCart(id:any)
  {
    this.cartService.deleteProductFromCart(id).subscribe(data=>{
      this.carts=data;
    });
  }
  calculateBill()
  {console.log("carts = " +this.carts );
    for(var i in this.carts)
    {
      this.subtotal = this.subtotal + this.carts[i].amount;
    }
    this.total = this.subtotal + this.deliveryCharges - this.discount;
  }
  placeOrder()
  {
    this.orderObj.user = JSON.parse(sessionStorage.getItem("user"));
    this.orderObj.createdOn = new Date().toLocaleDateString();
    this.orderObj.shippingAddress = this.address;
    this.orderObj.subTotal = this.subtotal;
    this.orderObj.deliveryCharges = this.deliveryCharges;
    this.orderObj.discount = this.discount;
    this.orderObj.totalAmount = this.total;
    this.orderObj.status = "placed";

    this.orderService.saveOrder(this.orderObj).subscribe(data=>{
      alert("Order Placed Successfully.");
    });
  }

}
