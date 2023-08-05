import { Component, OnInit } from '@angular/core';
import { Product } from '../classes/product';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewproducts',
  templateUrl: './viewproducts.component.html',
  styleUrls: ['./viewproducts.component.css']
})
export class ViewproductsComponent implements OnInit {
  msg:string="";
  searchText:string;
  products : Product[]=[];
  constructor(
    private productService: ProductService,
    private router :Router
    ) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    this.searchText = sessionStorage.getItem('pname');
    this.productService.getActiveProducts().subscribe((data) => {
      this.products = data;
    });

    if(this.searchText!=null)
    {
      this.searchThis(this.searchText);
    }
  }
  searchThis(data)
  {
    if(data)
    {
      console.log(data);
      this.products = this.products.filter(productObj =>{
        return productObj.productname.toLowerCase().match(data.toLowerCase());
      });
    }
  }

  productdetail(p:Product)
  {
    sessionStorage.setItem('product',JSON.stringify(p));
    this.router.navigate(['productdetails']);

  }

}
