package com.driver.controller;

import com.driver.entity.Movie;
import com.driver.service.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("movies")
public class  movieController {

    @Autowired
    movieService ms;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        ms.addmovie(movie);
        return new ResponseEntity<>("New Movie Added Sucuessfully", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody String director){
        ms.adddirecor(director);
        return new ResponseEntity<>("New Director Added",HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirector(@RequestBody Movie movie){
        ms.addmoviedirector(movie);
        return new ResponseEntity<>("movie director pair added",HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovie(@PathVariable String movie){
        return new ResponseEntity<>(ms.getMovie(movie),HttpStatus.FOUND);
    }
    @GetMapping("get-director-by-name/{name}")
    public  ResponseEntity<String> getdirector(@PathVariable String Director){
        return new ResponseEntity<>(ms.getDirector(Director),HttpStatus.FOUND);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public  ResponseEntity<List<Movie>> getMovieByDirector(@PathVariable String Director){
        return new ResponseEntity<>(ms.getMovieByDirector(Director),HttpStatus.FOUND);
    }

    @GetMapping("get-all-movies")
    public  ResponseEntity<List<String>> getallMovies(){
        return new ResponseEntity<>(ms.getAllMovies(),HttpStatus.FOUND);
    }

    @DeleteMapping("delete-director")
    public  ResponseEntity<String> deleteDirector(@RequestParam String Director){
        ms.deleteDirector(Director);
        return new ResponseEntity<>("Done",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete-all-directors")
    public ResponseEntity<HttpStatus> deleteAll(){
        ms.DeleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
