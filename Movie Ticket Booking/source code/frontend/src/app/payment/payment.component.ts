import { Component, OnInit } from '@angular/core';
import { Booking } from '../classes/booking';
import { Showseat } from '../classes/showseat';
import { Movie } from '../classes/movie';
import { BookingService } from '../services/booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  booking:Booking;
  storedSeat:Showseat[];
  movieObj:Movie = new Movie;
  constructor(
    private bookingService:BookingService,
    private router :Router
  ) { }

  ngOnInit(): void {
    this.getData();
  }

  getData()
  {
    this.booking = JSON.parse(sessionStorage.getItem("booking"));
    this.storedSeat = JSON.parse(sessionStorage.getItem("bookedSeats"));
    this.movieObj = this.booking.show.movie;
  }
  book()
  {
    const formData = new FormData;
    formData.append("booking",JSON.stringify(this.booking));
    formData.append("bookedSeats",JSON.stringify(this.storedSeat));

    //alert("booked Seats = "+this.storedSeat + "Stringified = " +JSON.stringify(this.storedSeat));

    this.bookingService.addTickets(formData).subscribe(data=>{
      alert("Tickets Booked SuccessFully.");
    });
    this.router.navigate(['']);
  }
}
