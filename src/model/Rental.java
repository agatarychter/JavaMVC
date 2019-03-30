package model;

import java.io.Serializable;

public class Rental implements Serializable {
    private int id;
    private String date;
    private String person;
    private Movie movie;

    public Rental(int id, String date, String person, Movie movie) {
        this.id = id;
        this.date = date;
        this.person = person;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String toString()
    {
        return "[Id: " + id + ", Date: " + date + ", model.Movie: " + movie.toString() + "]";
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public boolean equals(Object object)  {
        return this.id == ((Rental)object).id;
    }
}
