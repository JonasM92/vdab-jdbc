package be.vdab.jdbc;

/**
 * Created by jeansmits on 20/05/15.
 */
public class Film {

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getReleaseYear() {
        return release_year;
    }

    public void setReleaseYear(int release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    int film_id, release_year;
    String title;


    public Film(int film_id, String title, int releaseYear) {
        this.film_id = film_id;
        this.title = title;
        this.release_year = releaseYear;
    }

    public String toString() {
        String s = film_id + "\t" + title + "\t" + release_year;
        return s;
    }

}
