package edu.iis.mto.similarity;

import org.junit.Test;

public class SimilarityFinderTest {

    @Test
    public void calculateJackardSimilarityBothSequencesAreEmpty() {
        
        int[] fisrtSequence = {};
        int[] secondSequence = {};
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 1.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilaritySecondSequencesIsEmpty() {

        int[] fisrtSequence = {1, 2, 3};
        int[] secondSequence = {};
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilaritySizeIsEqualToOneAndHaveOneCommonElement() {
        ;
    }

    @Test
    public void calculateJackardSimilaritySizeIsEqualToOneAndHaveNoCommonElements() {
        ;
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesNoCommonElements() {
        ;
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesOneCommonElement() {
        ;
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesAllElementsAreCommon() {
        ;
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesHalfOfElementsAreCommon() {
        ;
    }

    public void calculateJackardSimilarityTheSameSequenceSizesNoCommonElements() {
        ;
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesOneCommonElement() {
        ;
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesAllElementsAreCommon() {
        ;
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesHalfOfElementsAreCommon() {
        ;
    }

}