package com.driver.service;

import com.driver.Repo.MovieRepo;
import com.driver.entity.Director;
import com.driver.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class movieService {
    @Autowired
    MovieRepo movieRepo;
    public void addmovie(Movie movie) {
        if(!movieRepo.moviedb.containsKey((movie.getMovieName()))){
            movieRepo.moviedb.put(movie.getMovieName(), movie);
        }
    }

    public void adddirecor(Director Director) {
        if(!movieRepo.direcdb.containsKey(Director.getDirectorName())){
            movieRepo.direcdb.put(Director.getDirectorName(),Director);
        }
    }

    public void addmoviedirector(String movie,String director) {
        if(movieRepo.moviedb.containsKey(movie)&&movieRepo.direcdb.containsKey(director)){
            if(!movieRepo.directordb.containsKey(director)){
                movieRepo.directordb.put(director,new ArrayList<>());
            }
            movieRepo.directordb.get(director).add(movie);
        }
    }

    public Movie getMovie(String movie) {
        if(movieRepo.moviedb.containsKey(movie)){
            return movieRepo.moviedb.get(movie);
        }
        return null;
    }

    public Director getDirector(String director) {
        if(movieRepo.direcdb.containsKey(director)){
            return movieRepo.direcdb.get(director);
        }
        return null;
    }

    public List<String> getMovieByDirector(String director) {
        if(movieRepo.directordb.containsKey(director)){
            return movieRepo.directordb.get(director);
        }
        return null;
    }

    public List<String> getAllMovies() {
        return new ArrayList<>(movieRepo.moviedb.keySet());
    }

    public void deleteDirector(String director) {
        if(movieRepo.direcdb.containsKey(director))
         movieRepo.direcdb.remove((director));
    }

    public void DeleteAll() {
        movieRepo.directordb.clear();
    }
}
