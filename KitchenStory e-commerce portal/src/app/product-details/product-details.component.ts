import { Component, OnInit } from '@angular/core';
import { Product } from '../classes/product';
import { Router } from '@angular/router';
import { Cart } from '../classes/cart';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  //pname:string="hello";
  productObj:Product = new Product();
  cart:Cart = new Cart();
  quantity:any;
  constructor(private cartService : CartService,private router :Router) { }

  ngOnInit(): void {
    this.details();
  }
  details()
  {
    this.productObj = JSON.parse(sessionStorage.getItem("product"));
    //this.productObj.productId = Number(sessionStorage.getItem("productId"));
    //this.productObj.productName = sessionStorage.getItem("productName");
    //this.productObj.productDescription = sessionStorage.getItem("productDescription");
    //this.productObj.cost = sessionStorage.getItem("cost");
    //this.productObj.imageName = sessionStorage.getItem("imageName");
  }
  addCart()
  {
    this.cart.product=this.productObj;
    this.cart.quantity=this.quantity;
    this.cart.amount=Number(Number(this.productObj.cost) * this.quantity);

    if(sessionStorage.getItem("user")==null)
    {
      sessionStorage.setItem("cart",JSON.stringify(this.cart));
      this.router.navigate(['/login']);

    }
    else
    {
      this.cart.user = JSON.parse(sessionStorage.getItem("user"));
      //sessionStorage.setItem("cart",JSON.stringify(this.cart));
      this.cartService.saveToCart(this.cart).subscribe(data1=>{});
      this.router.navigate(['/cart']);
    }
  }

}
