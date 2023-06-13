package com.example.movie.ui;

import com.example.movie.model.GENRE_TYPE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseModel {
	private String movieId;

	private String movieName;

	private GENRE_TYPE genre;
}
