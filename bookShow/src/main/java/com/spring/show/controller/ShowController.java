package com.spring.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.show.model.Show;
import com.spring.show.service.ShowService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ShowController {

	@Autowired
	private ShowService showService;

	@RequestMapping(value = { "/create", "/" }, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void bookShow(@RequestBody Show show) {
		showService.bookShow(show);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Show> getAllBooking() {
		Flux<Show> shws = showService.getAllBooking();
		return shws;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mono<Show>> getBooking(@PathVariable("id") Integer id) {
		Mono<Show> e = showService.getBooking(id);
		HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Show>>(e, status);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Show> updateBooking(@RequestBody Show s) {
		return showService.updateBooking(s);
	}

	@RequestMapping(value = "/delete/{bookingid}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void cancelBooking(@PathVariable("bookingid") Integer bookingid) {
		showService.cancelBooking(bookingid).subscribe();
	}

}
