package com.wongnai.interview.movie.converter;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieInvertedIndex;

public class MovieConverter {

    public static MovieInvertedIndex invertedIndex(Iterable<Movie> movieList) {

        MovieInvertedIndex indexList = new MovieInvertedIndex();

        movieList.forEach(indexList::putMovie);

        return indexList;
    }
}
