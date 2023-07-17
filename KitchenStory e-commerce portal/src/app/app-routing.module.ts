import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProductsComponent } from './products/products.component';
import { ViewUsersComponent } from './view-users/view-users.component';
import { ViewProductsComponent } from './view-products/view-products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CartComponent } from './cart/cart.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { OrdersComponent } from './orders/orders.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"products",component:ProductsComponent},
  {path:"users",component:ViewUsersComponent},
  {path:"viewProducts",component:ViewProductsComponent},
  {path:"productdetails",component:ProductDetailsComponent},
  {path:"cart",component:CartComponent},
  {path:"changePass",component:ChangepasswordComponent},
  {path:"orders",component:OrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
