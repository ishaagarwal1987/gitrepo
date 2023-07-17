import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'KitchenStory';

  isNavbarVisiableAdmin:boolean=false;
  isNavbarVisiableMain:boolean=false;
  isNavbarVisiableClient:boolean=false;
  name:string;
  pname:string;
  @Output() searchcriteria = new EventEmitter<String>();

  constructor(private router:Router)
  {

  }

  ngDoCheck()
  {
    let currentUrl=this.router.url;

    this.name = sessionStorage.getItem("userdetails");
    
   if(this.name=="admin")
    {
      this.isNavbarVisiableAdmin=true;
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableClient=false;
    }
    else if(this.name==null){
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableClient=false;
      this.isNavbarVisiableMain=true;
    }
    else
    {
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableClient=true;
      this.isNavbarVisiableMain=false;
    }
  }
  logout()
  {
    sessionStorage.clear();
    this.router.navigate(['/']);
  }

  searchThis()
  {
    sessionStorage.setItem('pname',this.pname);
    console.log("search = " + this.pname);
    this.router.navigate(['viewProducts']);
    //this.searchcriteria.emit(this.pname)
  }
}
