package com.springproj.springProject.service;

import com.springproj.springProject.dao.MovieDao;
import com.springproj.springProject.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie insertMovie(@RequestBody Movie movie) {
            if (movie.getTitle().charAt(0) < 65 || movie.getTitle().charAt(0) > 90) {
                //todo add Exception
                throw new RuntimeException("Title should starts with capital letter");
            }
            return movieDao.save(movie);
        }

    @Override
    public List<Movie> showAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        return movieDao.findById(id).orElseThrow(() -> new RuntimeException("No movie with id" + id));
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public void removeMovie(int id) {
        movieDao.deleteById(id);
    }
}
