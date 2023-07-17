import { Component, OnDestroy, OnInit } from '@angular/core';
import { Product } from '../classes/product';
import { ProductServiceService } from '../services/product-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {

  products:Product[] = [];
  msg:string="";
  searchText:string;
  constructor(private productService:ProductServiceService,private router :Router) { }
  

  ngOnInit(): void {
    this.displayProducts();
  }

  displayProducts()
  {
    this.searchText = sessionStorage.getItem('pname');
    this.productService.getAllProducts().subscribe(data=>{
      this.products=data;
      sessionStorage.removeItem('pname');
      });
    
      
    
  }
  searchThis(data)
  {
    if(data)
    {
      this.products = this.products.filter(productObj =>{
        return productObj.productName.toLowerCase().includes(data.toLowerCase());
      });
    }
  }
  productdetail(id:any)
  {
    for(var i in this.products)
    {
      if(this.products[i].productId==id)
      {
        sessionStorage.setItem('product',JSON.stringify(this.products[i]));
        this.router.navigate(['productdetails']);
      }
  }

}}

