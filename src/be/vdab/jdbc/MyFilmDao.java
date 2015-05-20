package be.vdab.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeansmits on 20/05/15.
 */
public class MyFilmDao implements FilmDao {

    @Override
    public Film findFilmById(int id) {
        Connection c = createConnection();
        Statement statement = null;
        try {
            statement  = c.createStatement();
            ResultSet rs = statement.executeQuery("Select * from film where film_id like '" + id + "'");
            rs.next();
            Film f = new Film(id,rs.getString("title"),rs.getInt("release_year"));

            return f;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Film> findAllFilms() {
        Connection c = createConnection();
        Statement statement = null;
        List<Film> films = new ArrayList<>();
        try {
            statement  = c.createStatement();
            ResultSet rs = statement.executeQuery("Select * from film");

            while(rs.next()) {
                Film f = new Film(rs.getInt("film_id"),rs.getString("title"),rs.getInt("release_year"));
                films.add(f);
            }
            return films;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public boolean updateFilm(Film film) throws IllegalArgumentException {
        Connection c = createConnection();
        Statement statement;

        try {
            statement  = c.createStatement();
            statement.executeUpdate("UPDATE film SET title='" + film.getTitle() +  "' , release_year='" + film.release_year + "' WHERE film_id = '" + film.getFilm_id() + "'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteFilm(int id) {
        Connection c = createConnection();
        Statement statement;

        try {
            statement  = c.createStatement();
            statement.executeUpdate("DELETE FROM film WHERE film_id = '" + id + "'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }



    private static Connection createConnection () {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username  = "root";
        String password = "";
        String driverClassName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Unable to create connection. Check your settings" , e);
        }
    }
}
