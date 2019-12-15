package com.sakinramazan.java8.repositories;

import com.sakinramazan.java8.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository
        extends JpaRepository<Movie, Long> {
}
