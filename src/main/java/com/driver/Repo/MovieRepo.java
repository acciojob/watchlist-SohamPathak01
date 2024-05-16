package com.driver.Repo;

import com.driver.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepo {
   public HashMap<String, Movie> moviedb=new HashMap<>();
   //public HashMap<String,String>directordb=new HashMap<>();
   public  HashMap<String, List<Movie>> directordb=new HashMap<>();
}
