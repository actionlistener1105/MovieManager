package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviesManager {

    private int maxCount = 5;
    private Movie[] allMovies = new Movie[0];

    public MoviesManager(int maxCount) {
        this.maxCount = maxCount;
    }

    public void addMovie(Movie movie) {
        Movie[] temp = new Movie[allMovies.length + 1];

        for (int i = 0; i < allMovies.length; i++) {
            temp[i] = allMovies[i];
        }

        temp[temp.length - 1] = movie;
        allMovies = temp;
    }

    public Movie[] findLast() {
        if (allMovies.length > maxCount) {
            Movie[] lastMovies = new Movie[maxCount];
            int index = 0;
            for (int i = allMovies.length - 1; i > allMovies.length - 1 - maxCount; i--) {
                lastMovies[index] = allMovies[i];
                index++;
            }
            return lastMovies;
        } else {
            return findAll();
        }
    }

    public Movie[] findAll() {
        Movie[] reversed = new Movie[allMovies.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = allMovies[allMovies.length - 1 - i];
        }
        return reversed;
    }
}
