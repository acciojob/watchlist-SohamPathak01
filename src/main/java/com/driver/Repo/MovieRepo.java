package com.driver.Repo;

import com.driver.entity.Director;
import com.driver.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepo {
   public HashMap<String, Movie> moviedb=new HashMap<>();
   public HashMap<String, Director>direcdb=new HashMap<>();
   public  HashMap<String, List<String>> directordb=new HashMap<>();
}
