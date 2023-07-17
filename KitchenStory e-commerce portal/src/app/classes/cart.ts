import { Product } from "./product";
import { User } from "./user";

export class Cart {
    cartid:number;
    user:User;
    product:Product;
    quantity:number;
    amount:number;
}
