import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Product } from '../classes/product';
import { ProductServiceService } from '../services/product-service.service';
import { ProductService } from '../services/product.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit,OnDestroy {

  productSubsciption:Subscription;
  selectedFile = null;
  productObj : Product = new Product();
  products:Product[] = [];
  msg:string="";
  displayStyle = "none";
  modifyDisplayStyle="none";
  
  constructor(
    private builder:FormBuilder,
    private productService:ProductServiceService
  ) { }
  ngOnDestroy(): void {
    this.productSubsciption.unsubscribe();
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.displayProducts();
  }

  prodForm = this.builder.group({
    productName:this.builder.control('',Validators.required),
    productDescription:this.builder.control('',Validators.required),
    cost:this.builder.control('',Validators.required),
    imageName:this.builder.control('',Validators.required)
  });

  openPopup() {
    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
  }
  onFileSelected(event) {
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile);
  }
  addProduct()
  {
    this.productObj.productId = null;    
    this.productObj.productName = this.prodForm.value.productName;
    this.productObj.productDescription = this.prodForm.value.productDescription;
    this.productObj.cost = this.prodForm.value.cost;
    this.productObj.imageName = this.prodForm.value.image;
    const payload = new FormData();
    
    payload.append("addProduct",JSON.stringify(this.productObj));
    
    payload.append("image", this.selectedFile);
    
    this.productService.saveProduct(payload).subscribe(data=>{
     //alert("Product Added Successfully!");
     this.displayProducts();
     //this.products=data;
     this.prodForm.reset();
    },err=>{
      alert("Something went wrong..");
      this.displayProducts();
    });
  }
  displayProducts()
  {
    this.productService.getAllProducts().subscribe(data=>{
    this.products=data;
    });
  }
  deleteProduct(id:any)
  {
    this.productService.deleteProduct(id).subscribe(data=>{
      this.products=data;
      //this.displayProducts();
    });
  }
  openModifyPopup(id:number)
  {
    for(var i in this.products)
    {
      if(this.products[i].productId==id)
      {
        this.productObj.productId=id;
        this.prodForm.controls['productName'].setValue(this.products[i].productName);
        this.prodForm.controls['productDescription'].setValue(this.products[i].productDescription);
        this.prodForm.controls['cost'].setValue(this.products[i].cost);
        //this.prodForm.controls['imageName'].setValue(this.products[i].imageName);
      }
    }
    
    this.modifyDisplayStyle="block";
  }
  closeModifyPopup()
  {
    this.modifyDisplayStyle="none";
  }
  updateProduct()
  {
    this.productObj.productName=this.prodForm.value.productName;
    this.productObj.productDescription = this.prodForm.value.productDescription;
    this.productObj.cost = this.prodForm.value.cost;
    
    const payload = new FormData();
    
    payload.append("updateProduct",JSON.stringify(this.productObj));
    
    payload.append("image", this.selectedFile);


    this.productService.updateProduct(this.productObj.productId,payload).subscribe(data=>{
      
      this.displayProducts();
      this.prodForm.reset();
     },err=>{
       alert("Something went wrong..");
       this.displayProducts();
     });
  }
}
