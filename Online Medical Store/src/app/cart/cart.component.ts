import { Component, OnInit } from '@angular/core';
import { Cart } from '../classes/cart';
import { CartService } from '../services/cart.service';
import { User } from '../classes/user';
import { Order } from '../classes/order';
import { OrderService } from '../services/order.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  address : string;
  quantity:number;
  carts:Cart[] = [];
  user:User;
  subtotal:number = 0 ;
  discount:number = 1;
  deliveryCharge:number = 4;
  grandTotal:number;
  order:Order = new Order;

  constructor(
    private cartService : CartService,
    private orderService : OrderService,
    private router : Router    
    ) { }

  ngOnInit(): void {
    this.getCart();
    this.user = JSON.parse(sessionStorage.getItem("user"));
  }

  getCart()
  {
    this.cartService.getCartByUser(sessionStorage.getItem("user")).subscribe((data:any)=>{
      this.carts = data;
      console.log("carts " + this.carts);
      this.calculateCharges();
    },(error)=>{
      alert(error?.message);
    });
  }

  calculateCharges()
  {
    this.subtotal = 0;
    
    for(var i in this.carts)
    {
      
      this.subtotal = this.subtotal + this.carts[i].amount;
    }
    this.grandTotal = this.subtotal + this.deliveryCharge - this.discount;
  }

  remove(id:number)
  {
    this.cartService.deleteProductFromCart(id).subscribe((data)=>{
      this.getCart();
    });
  }

  refreshCart(cart:Cart)
  {
    
    this.cartService.updateCart(cart).subscribe((data)=>{
      this.getCart();
    });
  }

  changeFn(e,cart:Cart)
  {
    cart.quantity=e.target.value;
    cart.amount = cart.product.cost * cart.quantity;
  }
  placeOrder()
  {
    this.order.deliveryCharges = this.deliveryCharge;
    this.order.subTotal = this.subtotal;
    this.order.discount = this.discount;
    this.order.totalAmount = this.grandTotal;
    this.order.shippingAddress = this.address;
    this.order.user = this.user;
    this.order.status = "On the Way";
    this.order.createdOn =  new Date().toLocaleDateString();

    this.orderService.saveOrder(this.order).subscribe(data=>{
      this.order = data;
      sessionStorage.setItem("order",JSON.stringify(this.order));
      alert("Order Placed Successfully.");
      this.router.navigate(['/orderSummary']);
    });

    
    //sessionStorage.setItem("cart",JSON.stringify(this.carts));
  }

}
