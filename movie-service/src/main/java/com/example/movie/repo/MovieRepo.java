package com.example.movie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie.model.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

	Optional<Movie> findByMovieId(String movieid);

}
