import { Component, OnInit } from '@angular/core';
import { Product } from '../classes/product';

@Component({
  selector: 'app-pdetails',
  templateUrl: './pdetails.component.html',
  styleUrls: ['./pdetails.component.css']
})
export class PdetailsComponent implements OnInit {

  productObj : Product = new Product();
  pname="roti"
  constructor() { }

  ngOnInit(): void {
    this.details();
  }

  details()
  {
    //this.productObj.productId = sessionStorage.getItem("productId");
    this.productObj.productName = "Hello";
  }
}
