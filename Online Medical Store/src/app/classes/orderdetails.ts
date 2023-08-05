import { Order } from "./order";
import { Product } from "./product";

export class Orderdetails {
    orderdetailsid:number;
    order:Order;
    product:Product;
    quantity:number;
    amount:number;
}
