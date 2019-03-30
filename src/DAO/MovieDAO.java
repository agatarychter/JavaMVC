package DAO;

import model.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MovieDAO implements IMovieDAO {

    private static String FILEPATH = "C:\\Users\\Agata Rychter\\IdeaProjects\\ZTP1\\src\\files\\Movies.txt";

    public boolean insert(Movie movie){
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
            objectOutputStream.writeObject(movie);
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


    public boolean delete(int id)
    {
        boolean found = false;
        List<Movie> movies = getAll();
        Movie toDelete=null;
        for (Movie movie: movies
        ) {if(movie.getId()==id)
            toDelete = movie;
            found = true;
        }

        if(found) {
            movies.remove(toDelete);
            File file = new File(FILEPATH);
            if (file.exists()) {
                file.delete();
                insertAll(movies);
                return true;
            } else
                return false;

        }
        return false;
    }

    public Movie read(int id)
    {
        List<Movie> movies = getAll();
        for (Movie movie: movies
             ) {if(movie.getId()==id)
                 return movie;

        }
        return null;
    }

    public boolean update(int id, String name, String year) {
        boolean found = false;
        List<Movie> movies = getAll();
        for (Movie movie: movies
        ) {if(movie.getId()==id)
            movie.setName(name);
            movie.setYear(year);
            found = true;
        }
        if(found) {
            File file = new File(FILEPATH);
            if (file.exists()) {
                file.delete();
                insertAll(movies);
                return true;
            } else
                return false;
        }
        return false;
    }

    public int getNextMovieId()
    {
        List<Movie> movies = getAll();
        if(movies.isEmpty())
            return 1;
        else
        {
            return movies.get(movies.size()-1).getId()+1;
        }
    }

    public List<Movie> getAll()
    {
        List<Movie> movies = new LinkedList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try
        {
            File file =new File(FILEPATH);
            if (!file.exists()) {
                return movies;
            }
            fileInputStream = new FileInputStream(FILEPATH);

            objectInputStream = new ObjectInputStream(fileInputStream);
                Object object;
                boolean stop = false;
                while(!stop)
                {
                    try {
                        object = objectInputStream.readObject();
                        if (object instanceof Movie)
                            movies.add((Movie) object);
                    } catch (IOException e)
                    {
                        stop = true;
                    }
                }
        }
        catch (StreamCorruptedException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            return movies;

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            if(objectInputStream!=null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return movies;
    }

    public void insertAll(List<Movie> movies)
    {
        for (Movie movie: movies
             ) {
            insert(movie);

        }
    }


}
