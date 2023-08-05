import { User } from "./user";

export class Order {
    orderid:number;
    user :User;
    shippingAddress:string;
    totalAmount:number;
    createdOn:string
    status:string;
    discount:number;
    deliveryCharges:number;
    subTotal:number;
}
