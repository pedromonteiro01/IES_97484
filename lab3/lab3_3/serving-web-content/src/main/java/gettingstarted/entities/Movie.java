package gettingstarted.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "movies")
    public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int year;

    public Movie() {
    }

    public Movie(int id) {
        this.id = id;
    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Column(name = "id")
    public int getId() {
        return this.id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "year")
    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", year='" + getYear() + "'" +
            "}";
    }

}
