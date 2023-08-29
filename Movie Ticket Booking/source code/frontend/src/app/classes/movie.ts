import { Generes } from "./genres";

export class Movie {
    movieid:number;
    moviename:string;
    certification:string;
    genre:Generes;
    description:string;
    language:string;
    image:string;
    duration:number;
}
