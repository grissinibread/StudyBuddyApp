package com.studybuddy.services;

import com.studybuddy.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchIterator {
    private final List<Match> matches = new ArrayList<>();
    private int index = 0;

    public MatchIterator(List<Match> matches) {
        this.matches.addAll(matches);
    }

    public List<Match> getNextGroup(int batchSize) {
        List<Match> batch = new ArrayList<>();
        for (int i = 0; i < batchSize; i++) {
            if (index >= matches.size()) {   // no more matches
                batch.add(null);
            } else {
                batch.add(matches.get(index));
                index++;
            }
        }
        // start again
        if (index >= matches.size()) {
            index = 0;
        }
        return batch;
    }

}
