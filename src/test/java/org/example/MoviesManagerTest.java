package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {

    MoviesManager manager = new MoviesManager();

    Movie movie1 = new Movie("Человек за бортом");
    Movie movie2 = new Movie("Назад в будущее 1");
    Movie movie3 = new Movie("Матрица");
    Movie movie4 = new Movie("Матрица2");
    Movie movie5 = new Movie("Матрица3");
    Movie movie6 = new Movie("Кошмар на улице Вязов");
    Movie movie7 = new Movie("Жизнь прекрасна");
    Movie movie8 = new Movie("Двое: я и моя тень");
    Movie movie9 = new Movie("Молчание ягнят");
    Movie movie10 = new Movie("Куда приводят мечты");

    @BeforeEach
    public void setup(){
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
    }

    @Test
    public void findAllMoviesTest(){
        Movie[] expected = {movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastWhereMaxByDefaultTest(){
        Movie[] expected = {movie10, movie9, movie8, movie7, movie6};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  findLastMaxLessThenByDefaultTest(){
        MoviesManager manager1 = new MoviesManager(4);
        Movie movie1 = new Movie("Человек за бортом");
        Movie movie2 = new Movie("Назад в будущее 1");
        Movie movie3 = new Movie("Матрица");
        Movie movie4 = new Movie("Матрица2");
        Movie movie5 = new Movie("Матрица3");
        Movie movie6 = new Movie("Кошмар на улице Вязов");
        manager1.addMovie(movie1);
        manager1.addMovie(movie2);
        manager1.addMovie(movie3);
        manager1.addMovie(movie4);
        manager1.addMovie(movie5);
        manager1.addMovie(movie6);

        Movie[] expected = {movie6, movie5, movie4, movie3};
        Movie[] actual = manager1.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  findLastMaxMoreThenLengthAllMoviesTest(){
        MoviesManager manager2 = new MoviesManager(7);
        Movie movie1 = new Movie("Человек за бортом");
        Movie movie2 = new Movie("Назад в будущее 1");
        Movie movie3 = new Movie("Матрица");
        Movie movie4 = new Movie("Матрица2");
        Movie movie5 = new Movie("Матрица3");
        Movie movie6 = new Movie("Кошмар на улице Вязов");
        manager2.addMovie(movie1);
        manager2.addMovie(movie2);
        manager2.addMovie(movie3);
        manager2.addMovie(movie4);
        manager2.addMovie(movie5);
        manager2.addMovie(movie6);

        Movie[] expected = {movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = manager2.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

}
