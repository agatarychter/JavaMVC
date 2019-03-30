package views;
import model.*;

import java.util.List;
import java.util.Scanner;


public class MovieView {
    private Scanner scanner;

    private static final String [] MOVIE_INSERT_PARAMETERS = {"Name: ", "Year: "};
    private static final String [] MOVIE_UPDATE_PARAMETERS = {"Id: ", "Name: ", "Year"};

    private static final String ID_QUERY_MOVIE = "Enter movie's id";

    private static final String MOVIE_NOT_FOUND = "A movie with entered id wasn't found";

    private static final String MOVIE_SUCCESS_INSERT_MESSAGE = "A new movie has been inserted successfully";


    private static final String MOVIE_SUCCESS_UPDATE_MESSAGE = "The movie has been updated";

    private static final String MOVIE_SUCCESS_DELETE_MESSAGE = "The movie has been deleted";

    private static final String FAILURE_MESSAGE = "The operation couldn't be proceeded";

    private static final String UPDATE_INFO = "Enter ID number and then updated data";
    private static final String EMPTY_LIST_MESSAGE = "The list is empty";

    public MovieView()
    {
        scanner = new Scanner(System.in);

    }

    public String [] getMovieInsertParameters()
    {
        String[] insertedParams = new String[MOVIE_INSERT_PARAMETERS.length];
        scanner.nextLine();
        for(int i =0; i< insertedParams.length; i++)
        {
            System.out.println(MOVIE_INSERT_PARAMETERS[i]);
            insertedParams[i] = scanner.nextLine();
        }
        return insertedParams;
    }



    public int getMovieId()
    {
        System.out.println(ID_QUERY_MOVIE);
        return scanner.nextInt();
    }

    public void displayMovie(Movie movie)
    {
        if(movie==null)
            System.out.println(MOVIE_NOT_FOUND);
        else
            System.out.println(movie.toString());
    }

    public String[] getUpdateMovieParameters()
    {
        System.out.println(UPDATE_INFO);
        String[] updatedParams = new String[MOVIE_UPDATE_PARAMETERS.length];
        scanner.nextLine();
        for(int i =0; i< updatedParams.length; i++)
        {
            System.out.println(MOVIE_UPDATE_PARAMETERS[i]);
            updatedParams[i] = scanner.nextLine();
        }
        return updatedParams;

    }


    public void displayMovies(List<Movie> movies)
    {
        if(movies.isEmpty())
            System.out.println(EMPTY_LIST_MESSAGE);
        else
        {
            for (Movie movie:movies
                 ) {
                System.out.println(movie);
            }
        }
    }


    public void displayMessageInsertMovie(boolean success)
    {
        if(success)
        {
            System.out.println(MOVIE_SUCCESS_INSERT_MESSAGE);
        }
        else
        {
            System.out.println(FAILURE_MESSAGE);
        }
    }


    public void displayMessageUpdateMovie(boolean success)
    {
        if(success)
        {
            System.out.println(MOVIE_SUCCESS_UPDATE_MESSAGE);
        }
        else
        {
            System.out.println(FAILURE_MESSAGE);
        }
    }

    public void displayMessageDeleteMovie(boolean success) {
        if (success) {
            System.out.println(MOVIE_SUCCESS_DELETE_MESSAGE);
        } else {
            System.out.println(FAILURE_MESSAGE);
        }
    }
}

