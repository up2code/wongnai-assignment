package com.wongnai.interview.movie.external;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieDataServiceImplTest {

    @Autowired
    MovieDataServiceImpl movieDataService;

    @Test
    public void shouldReturnMoviesResponse() {

        MoviesResponse moviesResponse = movieDataService.fetchAll();

        Assert.assertNotNull(moviesResponse);
        Assert.assertTrue(moviesResponse.size() > 0);
    }
}
