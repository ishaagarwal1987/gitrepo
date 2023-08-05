import { Component, OnInit } from '@angular/core';
import { Category } from '../classes/category';
import { Product } from '../classes/product';
import { CategoryService } from '../services/category.service';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  categories : Category[] = [];

  products : Product[] = [];

  constructor(
    private categoryService : CategoryService,
    private productService : ProductService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories()
  {
 this.categoryService.getCategories().subscribe(data =>{
  this.categories = data;
  this.getFewProducts();
 });
  }
  getFewProducts()
  {
    this.productService.getFewProducts().subscribe(data=>{
      this.products = data;
    });
  }
  getProducts(category:Category)
  {
    this.productService.getProductByCategory(category.categoryid).subscribe(data=>{
      this.products = data;
    });
  }
  productdetail(p:Product)
  {
    sessionStorage.setItem('product',JSON.stringify(p));
    this.router.navigate(['productdetails']);

  }
}
