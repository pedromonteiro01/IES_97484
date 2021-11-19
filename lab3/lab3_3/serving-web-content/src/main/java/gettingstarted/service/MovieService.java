package gettingstarted.service;

import java.util.List;
import java.util.Random;

import gettingstarted.entities.Movie;
import gettingstarted.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private Random random = new Random();

  @Autowired
  private MovieRepository movieRepository;

  public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public List<Movie> saveMovies(List<Movie> movies) {
    return movieRepository.saveAll(movies);
  }

  public List<Movie> getMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovieById(int id) {
    return movieRepository.findById(id).orElse(null);
  }

  public Movie getRandomMovie() {
    List<Movie> movies = movieRepository.findAll();
    //for (Movie m : movies)
    //  System.out.println("Movie: "+m);
    return movies.get(random.nextInt(movies.size()));
  }

  public List<Movie> getMovieByName(String name) {
    return movieRepository.findByName(name);
  }

  public String deleteMovie(int id) {
    movieRepository.deleteById(id);
    return "Successfully deleted movie " + id;
  }

  public Movie updateMovie(Movie movie) {
    Movie current = movieRepository.findById(movie.getId()).orElse(null);
    current.setName(movie.getName());
    current.setYear(movie.getYear());
    return movieRepository.save(current);
  }
}

