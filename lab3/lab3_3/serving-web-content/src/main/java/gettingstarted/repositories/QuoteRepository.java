package gettingstarted.repositories;

import java.util.List;

import gettingstarted.entities.Quote;
import gettingstarted.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
  public List<Quote> findByMovie(Movie movie);
}