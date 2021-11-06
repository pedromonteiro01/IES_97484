package gettingstarted;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerJson {

    Movie[] movies = {
        new Movie(1, "Captain America: The First Avenger", "On your left.", "Steve Rogers"),
        new Movie(2, "Avengers: Endgame", "I am Iron Man.", "Tony Stark"),
        new Movie(3, "Avengers: Infinity War", "You Will Never Be A God.", "Loki"),
        new Movie(4, "Thor Ragnarok", "Your Savior Is Here!", "Loki"),
        new Movie(5, "The Amazing Spider-Man", "Secrets have a cost. They're not free. Not now, not ever.", "Peter Parker"),
        new Movie(6, "Spiderman: Homecoming", "Wait a minute... You guys aren't the real Avengers! I can tell. Hulk gives it away.", "Peter Parker"),
    };

	@GetMapping("/quotes")
	public Movie quote_movie(@RequestParam(value = "show") int id) {
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