package com.movies.backend.movies.api.Repository;

import org.springframework.data.repository.CrudRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.movies.backend.movies.api.Entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Id> {
    
}
