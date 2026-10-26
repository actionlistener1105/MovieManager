package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MoviesManager {

    private Movie movie;
    private int maxCount = 5;
    private Movie[] lastMovies;
    private Movie[] allMovies = new Movie[1];

    public MoviesManager(int maxCount){
        this.maxCount = maxCount;
    }

    public void addMovie(Movie movie){
        if (allMovies[0] != null){
            Movie[] temp = new Movie[allMovies.length + 1];
            for(int i = 0; i < allMovies.length; i++) {
                temp[i] = allMovies[i];
            }
            temp[temp.length - 1] = movie;
            allMovies = temp;
        }
        else {
            allMovies[0] = movie;
        }
    }

    public Movie[] findLast(){
        if (allMovies.length > maxCount){
            lastMovies = new Movie[maxCount];
            int index = 0;
            for(int i = allMovies.length - 1; i > allMovies.length - 1 - maxCount; i--){
                lastMovies[index] = allMovies[i];
                index++;
            }
            return lastMovies;
        }
        if(allMovies.length <= maxCount) {
            return findAll();
        }
        return null;
    }

    public Movie[] findAll(){
        Movie[] reversed = new Movie[allMovies.length];
        for (int i = 0; i < reversed.length; i++){
            reversed[i] = allMovies[allMovies.length -1 -i];
        }
        return reversed;
    }

}
