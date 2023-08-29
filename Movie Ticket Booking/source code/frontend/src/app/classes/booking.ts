import { Show } from "./show";
import { User } from "./user";

export class Booking {

    bookingID:number;
    numberOfSeats:number;
    timeStamp:Date;
    amount:number;
    user:User;
    show:Show;

}
