package com.example.movie.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.dto.MovieDto;
import com.example.movie.exception.MyCustomExceptions;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import com.example.movie.ui.ErrorModel;
import com.example.movie.ui.RequestModel;
import com.example.movie.ui.ResponseModel;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private final ModelMapper modelMapper;
	private final MovieService movieService;

	public MovieController(ModelMapper modelMapper, MovieService movieService) {
		super();
		this.modelMapper = modelMapper;
		this.movieService = movieService;
	}

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<ErrorModel> handleException(NumberFormatException e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);
	}

	@ExceptionHandler(value = MyCustomExceptions.class)
	public ResponseEntity<ErrorModel> handleIdNotFoundException(MyCustomExceptions e) {
		ErrorModel errorModel = new ErrorModel(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorModel);

	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> createMovie(@RequestBody RequestModel requestModel){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDto movieDto= modelMapper.map(requestModel, MovieDto.class);
		ResponseModel responseModel = movieService.createMovie(movieDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
		
	}
	@GetMapping
	public ResponseEntity<List<ResponseModel>> getAllMovies(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ResponseModel> models = new ArrayList<ResponseModel>();

		List<Movie> list = movieService.getAllMovies();

		for (Movie entity : list) {
			models.add(modelMapper.map(entity,ResponseModel.class));
		}

		return ResponseEntity.ok(models);
	}
	@PutMapping("/{movieid}")
	public ResponseEntity<ResponseModel> updateMovieId(@RequestBody RequestModel requestModel,@PathVariable("movieid") String movieid){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDto movieDto= modelMapper.map(requestModel, MovieDto.class);
		ResponseModel responseModel = movieService.updateMovieDetails(movieDto,movieid);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseModel);
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<ResponseModel> getMovieDetails(@PathVariable("movieid") String movieid){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println("Movie ID " +movieid);
		ResponseModel responseModel = movieService.getMovieDetailsByMovieId(movieid);
		return ResponseEntity.ok(responseModel);
		
		
	}

}
