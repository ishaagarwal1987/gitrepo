import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MovieService } from '../services/movie.service';
import { GenresService } from '../services/genres.service';
import { Movie } from '../classes/movie';
import { Generes } from '../classes/genres';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  selectedFile = null;
  movieObj: Movie = new Movie();
  movies: Movie[] = [];
  msg: string = "";
  displayStyle = "none";
  modifyDisplayStyle = "none";
  genres: Generes[] = [];

  constructor(
    private builder: FormBuilder,
    private genresService: GenresService,
    private moviesService: MovieService
  ) { }

  ngOnInit(): void {
    this.displayMovies();
  }

  prodForm = this.builder.group({
    moviename: this.builder.control('', Validators.required),
    certification: this.builder.control('', Validators.required),
    description: this.builder.control('', Validators.required),
    language: this.builder.control('', Validators.required),
    genre: this.builder.control('', Validators.required),
    duration: this.builder.control('', Validators.required),
    image: this.builder.control('', Validators.required)
  });
  openPopup() {

    this.getGenres();

    this.displayStyle = "block";
  }
  closePopup() {
    this.displayStyle = "none";
  }
  openModifyPopup(id: number) {
    this.getGenres();
    for (var i in this.movies) {
      if (this.movies[i].movieid == id) {
        this.movieObj = this.movies[i];
        this.prodForm.controls['moviename'].setValue(this.movies[i].moviename);
        this.prodForm.controls['certification'].setValue(this.movies[i].certification);
        this.prodForm.controls['description'].setValue(this.movies[i].description);
        this.prodForm.controls['language'].setValue(this.movies[i].language);
        this.prodForm.controls['genre'].setValue(this.movies[i].genre);
        this.prodForm.controls['duration'].setValue(this.movies[i].duration);
        //this.prodForm.controls['image'].setValue(this.products[i].image);
      }
    }
    this.modifyDisplayStyle = "block";
  }
  closeModifyPopup() {
    this.modifyDisplayStyle = "none";
  }
  onFileSelected(event) {
    this.selectedFile = event.target.files[0];
    console.log(this.selectedFile);
  }
  updateMovie() {

    this.movieObj.moviename = this.prodForm.value.moviename;
    this.movieObj.certification = this.prodForm.value.certification;
    this.movieObj.description = this.prodForm.value.description;
    this.movieObj.language = this.prodForm.value.language;
    this.movieObj.genre = this.prodForm.value.genre;
    this.movieObj.duration = this.prodForm.value.duration;
    //this.movieObj.image = this.prodForm.value.image;

    const formData = new FormData();
    formData.append("updateMovie", JSON.stringify(this.movieObj));
    formData.append("image", this.selectedFile);

    this.moviesService.updateMovie(formData).subscribe((data) => {
      alert(data?.message);
      this.displayMovies();
      this.closeModifyPopup();
    }, (error) => {
      alert(error?.message);
    });

  }
  addMovie() {
    const formData = new FormData();
    formData.append("addMovie", JSON.stringify(this.prodForm.value));
    formData.append("image", this.selectedFile);

    this.moviesService.saveMovie(formData).subscribe((data) => {
      alert(data?.message);
      this.displayMovies();
      this.closePopup();
    }, (error) => {
      alert(error?.message);
    });
  }
  deleteMovie(id: number) {
    this.moviesService.deleteMovie(id).subscribe((data: any) => {
      //alert(data?.message);
      this.displayMovies();
    }, (error) => {
      alert(error?.message);
    });
  }
  displayMovies() {
    this.moviesService.getMovies().subscribe((data) => {
      this.movies = data;
    });

  }
  getGenres() {
    this.genresService.getGenre().subscribe((data) => {
      this.genres = data;
    });
  }
  
}
