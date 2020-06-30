package com.spring.show.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.show.model.Show;

public interface ShowRepository extends ReactiveMongoRepository<Show, Integer> {

}
