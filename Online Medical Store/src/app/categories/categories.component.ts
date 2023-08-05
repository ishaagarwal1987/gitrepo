import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../services/category.service';
import { Category } from '../classes/category';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categoryName:string="";
  categories:Category[] = [];
  displayStyle = "none";
  categoryname:string;
  id:number;

  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.displayCategories();
  }

  add()
  {
    this.categoryService.saveCategory(this.categoryName).subscribe((data:any)=>{
      //alert(data?.message);
      this.displayCategories();
    },(error)=>{
      alert(error.error?.message);
    });
  }

  displayCategories()
  {
    this.categoryService.getCategories().subscribe(data=>{
      this.categories = data;
    });
  }
  openModifyPopup(id:number,categoryname:string)
  {
    this.id=id;
    this.categoryname=categoryname;
    this.displayStyle="block"
  }
  closePopup() {
    this.displayStyle = "none";
  }
  edit()
  {
    this.categoryService.editCategory(this.id,this.categoryname).subscribe((data)=>{
      alert("Updated");
      this.categories=data;
      this.closePopup();
    });
  }
  remove(id:any)
  {
    this.categoryService.removeCategory(id).subscribe((data)=>{
      //alert(data);
      this.displayCategories();
    });
  }
}
