package DAO;

import model.*;
import java.util.List;

public interface IMovieDAO extends IDAO<Movie> {
    boolean insert(Movie movie);
    boolean delete(int id);
    Movie read(int id);
    boolean update(int id, String name, String year);
    int getNextMovieId();
    List<Movie> getAll();
    void insertAll(List<Movie> movies);
}
