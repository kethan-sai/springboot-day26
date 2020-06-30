package com.spring.client.api.bookShowClient;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/bookShow-client")
public class BookShowClientApplication {

	WebClient webClient;

	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl("http://localhost:8080/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	@PostMapping("/bookNow")
	public Flux<Show> BookNow(@RequestBody Show request) {
		return (Flux<Show>) webClient.post().uri("/create").bodyValue(request).retrieve();
	}

	@GetMapping("/trackBookings")
	public Flux<Show> trackAllBooking() {
		return webClient.get().uri("/").retrieve().bodyToFlux(Show.class);
	}

	@GetMapping("/trackBooking/{bookingId}")
	public Mono<Show> getBookingById(@PathVariable int bookingId) {
		return webClient.get().uri("/" + bookingId).retrieve().bodyToMono(Show.class);
	}

	@DeleteMapping("/removeBooking/{bookingId}")
	public Mono<String> cancelBooking(@PathVariable int bookingId) {
		return webClient.delete().uri("/delete/" + bookingId).retrieve().bodyToMono(String.class);
	}

	@PutMapping("/changeBooking/{bookingId}")
	public Mono<Show> updateBooking(@PathVariable int bookingId, @RequestBody Show request) {
		return webClient.put().uri("/update/" + bookingId).bodyValue(request).retrieve().bodyToMono(Show.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookShowClientApplication.class, args);
	}

}
