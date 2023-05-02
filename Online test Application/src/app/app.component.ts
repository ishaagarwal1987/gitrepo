import { Component, DoCheck } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements DoCheck {
  title = 'Quiz';
  isNavbarVisiableAdmin:boolean=false;
  isNavbarVisiableStudent:boolean=false;
  name:string;

  constructor(private router:Router)
  {

  }
  ngDoCheck()
  {
    let currentUrl=this.router.url;

    this.name = sessionStorage.getItem("userdetails");

    if(currentUrl=="/" || currentUrl=="/login" || currentUrl=="/regUser")
    {
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableStudent=false;
    }
    else if(this.name=="admin")
    {
      this.isNavbarVisiableAdmin=true;
      this.isNavbarVisiableStudent=false;
    }
    else 
    {
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableStudent=true;
    }

  }
}
