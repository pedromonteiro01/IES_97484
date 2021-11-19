package gettingstarted.forms;

public class PostData {
    private final String quote;
    private final int movieId;
  
    public PostData(String quote, int movieId) {
      this.quote = quote;
      this.movieId = movieId;
    }
  
    public String getQuote() {
      return this.quote;
    }
  
    public int getMovieId() {
      return this.movieId;
    }
}
