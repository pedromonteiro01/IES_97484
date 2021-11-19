package gettingstarted.repositories;

import java.util.List;

import gettingstarted.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
  public List<Movie> findByName(String name);
}
