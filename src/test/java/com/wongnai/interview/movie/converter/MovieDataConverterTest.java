package com.wongnai.interview.movie.converter;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.external.MovieData;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MovieDataConverterTest {

    @Test
    public void testConvertToMovie() {

        MovieData movieData1 = new MovieData();
        movieData1.setTitle("A");
        movieData1.setCast(Arrays.asList("Mr.A1", "Mr.B1"));

        Movie movie = MovieDataConverter.toMovie(movieData1);

        Assert.assertThat(movie, Matchers.notNullValue());
        Assert.assertThat(movie.getName(), Matchers.equalTo("A"));
        Assert.assertThat(movie.getActors().size(), Matchers.equalTo(2));
        Assert.assertThat(movie.getActors().get(0), Matchers.equalTo("Mr.A1"));
        Assert.assertThat(movie.getActors().get(1), Matchers.equalTo("Mr.B1"));
    }
}
