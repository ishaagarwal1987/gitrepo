import { Component, OnInit } from '@angular/core';
import { Generes } from '../classes/genres';
import { GenresService } from '../services/genres.service';

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css']
})
export class GenresComponent implements OnInit {

  genrename : string ="";
  displayStyle = "none";
  id:number;
  genres:Generes[] = [];

  constructor(private genresService : GenresService) { }

  ngOnInit(): void {
    this.getGenres();
  }

  openModifyPopup(id:number,genrename:string)
  {
    this.id=id;
    this.genrename=genrename;
    this.displayStyle="block"
  }
  closePopup() {
    this.displayStyle = "none";
  }
  getGenres()
  {
    this.genresService.getGenre().subscribe(data=>{
      this.genres = data;
    });
  }
  add()
  {
    this.genresService.saveGenre(this.genrename).subscribe((data:any)=>{
      //alert(data?.message);
      this.getGenres();
    },(error)=>{
      alert(error.error?.message);
    });
  }
  edit()
  {
    this.genresService.editGenre(this.id,this.genrename).subscribe((data)=>{
      alert("Updated");
      this.genres=data;
      this.closePopup();});
  }
  remove(id:any)
  {
    this.genresService.removeGenre(id).subscribe((data)=>{
      
      this.getGenres();
    }

    );
  }
}
