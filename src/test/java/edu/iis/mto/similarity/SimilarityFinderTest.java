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

        int[] fisrtSequence = {1};
        int[] secondSequence = {1};
        SequenceSearcherDubler.searchResults.push(true);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 1.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilaritySizeIsEqualToOneAndHaveNoCommonElements() {

        int[] fisrtSequence = {1};
        int[] secondSequence = {2};
        SequenceSearcherDubler.searchResults.push(false);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesNoCommonElements() {

        int[] fisrtSequence = {1, 2, 3};
        int[] secondSequence = {4, 5, 6, 7, 8, 9};
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
    public void calculateJackardSimilarityDifferentSequenceSizesOneCommonElement() {

        int[] fisrtSequence = {1, 2};
        int[] secondSequence = {2, 3, 4};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(false);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.25;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityDifferentSequenceSizesSomeElementsAreCommon() {

        int[] fisrtSequence = {1, 2, 3, 4, 5, 6};
        int[] secondSequence = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.25;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
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