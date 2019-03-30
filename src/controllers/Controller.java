package controllers;

import DAO.*;
import views.*;
import model.*;

public class Controller {
    private MovieDAO movieDAO;
    private RentalDAO rentalDAO;
    private MovieView movieView;
    private RentalView rentalView;
    private View view;

    public Controller()
    {
        movieDAO = new MovieDAO();
        rentalDAO = new RentalDAO();
        view = new View();
        movieView = new MovieView();
        rentalView = new RentalView();
    }

    private boolean insertMovie(String[] insertParams)
    {
        String name = insertParams[0];
        String year = insertParams[1];
        int id = movieDAO.getNextMovieId();
        return movieDAO.insert(new Movie(id,name,year));
    }

    private boolean updateMovie(String [] updatedParams)
    {
        int id = Integer.valueOf(updatedParams[0]);
        String name = updatedParams[1];
        String year = updatedParams[2];
        return movieDAO.update(id, name, year);
    }

    private void readMovie(int id)
    {
        movieView.displayMovie(movieDAO.read(id));
    }

    private boolean deleteMovie(int id)
    {
        rentalDAO.delete(movieDAO.read(id));
        return movieDAO.delete(id);

    }

    private void displayMovies()
    {
        movieView.displayMovies(movieDAO.getAll());
    }

    private void displayRentals()
    {
        rentalView.displayRentals(rentalDAO.getAll());
    }

    private void displayMovieRentals(int id)
    {
        rentalView.displayRentals(rentalDAO.getMovieRentals(id));
    }

    private boolean insertRental(String [] insertParams)
    {
        String date = insertParams[0];
        String person = insertParams[1];
        Movie movie = movieDAO.read(Integer.valueOf(insertParams[2]));
        int id = rentalDAO.getNextRentalId();
        return rentalDAO.insert(new Rental(id, date, person, movie));

    }

    private void readRental(int id)
    {
        rentalView.displayRental(rentalDAO.read(id));
    }

    private boolean updateRental(String[] updatedParams)
    {
        int id = Integer.valueOf(updatedParams[0]);
        String date = updatedParams[1];
        String person = updatedParams[2];
        int movieId = Integer.valueOf(updatedParams[3]);
        return rentalDAO.update(id,date, person, movieDAO.read(movieId));
    }

    private boolean deleteRental(int id)
    {
        return rentalDAO.delete(id);
    }

    public void start()
    {
        int menuOption = -1;

        while(menuOption!=0)
        {
            menuOption = view.getMenuOption();
            switch(menuOption)
            {
                case 1:
                    movieView.displayMessageInsertMovie(insertMovie(movieView.getMovieInsertParameters()));
                    break;
                case 2:
                    readMovie(movieView.getMovieId());
                    break;
                case 3:
                    movieView.displayMessageUpdateMovie(updateMovie(movieView.getUpdateMovieParameters()));
                    break;
                case 4:
                    movieView.displayMessageDeleteMovie(deleteMovie(movieView.getMovieId()));
                    break;
                case 5:
                    rentalView.displayMessageInsertRental(insertRental(rentalView.getRentalInsertParameters()));
                    break;
                case 6:
                    readRental(rentalView.getRentalId());
                    break;
                case 7:
                    rentalView.displayMessageUpdateRental(updateRental(rentalView.getUpdateRentalParameters()));
                    break;
                case 8:
                    rentalView.displayMessageDeleteRental(deleteRental(rentalView.getRentalId()));
                    break;
                case 9:
                    displayMovies();
                    break;
                case 10:
                   displayRentals();
                    break;
                case 11:
                    displayMovieRentals(movieView.getMovieId());
            }
        }
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public RentalDAO getRentalDAO() {
        return rentalDAO;
    }

    public MovieView getMovieView() {
        return movieView;
    }
}
