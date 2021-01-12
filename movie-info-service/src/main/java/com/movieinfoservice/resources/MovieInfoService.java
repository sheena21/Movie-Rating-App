package com.movieinfoservice.resources;

import com.movieinfoservice.model.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/movies")
public class MovieInfoService {

    @RequestMapping("/{movieId}")
    public MovieInfo getMovie(@PathVariable("movieId") String movieId)
    {
       return  new MovieInfo("1","IronMan");
    }
}
