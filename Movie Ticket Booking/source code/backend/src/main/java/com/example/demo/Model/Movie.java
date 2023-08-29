package com.example.demo.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NamedNativeQuery(name = "Movie.findFewMovies" , query = "select * from movie where LIMIT 4", resultClass = Movie.class)

@Data
@Entity
@DynamicUpdate
@Getter @Setter
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieid;
	private String moviename;
	private String certification;
	
	@ManyToOne
	private Genres genre;
	
	private String description;
	private String language;
	private String image;
	private int duration;
	
}
