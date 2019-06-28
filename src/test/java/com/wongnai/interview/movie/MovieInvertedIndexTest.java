package com.wongnai.interview.movie;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.when;

public class MovieInvertedIndexTest {

    @Test
    public void testFindByQueryText() {

        MovieInvertedIndex indexList = new MovieInvertedIndex();

        indexList.put("star", new HashSet<>(Arrays.asList(5L, 8L, 1L)));
        indexList.put("war", new HashSet<>(Arrays.asList(5L, 2L)));

        List<Long> resultIds = indexList.findByQueryText("Star war");

        Assert.assertThat(resultIds, Matchers.notNullValue());
        Assert.assertThat(resultIds.size(), Matchers.equalTo(1));
        Assert.assertThat(resultIds.get(0), Matchers.equalTo(5L));

        resultIds = indexList.findByQueryText("Star war girls");

        Assert.assertThat(resultIds, Matchers.notNullValue());
        Assert.assertThat(resultIds.size(), Matchers.equalTo(0));
    }

    @Test
    public void testPutMovie() {

        Movie mockMovie1 = Mockito.mock(Movie.class);

        when(mockMovie1.getId()).thenReturn(1L);
        when(mockMovie1.getName()).thenReturn("Star wars");

        MovieInvertedIndex indexList = new MovieInvertedIndex();

        indexList.putMovie(mockMovie1);

        Assert.assertThat(indexList.size(), Matchers.equalTo(2));

    }
}
