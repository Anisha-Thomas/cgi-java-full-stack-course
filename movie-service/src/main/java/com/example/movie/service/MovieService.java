package com.example.movie.service;

import java.util.List;

import com.example.movie.dto.MovieDto;
import com.example.movie.model.Movie;
import com.example.movie.ui.ResponseModel;

public interface MovieService {

	ResponseModel createMovie(MovieDto movieDto);
	List<Movie> getAllMovies();
	ResponseModel updateMovieDetails(MovieDto movieDto, String movieid);
	ResponseModel getMovieDetailsByMovieId(String movieid);

}
