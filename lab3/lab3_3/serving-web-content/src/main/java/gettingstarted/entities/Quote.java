package gettingstarted.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    @Entity
    @Table(name = "quote")
    public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quoteId;
    private String quote;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public Quote() {
    }

    public Quote(String quote, Movie movie) {
        this.quote = quote;
        this.movie = movie;
    }

    @Column(name = "id")
    public int getQuoteId() {
        return this.quoteId;
    }

    @Column(name = "quote")
    public String getQuote() {
        return this.quote;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "{" +
            " quoteId='" + getQuoteId() + "'" +
            ", quote='" + getQuote() + "'" +
            ", show='" + getMovie() + "'" +
            "}";
    }

}
