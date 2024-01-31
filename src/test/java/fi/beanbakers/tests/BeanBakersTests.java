package fi.beanbakers.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Some examples and asserts on some basic programming problems.
 * 
 * @author Peter
 */
public class BeanBakersTests {

	@Test
	public void testReverseList() {
		List<String> input = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
		List<String> expectedResult = Arrays.asList("g", "f", "e", "d", "c", "b", "a");

		List<String> result = doReverseList(input);
		Assert.assertArrayEquals(expectedResult.toArray(new String[expectedResult.size()]),
				result.toArray(new String[result.size()]));
	}

	/**
	 * Write your method here that returns the provided input list reversed.
	 * 
	 * @param input list
	 * @return provided list reversed
	 */
	private <T> List<T> doReverseList(List<T> input) {
		// Swaps the first and last elements and does this to half of the list to reverse it
		for (int i = 0; i<input.size()/2; i++) {
			T elem1 = input.get(i);
			T elem2 = input.get(input.size()-1-i);
			
			input.set(i, elem2);
			input.set(input.size()-1-i, elem1);
		}
		
		return input;
	}

	@Test
	public void testFibonacciSequence() {
		int sequenceLength = 8;
		int[] expectedResult = { 1, 1, 2, 3, 5, 8, 13, 21 };
		int[] result = doFibonacciSequence(sequenceLength);
		Assert.assertArrayEquals(expectedResult, result);
	}

	/**
	 * Write your method here that returns the fibonacci sequence up to the provided
	 * sequence length.
	 * 
	 * @param sequenceLength the amount of fibonacci sequence items to calculate
	 * @return int array containing the calculated fibonacci sequence
	 */
	private int[] doFibonacciSequence(int sequenceLength) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		
		int[] fibonacci = new int[sequenceLength];
		
		for (int i = 0; i<sequenceLength; i++) {
			fibonacci[i] = num1;
			
			num3 = num1 + num2;
			
			num1 = num2;
			num2 = num3;
		}
		
		return fibonacci;
	}

	@Test
	public void testAscendingAndDescendingSeries() {
		List<Integer> testSeriesA = Arrays.asList(1, 2, 5, 8, 15, 27, 31, 50);
		List<Integer> testSeriesB = Arrays.asList(1, 2, 1, 8, 7, 27, 31, 50);

		Assert.assertTrue(isAscendingSeries(testSeriesA));
		Assert.assertFalse(isAscendingSeries(testSeriesB));
		Assert.assertTrue(isDescendingSeries(doReverseList(testSeriesA)));
		Assert.assertFalse(isDescendingSeries(doReverseList(testSeriesB)));
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * ascending, false otherwise.
	 * 
	 * @param series
	 * @return true if provided series ascends, false otherwise.
	 */
	private boolean isAscendingSeries(List<Integer> series) {
		// Goes through the list and checks if the elements next to each other is in right order
		// If not return false
		for (int i = 1; i<series.size(); i++) {
			if (series.get(i) < series.get(i-1)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Write your method here that returns true if the provided list of integers is
	 * descending, false otherwise.
	 * 
	 * @param series
	 * @return true if the provided series descends, false otherwise.
	 */
	private boolean isDescendingSeries(List<Integer> series) {
		// Goes through the list and checks if the elements next to each other is in right order
		// If not return false
		for (int i = 1; i<series.size(); i++) {
			if (series.get(i) > series.get(i-1)) {
				return false;
			}
		}
		
		return true;
	}
}
