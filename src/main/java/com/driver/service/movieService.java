package com.driver.service;

import com.driver.Repo.MovieRepo;
import com.driver.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class movieService {
    MovieRepo movieRepo;
    public void addmovie(Movie movie) {
        if(!movieRepo.moviedb.containsKey((movie.getMovieName()))){
            movieRepo.moviedb.put(movie.getMovieName(), movie);
        }
    }

    public void adddirecor(String Director) {
        if(!movieRepo.directordb.containsKey(Director)){
            movieRepo.directordb.put(Director,new ArrayList<Movie>());
        }
    }

    public void addmoviedirector(Movie movie) {
        if(movieRepo.directordb.containsKey(movie.getMovieDirector())){
            movieRepo.directordb.get(movie.getMovieDirector()).add(movie);
        }
        else{
            movieRepo.directordb.put(movie.getMovieDirector(),new ArrayList<>());
            movieRepo.directordb.get(movie.getMovieDirector()).add(movie);

        }
    }

    public Movie getMovie(String movie) {
        if(movieRepo.moviedb.containsKey(movie)){
            return movieRepo.moviedb.get(movie);
        }
        return null;
    }

    public String getDirector(String director) {
        if(movieRepo.directordb.containsKey(director)){
            return director;
        }
        return null;
    }

    public List<Movie> getMovieByDirector(String director) {
        if(movieRepo.directordb.containsKey(director)){
            return movieRepo.directordb.get(director);
        }
        return null;
    }

    public List<String> getAllMovies() {
        return new ArrayList<>(movieRepo.moviedb.keySet());
    }

    public void deleteDirector(String director) {
        if(movieRepo.directordb.containsKey((director)))
         movieRepo.directordb.remove((director));
    }

    public void DeleteAll() {
        movieRepo.directordb.clear();
    }
}
