package com.springproj.springProject.dao;

import com.springproj.springProject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.title =:title")
    Movie findByTitle(String title);
}
