package com.springproj.spring_example_project.dao;

import com.springproj.spring_example_project.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {
}
