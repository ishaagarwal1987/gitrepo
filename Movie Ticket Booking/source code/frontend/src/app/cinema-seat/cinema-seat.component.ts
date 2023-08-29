import { Component, OnInit } from '@angular/core';
import { CinemaSeat } from '../classes/cinema-seat';
import { CinemaseatService } from '../services/cinemaseat.service';

@Component({
  selector: 'app-cinema-seat',
  templateUrl: './cinema-seat.component.html',
  styleUrls: ['./cinema-seat.component.css']
})
export class CinemaSeatComponent implements OnInit {

  seatNumber:string;
  seatType:number;
  price:number;
  displayStyle="none";

  seat:CinemaSeat = new CinemaSeat();

  seats:CinemaSeat[] =[];
  constructor(private seatService:CinemaseatService) { }

  ngOnInit(): void {
    this.displaySeats();
  }

  addSeat()
  {
    this.seat.seatNumber = this.seatNumber;
    this.seat.seatType = this.seatType;
    this.seat.price = this.price;
    this.seatService.saveSeat(this.seat).subscribe(data=>{
      this.displaySeats();
    });
  }
  displaySeats()
  {
    this.seatService.getSeats().subscribe(data=>{
      this.seats = data;
    });
  }
  openModifyPopup(seat:CinemaSeat){
    this.seat  = seat;
    this.seatNumber=seat.seatNumber;
    this.seatType = seat.seatType;
    this.price = seat.price;

    this.displayStyle="block"
  }
  closePopup() {
    this.displayStyle = "none";
    this.seat=null;
  }

  deleteShow(id:number){
    this.seatService.removeSeat(id).subscribe(data=>{
      this.displaySeats();
    });
  }
  updateSeat(){

    this.seat.seatNumber = this.seatNumber;
    this.seat.seatType = this.seatType;
    this.seat.price = this.price;

    this.seatService.editSeat(this.seat).subscribe(data=>{
      this.displaySeats();
    });
  }

  
}
