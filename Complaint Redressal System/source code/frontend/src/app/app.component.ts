import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './classes/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'compaintRedressalSystem';

  isNavbarVisiableAdmin:boolean=false;
  isNavbarVisiableManager:boolean=false;
  isNavbarVisiableEngineer:boolean=false;
  isNavbarVisiableClient:boolean=false;
  isNavbarVisiableMain:boolean=false;
  
  user:User = new User;
  
  ngDoCheck()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user==null)
    {
      this.isNavbarVisiableMain=true;
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableClient=false;
      this.isNavbarVisiableManager=false;
      this.isNavbarVisiableEngineer=false;
    }
    else if(this.user.role=="admin")
    {
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableAdmin=true;
      this.isNavbarVisiableManager=false;
      this.isNavbarVisiableEngineer=false;
      this.isNavbarVisiableClient=false;
    }
    else if(this.user.role=="manager")
    {
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableManager=true;
      this.isNavbarVisiableEngineer=false;
      this.isNavbarVisiableClient=false;
    }
    else if(this.user.role=="engineer")
    {
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableManager=false;
      this.isNavbarVisiableEngineer=true;
      this.isNavbarVisiableClient=false;
    }
    else if(this.user.role=="client"){
      this.isNavbarVisiableMain=false;
      this.isNavbarVisiableAdmin=false;
      this.isNavbarVisiableClient=true;
      this.isNavbarVisiableManager=false;
      this.isNavbarVisiableEngineer=false;
    }
  }
}
