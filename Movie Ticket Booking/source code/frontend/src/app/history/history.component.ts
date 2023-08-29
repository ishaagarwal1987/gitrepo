import { Component, OnInit } from '@angular/core';
import { Booking } from '../classes/booking';
import { BookingService } from '../services/booking.service';
import { User } from '../classes/user';
import { Showseat } from '../classes/showseat';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  user:User = new User();
  bookings : Booking[]=[];
  displayStyle = "none";
  seats:Showseat[] = [];

  constructor(
    private bookingService : BookingService
  ) { }

  ngOnInit(): void {
    this.getDetails();
  }

  getDetails()
  {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.bookingService.getTicketsByUser(this.user).subscribe(data=>{
      this.bookings= data;
    });

  }

  viewdetail(booking:Booking)
  {
    this.bookingService.getSeatByBooking(booking.bookingID).subscribe(data=>{
      this.seats=data;
    });
    this.displayStyle="block"
  }

  openModifyPopup(id:number,genrename:string)
  {
    this.displayStyle="block"
  }
  closePopup() {
    this.displayStyle = "none";
  }

}
