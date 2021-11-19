package gettingstarted.service;

import java.util.List;
import java.util.Random;

import gettingstarted.entities.Quote;
import gettingstarted.entities.Movie;
import gettingstarted.repositories.QuoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private Random random = new Random();

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    public List<Quote> saveQuotes(List<Quote> quotes) {
        return quoteRepository.saveAll(quotes);
    }

    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    public Quote getRandomQuote(Movie movie) {
        List<Quote> quotes = quoteRepository.findByMovie(movie);
        if (quotes.size() > 0)
            return quotes.get(random.nextInt(quotes.size()));

        return null;
    }

    public List<Quote> getQuoteByShow(Movie movie) {
        return quoteRepository.findByMovie(movie);
    }

    public String deleteQuote(int id) {
        quoteRepository.deleteById(id);
        return "Successfully deleted quote " + id;
    }

    public Quote updateQuote(Quote quote) {
        Quote current = quoteRepository.findById(quote.getQuoteId()).orElse(null);
        current.setQuote(quote.getQuote());
        return quoteRepository.save(current);
    }
}
