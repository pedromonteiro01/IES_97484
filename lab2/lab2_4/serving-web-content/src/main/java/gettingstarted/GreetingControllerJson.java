package gettingstarted;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerJson {

    Movie[] movies = {
        new Movie(1, "Movie1", "quote1"),
        new Movie(2, "Movie2", "quote2"),
        new Movie(3, "Movie3", "quote3"),
        new Movie(4, "Movie4", "quote4"),
        new Movie(5, "Movie5", "quote5"),
        new Movie(6, "Movie6", "quote6"),
        new Movie(7, "Movie7", "quote7"),
    };

	@GetMapping("/quotes")
	public Movie quote_movie(@RequestParam(value = "show", defaultValue = "World") int id) {
		return movies[id-1];
	}

    @GetMapping("/shows")
	public Movie[] shows() {
		return movies;
	}

    @GetMapping("/quote")
	public Movie quote() {
		return movies[new Random().nextInt(movies.length-1)+1];
	}
}