package com.wongnai.interview.movie;

import com.wongnai.interview.constants.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class MovieInvertedIndex extends HashMap<String, Set<Long>> {

    public List<Long> findByQueryText(String queryText) {

        List<String> nameList = Arrays.asList(queryText.split(Constants.DEFAULT_SEPARATOR));

        if(nameList.stream().anyMatch(name -> !this.containsKey(name.toLowerCase()))) {
            return Collections.EMPTY_LIST;
        }

        Set<Long> resultIds = nameList.stream()
                .map(name -> this.get(name.toLowerCase()))
                .reduce((a, b) -> a.stream().filter(b::contains).collect(Collectors.toSet()))
                .get();

        return new ArrayList(resultIds);
    }

    public void putMovie(Movie movie) {
        String[] names = movie.getName().split(Constants.DEFAULT_SEPARATOR);

        for(String name : names) {

            if(this.containsKey(name.toLowerCase())) {
                this.get(name.toLowerCase()).add(movie.getId());
                continue;
            }

            Set<Long> ids = new HashSet<>();
            ids.add(movie.getId());

            this.put(name.toLowerCase(), ids);
        }
    }
}
