package DAO;
import model.*;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RentalDAO implements IRentalDAO {
    private static String FILEPATH = "C:\\Users\\Agata Rychter\\IdeaProjects\\ZTP1\\src\\files\\Rentals.txt";

    public boolean insert(Rental rental){
        boolean toReturn = false;
        FileOutputStream fileOut = null;
        ObjectOutputStream objectOutputStream = null;
        File file =new File(FILEPATH);
        try {
            boolean isNewFile = false;
            if (!file.exists()) {
                isNewFile = true;
            }
            fileOut = new FileOutputStream(file,true);

            if(isNewFile) {
                objectOutputStream = new ObjectOutputStream(fileOut);
            }
            else {
                objectOutputStream = new AppendingObjectOutputStream(fileOut);
            }
            objectOutputStream.writeObject(rental);
            toReturn = true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if(objectOutputStream!=null)
            {
                try{
                    objectOutputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(fileOut!=null)
            {
                try{
                    fileOut.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return toReturn;
    }

    public Rental read(int id)
    {
        List<Rental> rentals = getAll();
        for (Rental rental: rentals
        ) {if(rental.getId()==id)
            return rental;

        }
        return null;
    }

    public boolean update(int id, String date, String person, Movie movie) {
        boolean found = false;
        List<Rental> rentals = getAll();
        for (Rental rental: rentals
        ) {if(rental.getId()==id) {
            rental.setDate(date);
            rental.setPerson(person);
            rental.setMovie(movie);
            found = true;
        }

        }
        if(found) {
            File file = new File(FILEPATH);
            if (file.exists()) {
                file.delete();
                insertAll(rentals);
                return true;
            } else
                return false;
        }
        return false;
    }

    public boolean delete(int id)
    {
        boolean found = false;
        List<Rental> rentals = getAll();
        List<Rental> toDelete = new LinkedList<>();
        for (Rental rental: rentals
        ) {if(rental.getId()==id) {
            found = true;
            toDelete.add(rental);
        }
        }
        if(found) {
            rentals.removeAll(toDelete);
            File file = new File(FILEPATH);
            if (file.exists()) {
                file.delete();
                insertAll(rentals);
                return true;
            } else
                return false;

        }
        return false;
    }

    public boolean delete(Movie movie)
    {
        boolean found = false;
        List<Rental> rentals = getAll();
        Iterator<Rental> iter = rentals.iterator();

        while (iter.hasNext()) {
            Rental rental = iter.next();

            if (rental.getMovie().equals(movie)) {
                iter.remove();
                found = true;
            }
        }
        if(found) {
            File file = new File(FILEPATH);
            if (file.exists()) {
                file.delete();
                insertAll(rentals);
                return true;
            } else
                return false;

        }
        return false;
    }
    public List<Rental> getAll() {
        List<Rental> rentals = new LinkedList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            File file = new File(FILEPATH);
            if (!file.exists()) {
                return rentals;
            }
            fileInputStream = new FileInputStream(FILEPATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object;
            boolean stop = false;
            while (!stop) {
                try {
                    object = objectInputStream.readObject();
                    if (object instanceof Rental)
                        rentals.add((Rental) object);
                } catch (IOException e) {
                    stop = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return rentals;
    }

    public int getNextRentalId()
    {
        List<Rental> rentals = getAll();
        if(rentals.isEmpty())
            return 1;
        else
        {
            return rentals.get(rentals.size()-1).getId()+1;
        }
    }

    public void insertAll(List<Rental> rentals)
    {
        for (Rental rental: rentals
        ) {
            insert(rental);
        }
    }

    public List<Rental> getMovieRentals(int id)
    {
        List<Rental> rentals = getAll();
        List<Rental> movieRentals = new LinkedList<>();

        for (Rental rental: rentals
             ) {
            if(rental.getMovie().getId()==id)
                movieRentals.add(rental);

        }
        return movieRentals;
    }




}
