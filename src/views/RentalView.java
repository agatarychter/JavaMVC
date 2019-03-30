package views;

import model.*;
import java.util.List;
import java.util.Scanner;

public class RentalView {
    private Scanner scanner;

    private static final String [] RENTAL_INSERT_PARAMETERS = {"Date: ", "Person name: ", "model.Movie ID: "};
    private static final String [] RENTAL_UPDATE_PARAMETERS = {"Id: ", "Date: ", "Person name: ", "model.Movie ID: "};
    private static final String ID_QUERY_RENTAL = "Enter rental's id";
    private static final String RENTAL_NOT_FOUND = "A rental with entered id wasn't found";
    private static final String RENTAL_SUCCESS_INSERT_MESSAGE = "A new rental has been inserted successfully";
    private static final String RENTAL_SUCCESS_UPDATE_MESSAGE = "The rental has been updated";
    private static final String RENTAL_SUCCESS_DELETE_MESSAGE = "The rental has been deleted";

    private static final String FAILURE_MESSAGE = "The operation couldn't be proceeded";

    private static final String UPDATE_INFO = "Enter ID number and then updated data";
    private static final String EMPTY_LIST_MESSAGE = "The list is empty";

    public RentalView()
    {
        scanner = new Scanner(System.in);

    }

    public String [] getRentalInsertParameters()
    {
        String [] insertedParams = new String[RENTAL_INSERT_PARAMETERS.length];
        scanner.nextLine();
        for(int i = 0;i<insertedParams.length; i++)
        {
            System.out.println(RENTAL_INSERT_PARAMETERS[i]);
            insertedParams[i] = scanner.nextLine();
        }
        return insertedParams;
    }

    public int getRentalId()
    {
        System.out.println(ID_QUERY_RENTAL);
        return scanner.nextInt();
    }

    public void displayRental(Rental rental)
    {
        if(rental==null)
            System.out.println(RENTAL_NOT_FOUND);
        else
            System.out.println(rental.toString());
    }

    public String[] getUpdateRentalParameters()
    {
        System.out.println(UPDATE_INFO);
        String[] updatedParams = new String[RENTAL_UPDATE_PARAMETERS.length];
        scanner.nextLine();
        for(int i =0; i< updatedParams.length; i++)
        {
            System.out.println(RENTAL_UPDATE_PARAMETERS[i]);
            updatedParams[i] = scanner.nextLine();
        }
        return updatedParams;
    }

    public void displayRentals(List<Rental> rentals)
    {
        if(rentals.isEmpty())
            System.out.println(EMPTY_LIST_MESSAGE);
        else
        {
            for (Rental rental: rentals
            ) {
                System.out.println(rental);
            }
        }

    }

    public void displayMessageInsertRental(boolean success)
    {
        if(success)
        {
            System.out.println(RENTAL_SUCCESS_INSERT_MESSAGE);
        }
        else
        {
            System.out.println(FAILURE_MESSAGE);
        }
    }

    public void displayMessageUpdateRental(boolean success)
    {
        if(success)
        {
            System.out.println(RENTAL_SUCCESS_UPDATE_MESSAGE);
        }
        else
        {
            System.out.println(FAILURE_MESSAGE);
        }
    }

    public void displayMessageDeleteRental(boolean success)
    {
        if(success)
        {
            System.out.println(RENTAL_SUCCESS_DELETE_MESSAGE);
        }
        else
        {
            System.out.println(FAILURE_MESSAGE);
        }
    }






}
