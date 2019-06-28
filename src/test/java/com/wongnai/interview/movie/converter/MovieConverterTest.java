package com.wongnai.interview.movie.converter;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieInvertedIndex;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieConverterTest {

    @Test
    public void testInvertedIndex() {

        Movie mockMovie1 = Mockito.mock(Movie.class);
        when(mockMovie1.getName()).thenReturn("Star Wars");
        when(mockMovie1.getId()).thenReturn(1L);

        Movie mockMovie2 = Mockito.mock(Movie.class);
        when(mockMovie2.getName()).thenReturn("Star duster");
        when(mockMovie2.getId()).thenReturn(2L);

        MovieInvertedIndex movieInvertedIndex = MovieConverter.invertedIndex(Arrays.asList(mockMovie1, mockMovie2));

        Assert.assertThat(movieInvertedIndex, Matchers.notNullValue());
        Assert.assertThat(movieInvertedIndex.size(), Matchers.equalTo(3));
    }
}
