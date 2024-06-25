package ru.netology.MovieService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager cinema = new MovieManager();
    Movie film_1 = new Movie(1, "Бладшот", "боевик");
    Movie film_2 = new Movie(2, "Вперед", "мультфильм");
    Movie film_3 = new Movie(3, "Отель <<Белград>>", "комедия");
    Movie film_4 = new Movie(4, "Джентельмены", "боевик");
    Movie film_5 = new Movie(5, "Человек - невидимка", "ужасы");
    Movie film_6 = new Movie(6, "Тролли.Мировой тур", "мульфильм");
    Movie film_7 = new Movie(7, "Номер один", "комедия");

    @BeforeEach
    public void setup() {
        cinema.addMovie(film_1);
        cinema.addMovie(film_2);
        cinema.addMovie(film_3);
        cinema.addMovie(film_4);
        cinema.addMovie(film_5);
        cinema.addMovie(film_6);
        cinema.addMovie(film_7);
    }

    @Test
    public void testAddMovie() {

        Movie[] expected = {film_1, film_2, film_3, film_4, film_5, film_6, film_7};
        Movie[] actual = cinema.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithoutLimit() {
        Movie[] expected = {film_7, film_6, film_5, film_4, film_3};
        Movie[] actual = cinema.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithLimit_1() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie(film_1);
        manager.addMovie(film_2);
        manager.addMovie(film_3);
        manager.addMovie(film_4);
        manager.addMovie(film_5);
        manager.addMovie(film_6);
        Movie[] expected = {film_6, film_5, film_4};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithLimit_2() {
        MovieManager manager = new MovieManager(6);
        manager.addMovie(film_1);
        manager.addMovie(film_2);
        manager.addMovie(film_3);
        manager.addMovie(film_4);
        Movie[] expected = {film_4, film_3, film_2, film_1};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}