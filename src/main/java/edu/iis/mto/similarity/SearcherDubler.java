package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SearcherDubler implements SequenceSearcher {

    public static int numberOfCallsOfSearchMethod = 0;

    public SearchResult search(int key, int[] seq) {
        SearchResult.Builder builder =  SearchResult.builder();

        numberOfCallsOfSearchMethod++;

        for(int i = 0; i < seq.length; i++) {
            if(key == seq[i]) {
                builder.withFound(true);
                builder.withPosition(i);
            }
        }

        return builder.build();
    }

}
