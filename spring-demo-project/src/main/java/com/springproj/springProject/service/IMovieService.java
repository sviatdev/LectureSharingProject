package com.springproj.springProject.service;

import com.springproj.springProject.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieService {

    Movie insertMovie(Movie movie);

    List<Movie> showAllMovies();

    Movie getMovie(int id);

    Movie updateMovie(Movie movie);

    void removeMovie(int id);


}
