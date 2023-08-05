import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './classes/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Medicare';
  isNavbarVisiableAdmin:boolean=false;
  isNavbarVisiableClient:boolean=false;
  isNavbarVisiableMain:boolean=false;
  pname:string;

  user:User = new User;

  constructor(private router:Router)
  {

  }

  ngDoCheck()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user==null)
    {
      this.isNavbarVisiableMain=true;
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableClient=false;
    }
    else if(this.user.role=="admin")
    {
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableAdmin=true;
      this.isNavbarVisiableClient=false;
    }
    else{
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableClient=true;
    }
  }
  logout()
  {
    sessionStorage.clear();
    this.router.navigate(['']);
  }
  searchThis()
  {
    sessionStorage.setItem('pname',this.pname);
    //console.log("search = " + this.pname);
    this.router.navigate(['/viewProducts']);
    //this.searchcriteria.emit(this.pname)
  }

}
