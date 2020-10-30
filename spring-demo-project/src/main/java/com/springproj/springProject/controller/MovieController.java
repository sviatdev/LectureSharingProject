package com.springproj.springProject.controller;

import com.springproj.springProject.entity.Movie;
import com.springproj.springProject.service.IMovieService;
import com.springproj.springProject.validator.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovieController {

    @Qualifier(value = "movieService")
    private IMovieService movieService;
    private MovieValidator movieValidator;

    @Autowired
    public MovieController(IMovieService movieService, MovieValidator movieValidator) {
        this.movieService = movieService;
        this.movieValidator = movieValidator;
    }

    @GetMapping(value="/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Movie> getMovies(){
        return movieService.showAllMovies();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie){
        movie.setId(id);
        return movieService.updateMovie(movie);
    }

    @GetMapping(value = "/movies/id={id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie getSingleMovie(@PathVariable int id){
        return movieService.getMovie(id);
    }

    @DeleteMapping(value="/id")
    public void deleteMovie(@PathVariable int id){
        movieService.removeMovie(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(movieValidator);
    }
}


