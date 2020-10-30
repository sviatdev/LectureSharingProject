package com.springproj.springProject.validator;

import com.springproj.springProject.dao.MovieDao;
import com.springproj.springProject.entity.Movie;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueMovieTitleValidator implements ConstraintValidator<UniqueMovieTitle, String> {

private MovieDao movieDao;

    public UniqueMovieTitleValidator(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void initialize(UniqueMovieTitle constraintAnnotation) {

    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        if(title != null && title.length() != 0){
        final Movie movie = movieDao.findByTitle(title);
        return movie == null;
        }
        return false;
    }
}
