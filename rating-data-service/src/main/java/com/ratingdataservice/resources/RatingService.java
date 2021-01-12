package com.ratingdataservice.resources;

import com.ratingdataservice.model.Rating;
import com.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingService {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId)
    {
        return new Rating(movieId,"4");
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId)
    {

        List<Rating> ratingList= Arrays.asList(
                                   new Rating("1","4"),
                                   new Rating("2","5"));
        UserRating userRating=new UserRating();
        userRating.setUserList(ratingList);
        return userRating;
    }

}
