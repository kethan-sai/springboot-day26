package com.spring.show.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.show.dao.ShowRepository;
import com.spring.show.model.Show;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShowService implements IShowService {

	@Autowired
	ShowRepository Showrepo;

	@Override
	public void bookShow(Show s) {
		Showrepo.save(s).subscribe();
	}

	@Override
	public Flux<Show> getAllBooking() {
		// TODO Auto-generated method stub
		return Showrepo.findAll();
	}

	@Override
	public Mono<Show> getBooking(Integer bookingId) {
		// TODO Auto-generated method stub
		return Showrepo.findById(bookingId);
	}

	@Override
	public Mono<Void> cancelBooking(Integer bookingid) {
		// TODO Auto-generated method stub
		return Showrepo.deleteById(bookingid);
	}

	@Override
	public Mono<Show> updateBooking(Show s) {
		// TODO Auto-generated method stub
		return Showrepo.save(s);
	}

}
