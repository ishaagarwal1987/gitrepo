import { CinemaSeat } from "./cinema-seat";
import { Show } from "./show";

export class CinemaHall {
    cinemaHallID:number;
    name:string;
    cinemaSeats:CinemaSeat
    show:Show;
}
