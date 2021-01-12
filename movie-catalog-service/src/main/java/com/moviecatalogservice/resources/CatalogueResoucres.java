package com.moviecatalogservice.resources;

import com.moviecatalogservice.model.CatalogueItem;
import com.moviecatalogservice.model.MovieInfo;
import com.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class CatalogueResoucres {

    @Autowired
    private RestTemplate restTemplate;

  /*  @Autowired
    private WebClient.Builder webClientBuilder;
*/
    @RequestMapping("{userId}")
    public List<CatalogueItem> get(@PathVariable("userId") String userId)
    {
        List<Rating> ratings= Arrays.asList(new Rating("foo","4")
                                           ,new Rating("roo","3") );
        return   ratings.stream().map(rating -> {
          /*  MovieInfo movieInfo=webClientBuilder.build()
                                .get()
                                 .uri("http://localhost:8082/movies/"+rating.getMovieId())
                                 .retrieve()
                                 .bodyToMono(MovieInfo.class)
                                 .block();

           */
          MovieInfo movieInfo=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), MovieInfo.class);
               return new CatalogueItem(movieInfo.getName(),"Hollywood",rating.getRating());
              })
                .collect(Collectors.toList());


    }
}
