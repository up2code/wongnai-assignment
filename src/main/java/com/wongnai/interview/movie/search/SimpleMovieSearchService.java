package com.wongnai.interview.movie.search;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wongnai.interview.movie.converter.MovieDataConverter;
import com.wongnai.interview.movie.external.MovieData;
import com.wongnai.interview.movie.external.MoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MovieDataService;
import org.springframework.util.StringUtils;

@Component("simpleMovieSearchService")
public class SimpleMovieSearchService implements MovieSearchService {
	@Autowired
	private MovieDataService movieDataService;

	@Override
	public List<Movie> search(String queryText) {
		//TODO: Step 2 => Implement this method by using data from MovieDataService
		// All test in SimpleMovieSearchServiceIntegrationTest must pass.
		// Please do not change @Component annotation on this class

		if(queryText.contains(" ")) {
			return Collections.emptyList();
		}

		MoviesResponse moviesResponse = movieDataService.fetchAll();

		Stream<MovieData> movieDataStream = moviesResponse.stream();

		if(!StringUtils.isEmpty(queryText)) {
			movieDataStream = movieDataStream.filter(m -> isMatched(m, queryText));
		}

		return movieDataStream.map(MovieDataConverter::toMovie)
				.collect(Collectors.toList());
	}

	private boolean isMatched(MovieData movieData, String queryText) {
		return Pattern.compile(".*\\b"+queryText+"\\b.*", Pattern.CASE_INSENSITIVE).matcher(movieData.getTitle()).matches();
	}
}
