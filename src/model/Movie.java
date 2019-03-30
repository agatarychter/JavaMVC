package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String name;
    private String year;

    public Movie(int id, String name, String year)
    {
        this.id = id;
        this.name = name;

        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String toString()
    {
        return "{Id: " + id + ", Name: " + name + ", year: " + year + "}";
    }

    public boolean equals(Object object)  {
        return this.id == ((Movie)object).id;
    }
}
