package com.wongnai.interview.movie.converter;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.external.MovieData;

public class MovieDataConverter {

    public static Movie toMovie(MovieData movieData) {
        Movie movie = new Movie(movieData.getTitle());
        movie.getActors().addAll(movieData.getCast());
        return movie;
    }
}
