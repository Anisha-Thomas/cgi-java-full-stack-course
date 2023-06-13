package com.example.movie.ui;

import com.example.movie.model.GENRE_TYPE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
	private String movieName;

	private GENRE_TYPE genre;
}
