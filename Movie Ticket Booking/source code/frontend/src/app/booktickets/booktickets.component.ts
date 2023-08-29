import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { Movie } from '../classes/movie';
import { Show } from '../classes/show';
import { Booking } from '../classes/booking';
import { Showseat } from '../classes/showseat';
import { CinemaSeat } from '../classes/cinema-seat';
import { CinemaseatService } from '../services/cinemaseat.service';
import { Router } from '@angular/router';
import { BookingService } from '../services/booking.service';

@Component({
  selector: 'app-booktickets',
  templateUrl: './booktickets.component.html',
  styleUrls: ['./booktickets.component.css']
})
export class BookticketsComponent implements OnInit {

  movie: Movie = new Movie;
  show: Show = new Show();

  showSeats: CinemaSeat[] = [];
  math = Math;
  normalTicket :number = 0;
  totalTicketPrice:number = 0;
  bookedSeats : Showseat[] = [];
  selected: boolean = false;
  selectedSeat: any;
  storedSeats: CinemaSeat[] = []
  avialableSeat:number;
  booking: Booking=new Booking;
  user: User;

  constructor(
    private cinemaSeatService: CinemaseatService,
    private router: Router,
    private bookingService : BookingService
  ) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem("user"));
    this.avialableSeat=0;
    this.getShow();
  }

  getShow() {
    this.show = JSON.parse(sessionStorage.getItem("show"));
    //this.movie = this.show.movie;
    this.getSeats();
  }
  getSeats() {
    this.cinemaSeatService.getSeats().subscribe(data => {
      this.showSeats = data;
    });
    this.getShowSeats();
  }
  getShowSeats() {
    this.bookingService.getSeatsByShow(this.show.showid).subscribe(data=>{
      this.bookedSeats = data;
    });
  }
  onBooking() {
    if (this.normalTicket > 0 && this.storedSeats.length > 0) {
      var todayDate = new Date();
      this.booking.numberOfSeats = this.avialableSeat;
      this.booking.show = this.show;
      this.booking.user = this.user;
      this.booking.timeStamp = todayDate;
      this.booking.amount = this.totalTicketPrice;

      sessionStorage.setItem("booking", JSON.stringify(this.booking));
      sessionStorage.setItem("bookedSeats", JSON.stringify(this.storedSeats));
      this.router.navigate(['/payment']);

    }
  }
  onSelected(seat: any) {
    if (seat.active == true) {
      seat.active = false;
      this.avialableSeat--;
      this.totalTicketPrice = this.totalTicketPrice - seat.price;
      for (var i = 0; i < this.storedSeats.length; i++) {
        if (this.storedSeats[i].cinemaSeatID == seat.cinemaSeatID) {
          this.storedSeats.splice(i, 1);
        }
      }
    } else {
      if (this.avialableSeat < this.normalTicket && seat.seatType != 2) {
        seat.active = true;
        this.avialableSeat++;
        this.totalTicketPrice = this.totalTicketPrice + seat.price;
        this.storedSeats.push(seat);
      }
    }
  }
  onMinus(count: number, target: string) {
    count = count - 1;
    if (count < 0) {
      count = 0;
    }
    else {
      if (target == "normalTicket") {
        this.normalTicket = count;
      }

    }

  }
  onPlus(count: number, target: string) {
    count = count + 1;
    if (count > 9) {
      count = 9;
    }
    else {

      if (target == "normalTicket") {
        this.normalTicket = count;
      }

    }
  }

  convertMinuteToHour(minute: number) {
    var hours = this.math.floor(minute / 60);
    var minutes = minute % 60;
    var duration = hours + " H : " + minutes + "M";
    return duration;
  }
}
