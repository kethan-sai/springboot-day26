package com.spring.show.service;

import com.spring.show.model.Show;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IShowService {

	void bookShow(Show s);

	Flux<Show> getAllBooking();

	Mono<Show> getBooking(Integer bookingId);

	Mono<Void> cancelBooking(Integer bookingid);

	Mono<Show> updateBooking(Show s);
}
