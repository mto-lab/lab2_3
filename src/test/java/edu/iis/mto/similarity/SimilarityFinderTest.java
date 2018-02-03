package edu.iis.mto.similarity;

import static org.junit.Assert.assertThat;

import java.util.Vector;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Test;

import dublers.SequenceSearcherDubler;

public class SimilarityFinderTest {

    private static boolean EXPECTED = true;
    private static double EPSILON = 0.00000001;

    @After
    public void resetStaticData() {
        SequenceSearcherDubler.methodCallCounter = 0;
        SequenceSearcherDubler.receivedElementVector.clear();
    }

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

         int[] fisrtSequence = {1, 2, 3};
         int[] secondSequence = {4, 5, 6};
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
    public void calculateJackardSimilarityTheSameSequenceSizesOneCommonElement() {

        int[] fisrtSequence = {1, 2, 3};
        int[] secondSequence = {3, 4, 5};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 0.2;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesAllElementsAreCommon() {

        int[] fisrtSequence = {1, 2, 3};
        int[] secondSequence = {1, 2, 3};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = 1.;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

    @Test
    public void calculateJackardSimilarityTheSameSequenceSizesHalfOfElementsAreCommon() {

        int[] fisrtSequence = {1, 2, 3, 4, 5, 6};
        int[] secondSequence = {4, 5, 6, 7, 8, 9};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        double expectedJackardSimilarity = .3333333333333333;
        double actualJackardSimilarity = objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence);
        double delta = Math.abs(actualJackardSimilarity - expectedJackardSimilarity);
        boolean actualOutput = delta < EPSILON;

        assertThat(EXPECTED, Matchers.equalTo(actualOutput));
    }

}