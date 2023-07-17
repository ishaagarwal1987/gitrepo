import { User } from "./user";

export class Order {
    order_id:number;
    user :User;
    shippingAddress:string;
    totalAmount:number;
    createdOn:string
    status:string;
    discount:number;
    deliveryCharges:number;
    subTotal:number;
}
