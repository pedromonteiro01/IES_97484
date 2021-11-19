package gettingstarted.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gettingstarted.entities.Quote;
import gettingstarted.forms.PostData;
import gettingstarted.entities.Movie;
import gettingstarted.service.QuoteService;
import gettingstarted.service.MovieService;

import java.util.List;

import javax.validation.Valid;


@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote")
    public Quote quote() {
        return quoteService.getRandomQuote(movieService.getRandomMovie());
    }

    @GetMapping("/shows")
    public List<Movie> movies() {
        return movieService.getMovies();
    }

    @PostMapping("/shows")
    public Movie newShow(@RequestBody Movie movie) {
      return movieService.saveMovie(movie);
    }

    @GetMapping("/quotes")
    public Quote quotes(@RequestParam(name = "movie", required = true) int movieId) {
        return quoteService.getRandomQuote(movieService.getMovieById(movieId));
    }

    @PostMapping("/quotes")
    public Quote newQuote(@Valid @RequestBody PostData quote) {
      return quoteService.saveQuote(new Quote(quote.getQuote(), movieService.getMovieById(quote.getMovieId())));
    }
}