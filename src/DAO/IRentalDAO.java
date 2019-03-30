package DAO;

import model.*;
import java.util.List;

public interface IRentalDAO extends IDAO<Rental> {
    boolean insert(Rental rental);
    boolean delete(int id);
    Rental read(int id);
    boolean update(int id, String date, String person, Movie movie);
    int getNextRentalId();
    List<Rental> getAll();
    void insertAll(List<Rental> movies);
}
