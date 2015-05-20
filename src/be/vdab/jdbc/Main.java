package be.vdab.jdbc;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilmDao dao = new MyFilmDao();

        // Example usage:
        List<Film> films = dao.findAllFilms();
        for (Film film : films) {
            System.out.println(film.getTitle());
        }

        // Example usage:
        Film film = dao.findFilmById(425);
        System.out.println(film.toString());
        film.setReleaseYear(2014);
        dao.updateFilm(film);

        // Example usage:
        dao.deleteFilm(1000);

        // ... play around with this.
    }
}
