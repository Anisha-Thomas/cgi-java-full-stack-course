package com.example.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.movie.dto.MovieDto;
import com.example.movie.model.Movie;
import com.example.movie.repo.MovieRepo;
import com.example.movie.ui.ResponseModel;

@Service
//@AllArgsConstructor
public class MovieServiceImp implements MovieService {
	private final ModelMapper modelMapper;
	private MovieRepo movieRepo;

	public MovieServiceImp(ModelMapper modelMapper, MovieRepo movieRepo) {
		super();
		this.modelMapper = modelMapper;
		this.movieRepo = movieRepo;
	}

	@Override
	public ResponseModel createMovie(MovieDto movieDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Movie movieEntity = modelMapper.map(movieDto, Movie.class);
		movieEntity.setMovieId(UUID.randomUUID().toString());
		movieRepo.save(movieEntity);
		ResponseModel responseModel = modelMapper.map(movieEntity, ResponseModel.class);
		return responseModel;
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public ResponseModel updateMovieDetails(MovieDto movieDto, String movieid) {
		ResponseModel responseModel = null;
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<Movie> e = movieRepo.findByMovieId(movieid);
		// System.out.println(e);
		if (e.isPresent()) {
			Movie entity = e.get();
			entity.setMovieName(movieDto.getMovieName());
			entity.setGenre(movieDto.getGenre());
			Movie movie = movieRepo.save(entity);
			System.out.println("Movie " + movie);
			responseModel = modelMapper.map(movie, ResponseModel.class);

		}
		return responseModel;
	}

	public ResponseModel getMovieDetailsByMovieId(String movieid) {
		ResponseModel responseModel = null;
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<Movie> e = movieRepo.findByMovieId(movieid);
		System.out.println("Movie List "+e);
		if (e.isPresent()) {
			responseModel= modelMapper.map(e, ResponseModel.class);
		}
		return responseModel;
	}
}
