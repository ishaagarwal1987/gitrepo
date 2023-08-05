import { Component, OnInit } from '@angular/core';
import { Cart } from '../classes/cart';
import { Product } from '../classes/product';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.css']
})
export class ProductdetailComponent implements OnInit {

  productObj:Product = new Product();
  cart:Cart = new Cart;
  quantity:any;
  constructor(
    private cartService : CartService,
    private router :Router
    ) { }

  ngOnInit(): void {
    this.details();
  }

  details()
  {
    this.productObj = JSON.parse(sessionStorage.getItem("product"));
  }

  addCart()
  {
    this.cart.cartid=null;
    this.cart.product=this.productObj;
    this.cart.quantity=this.quantity;
    this.cart.amount=this.productObj.cost * this.quantity;

    if(sessionStorage.getItem("user")==null)
    {
      sessionStorage.setItem("cart",JSON.stringify(this.cart));
      this.router.navigate(['/login']);

    }
    else
    {
      this.cart.user = JSON.parse(sessionStorage.getItem("user"));
      this.cartService.saveToCart(this.cart).subscribe((data:any)=>{
      alert(data?.message);
      //Cart.count++;
      });
      
    }
  }
  goToCart()
  {
    if(sessionStorage.getItem("user")==null)
    {
      this.router.navigate(['/login']);
    }
    else{
      this.router.navigate(['/cart']);
    }

  }
}
