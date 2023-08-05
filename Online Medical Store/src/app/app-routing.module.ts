import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ProductsComponent } from './products/products.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { CategoriesComponent } from './categories/categories.component';
import { ViewproductsComponent } from './viewproducts/viewproducts.component';
import { UsersComponent } from './users/users.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { ProductdetailComponent } from './productdetail/productdetail.component';
import { CartComponent } from './cart/cart.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { OrderComponent } from './order/order.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"about",component:AboutComponent},
  {path:"contact",component:ContactComponent},
  {path:"products",component:ProductsComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"adminDashboard",component:AdminDashboardComponent},
  {path:"clientDashboard",component:ClientDashboardComponent},
  {path:"categories",component:CategoriesComponent},
  {path:"viewProducts",component:ViewproductsComponent},
  {path:"users",component:UsersComponent},
  {path:"changepassword",component:ChangepasswordComponent},
  {path:"productdetails",component:ProductdetailComponent},
  {path:"cart",component:CartComponent},
  {path:"orderSummary",component:OrderSummaryComponent},
  {path:"order",component:OrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
