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

    @Test
    public void calculateJackardSimilarityCallSizeMethodZeroTimes() {
        int[] fisrtSequence = {};
        int[] secondSequence = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int expectedOutput = 0;
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence); // in that case result is irrelevant

        assertThat(expectedOutput, Matchers.equalTo(SequenceSearcherDubler.methodCallCounter));
    }

    @Test
    public void calculateJackardSimilarityCallSizeMethodOneTime() {
        int[] fisrtSequence = {1};
        int[] secondSequence = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        SequenceSearcherDubler.searchResults.push(false);
        int expectedOutput = 1;
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence); // in that case result is irrelevant

        assertThat(expectedOutput, Matchers.equalTo(SequenceSearcherDubler.methodCallCounter));
    }

    @Test
    public void calculateJackardSimilarityCallSizeMethodManyTimes() {
        int[] fisrtSequence = {1, 2, 3, 4, 5, 6, 7};
        int[] secondSequence = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        int expectedOutput = 7;
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence); // in that case result is irrelevant

        assertThat(expectedOutput, Matchers.equalTo(SequenceSearcherDubler.methodCallCounter));
    }

    @Test
    public void calculateJackardSimilaritySearchReceivedZeroParameters() {
        int[] fisrtSequence = {};
        int[] secondSequence = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Vector<Integer> expectedParameters = new Vector<Integer>();
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence); // in that case result is irrelevant

        assertThat(EXPECTED,
                Matchers.equalTo(expectedParameters.containsAll(SequenceSearcherDubler.receivedElementVector)));
    }

    @Test
    public void calculateJackardSimilaritySearchReceivedOneParameter() {
        int[] fisrtSequence = {5};
        int[] secondSequence = {4, 5, 6, 7, 8, 9};
        SequenceSearcherDubler.searchResults.push(false);
        Vector<Integer> expectedParameters = new Vector<Integer>();
        expectedParameters.addElement(5);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence); // in that case result is irrelevant

        assertThat(EXPECTED,
                Matchers.equalTo(expectedParameters.containsAll(SequenceSearcherDubler.receivedElementVector)));
    }

    @Test
    public void calculateJackardSimilaritySearchReceivedManyParameters() {
        int[] fisrtSequence = {1, 2, 3, 4};
        int[] secondSequence = {4, 5, 6, 7, 8, 9};
        SequenceSearcherDubler.searchResults.push(true);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        SequenceSearcherDubler.searchResults.push(false);
        Vector<Integer> expectedParameters = new Vector<Integer>();
        expectedParameters.addElement(1);
        expectedParameters.addElement(2);
        expectedParameters.addElement(3);
        expectedParameters.addElement(4);
        SimilarityFinder objectUnderTest = new SimilarityFinder(new SequenceSearcherDubler());
        objectUnderTest.calculateJackardSimilarity(fisrtSequence, secondSequence); // in that case result is irrelevant

        assertThat(EXPECTED,
                Matchers.equalTo(expectedParameters.containsAll(SequenceSearcherDubler.receivedElementVector)));
    }

}