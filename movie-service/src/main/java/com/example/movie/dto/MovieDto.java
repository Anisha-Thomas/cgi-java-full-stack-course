package com.example.movie.dto;

import com.example.movie.model.GENRE_TYPE;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
public class MovieDto {

	private String movieId;

	private String movieName;

	private GENRE_TYPE genre;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public GENRE_TYPE getGenre() {
		return genre;
	}

	public void setGenre(GENRE_TYPE genre) {
		this.genre = genre;
	}

	public MovieDto(String movieId, String movieName, GENRE_TYPE genre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.genre = genre;
	}

	public MovieDto() {
		super();
	}
	
	
}
