package com.springproj.spring_example_project.controller;

import com.springproj.spring_example_project.dao.MovieDao;
import com.springproj.spring_example_project.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class MovieController {


    private MovieDao movieDao;

    @Autowired
    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping(value="/movies")
    public List<Movie> showAllMovies(){
        return movieDao.findAll();
    }


}
