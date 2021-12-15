package edu.northeastern.finalexam;

import java.text.SimpleDateFormat;
import java.util.*;

public class Question4 {

    public static void main(String[] args) throws Exception {
        Netflix netflix = new Netflix(new ArrayList<>());

        // Comedy
        Genre comedy = new Genre(new ArrayList<>());
        comedy.addMovies(new Movie("Comedy1", "1997-02-06", Arrays.asList("a", "b"), "A"));
        comedy.addMovies(new Movie("Comedy2", "1989-01-01", Arrays.asList("a", "b"), "B"));
        comedy.addMovies(new Movie("Comedy3", "2002-03-15", Arrays.asList("a", "b"), "C"));
        comedy.addMovies(new Movie("Comedy4", "1996-07-07", Arrays.asList("a", "b"), "D"));

        // Horror
        Genre horror = new Genre(new ArrayList<>());
        horror.addMovies(new Movie("Horror1", "1995-12-12", Arrays.asList("a", "b"), "E"));
        horror.addMovies(new Movie("Horror2", "2010-12-13", Arrays.asList("a", "b"), "F"));
        horror.addMovies(new Movie("Horror3", "1993-02-14", Arrays.asList("a", "b"), "G"));

        // Action
        Genre action = new Genre(new ArrayList<>());
        action.addMovies(new Movie("Action1", "1998-08-08", Arrays.asList("a", "b"), "H"));
        action.addMovies(new Movie("Action2", "1996-08-08", Arrays.asList("a", "b"), "I"));
        action.addMovies(new Movie("Action3", "1994-08-08", Arrays.asList("a", "b"), "J"));

        // Romantic
        Genre romantic = new Genre(new ArrayList<>());
        romantic.addMovies(new Movie("Romantic1", "2013-12-12", Arrays.asList("c", "d"), "K"));
        romantic.addMovies(new Movie("Romantic2", "1987-07-12", Arrays.asList("c", "d"), "L"));
        romantic.addMovies(new Movie("Romantic3", "2021-12-14", Arrays.asList("e", "d"), "M"));

        netflix.addGenres(comedy);
        netflix.addGenres(horror);
        netflix.addGenres(action);
        netflix.addGenres(romantic);

        netflix.getGenres().stream().
                flatMap(genre -> genre.getMovies().stream()).
                filter(movie -> movie.getReleaseDate().before(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime())).
                forEach(movie -> movie.setTitle(String.format("%s (Classic)", movie.getTitle())));

        List<Movie> latestThree = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .sorted((movie1, movie2) -> movie2.getReleaseDate().compareTo(movie1.getReleaseDate())).limit(3).toList();
        System.out.println("--------------- Latest 3 movies -----------------");
        for (Movie m : latestThree) {
            System.out.println(m);
        }

        List<Movie> between1990And2000 = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .filter(movie -> movie.getReleaseDate().before(new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime()))
                .filter(movie -> movie.getReleaseDate().after(new GregorianCalendar(1990, Calendar.JANUARY, 1).getTime()))
                .toList();
        System.out.println("--------------- Movies between 1990 and 2000 -------------------");
        for (Movie m : between1990And2000) {
            System.out.println(m);
        }

        // Add release year to the tile and return titles.
        List<String> titles = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .map(movie -> {
                    movie.setTitle(String.format("%s %d", movie.getTitle(), movie.getReleaseDate().getYear() + 1900));
                    return movie.getTitle();
                }).toList();
        System.out.println("----------------- Title with year ----------------------");
        for (String t : titles) {
            System.out.println(t);
        }

        // Sorting based on Release date
        List<Movie> sortedMovies = netflix.getGenres().stream().flatMap(genre -> genre.getMovies().stream())
                .sorted(Comparator.comparing(Movie::getReleaseDate)).toList();
        System.out.println("----------------- Sorted by release date --------------------");
        for (Movie m : sortedMovies) {
            System.out.println(m);
        }
    }
}


class Netflix {
    private final List<Genre> genres;

    Netflix(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenres(Genre genre) {
        genres.add(genre);
    }
}

class Genre {
    private final List<Movie> movies;

    Genre(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovies(Movie movie) {
        movies.add(movie);
    }
}

class Movie {
    private String title;
    private Date releaseDate;
    private List<String> actors;
    private String director;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    Movie(String title, String releaseDate, List<String> actors, String director) throws Exception {
        this.title = title;
        this.releaseDate = sdf.parse(releaseDate);
        this.actors = actors;
        this.director = director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Release Data: %s, Director: %s", title, sdf.format(releaseDate), director);
    }
}