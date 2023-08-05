import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Product } from '../classes/product';
import { Category } from '../classes/category';
import { CategoryService } from '../services/category.service';
import { ProductService } from '../services/product.service';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  selectedFile = null;
  productObj: Product = new Product();
  products: Product[] = [];
  msg: string = "";
  displayStyle = "none";
  modifyDisplayStyle = "none";
  categories: Category[] = [];

  constructor(
    private builder: FormBuilder,
    private categoryService: CategoryService,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.displayProducts();
  }

  prodForm = this.builder.group({
    productname: this.builder.control('', Validators.required),
    brand: this.builder.control('', Validators.required),
    cost: this.builder.control('', Validators.required),
    quantity: this.builder.control('', Validators.required),
    category: this.builder.control('', Validators.required),
    status: this.builder.control('', Validators.required),
    image: this.builder.control('', Validators.required)
  });
  openPopup() {

    this.getCategories();

    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
  }
  openModifyPopup(id: number) {
    this.getCategories();
    for (var i in this.products) {
      if (this.products[i].pid == id) {
        this.productObj = this.products[i];
        this.prodForm.controls['productname'].setValue(this.products[i].productname);
        this.prodForm.controls['brand'].setValue(this.products[i].brand);
        this.prodForm.controls['cost'].setValue(this.products[i].cost);
        this.prodForm.controls['quantity'].setValue(this.products[i].quantity);
        this.prodForm.controls['category'].setValue(this.products[i].category);
        this.prodForm.controls['status'].setValue(this.products[i].status);
        //this.prodForm.controls['image'].setValue(this.products[i].image);
      }
    }
    this.modifyDisplayStyle = "block";
  }
  closeModifyPopup() {
    this.modifyDisplayStyle = "none";
  }
  onFileSelected(event) {
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile);
  }
  updateProduct() {

    this.productObj.productname = this.prodForm.value.productname;
    this.productObj.brand = this.prodForm.value.brand;
    this.productObj.cost = this.prodForm.value.cost;
    this.productObj.category = this.prodForm.value.category;
    this.productObj.quantity = this.prodForm.value.quantity;
    this.productObj.status = this.prodForm.value.status;
    this.productObj.image = this.prodForm.value.image;

    const formData = new FormData();
    formData.append("updateProduct", JSON.stringify(this.productObj));
    formData.append("image", this.selectedFile);

    this.productService.updateProduct(formData).subscribe((data) => {
      alert(data?.message);
      this.displayProducts();
      this.closeModifyPopup();
    }, (error) => {
      alert(error?.message);
    });

  }
  addProduct() {
    const formData = new FormData();
    formData.append("addProduct", JSON.stringify(this.prodForm.value));
    formData.append("image", this.selectedFile);

    this.productService.saveProduct(formData).subscribe((data) => {
      alert(data?.message);
      this.displayProducts();
      this.closePopup();
    }, (error) => {
      alert(error?.message);
    });
  }
  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe((data: any) => {
      //alert(data?.message);
      this.displayProducts();
    }, (error) => {
      alert(error?.message);
    });
  }
  displayProducts() {
    this.productService.getProducts().subscribe((data) => {
      this.products = data;
    });

  }
  getCategories() {
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data;
    });
  }
  onCheckboxChange(e, p: Product) {

    if (e.target.checked) {
      p.status = true;

    } else {
      p.status = false;

    }
    this.productService.updateStatus(p).subscribe((data) => {
      alert(data?.message);
    }, (error) => {
      alert(error?.message);
    });

  }

}
