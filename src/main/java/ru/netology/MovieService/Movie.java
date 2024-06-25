package ru.netology.MovieService;
public class Movie {
    private int movieId; // идентиф.номер фильма
    private String movieName; //название фильма
    private String movieType; //жанр фильма

    public Movie(int movieId, String movieName, String movieType) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
    }
}