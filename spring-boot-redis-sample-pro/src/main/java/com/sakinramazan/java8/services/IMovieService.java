package com.sakinramazan.java8.services;

import com.sakinramazan.java8.models.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> findAll();

    Movie findOne(Long id);

    Movie newOne(Movie movie);

}
