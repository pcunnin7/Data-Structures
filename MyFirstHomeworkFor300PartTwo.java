package algs11;

import java.util.Arrays;
import stdlib.*;

/**
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may also edit the function "main" to test your code.
 *
 * You must not change the declaration of any method. This will be true of every
 * skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * 
 * <pre>
 *     public static double minValue (double[] list) {
 * </pre>
 * 
 * to something like
 * 
 * <pre>
 *     public static void minValue (double[] list) {
 * </pre>
 * 
 * or
 * 
 * <pre>
 *     public static double minValue (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes. You should not use any HashSets
 * or ArrayLists, or anything else! In addition, each of your functions should
 * go through the argument array at most once. The only exception to this
 * removeDuplicates, which is allowed to call numUnique and then go through the
 * array once after that.
 */
public class MyFirstHomeworkFor300PartTwo {

	/**
	 * allSame returns true if all of the elements in list have the same value.
	 * allSame returns false if any two elements in list have different values. The
	 * array may be empty and it may contain duplicate values.
	 *
	 * Your solution should contain at most one loop. You may not use recursion.
	 * Your solution must not call any other functions. Here are some examples
	 * (using "==" informally):
	 *
	 * <pre>
	 *     true  == allSame(new double[] { })
	 *     true  == allSame(new double[] { 11 })
	 *     true  == allSame(new double[] { 11, 11, 11, 11 })
	 *     false == allSame(new double[] { 11, 11, 11, 22 })
	 *     false == allSame(new double[] { 11, 11, 22, 11 })
	 *     true  == allSame(new double[] { 22, 22, 22, 22 })
	 * </pre>
	 */
	public static boolean allSame(double[] list) {
		boolean result = true;
		if (list.length == 0) {
			return result;
		}
		int i = 0;
		while (i < (list.length - 1)) {
			double x = list[i];
			double y = list[i+1];
			if (x != y) {result = false;}
			i += 1;
		}
	    return result;
	}

	/**
	 * numUnique returns the number of unique values in a sorted array of doubles.
	 * The array may be empty and it may contain duplicate values. Assume that the
	 * list array is sorted.
	 *
	 * Your solution should contain at most one loop. You may not use recursion.
	 * Your solution must not call any other functions. Here are some examples
	 * (using "==" informally):
	 *
	 * <pre>
	 *     0 == numUnique(new double[] { })
	 *     1 == numUnique(new double[] { 11 })
	 *     1 == numUnique(new double[] { 11, 11, 11, 11 })
	 *     8 == numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 })
	 *     8 == numUnique(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88 })
	 * </pre>
	 */
	public static int numUnique(double[] list) {
		if (list.length == 0) {
			return 0;
		}
		if (list.length == 1) {
			return 1;
		}
		int i = 0;
		int n = 1;
		while (i < (list.length - 1)) {
			double x = list[i];
			double y = list[i+1];
			if (x != y) {n += 1;}
			i += 1;
		}
	    return n;
	}

	/**
	 * removeDuplicates returns a new array containing the unique values in the
	 * sorted argument array, in the same order that they were found in the original
	 * array. There should not be any extra space in the array --- there should be
	 * exactly one space for each unique element (Hint: numUnique tells you how big
	 * the array should be).
	 * 
	 * Assume that the list array is sorted, as you did for numUnique.
	 *
	 * Your solution should contain at most one loop. You may not use recursion.
	 * Your solution must not call any other functions, except numUnique. Here are
	 * some examples (using "==" informally):
	 *
	 * <pre>
	 *   new double[] { }
	 *     == removeDuplicates(new double[] { })
	 *   new double[] { 11 }
	 *     == removeDuplicates(new double[] { 11 })
	 *     == removeDuplicates(new double[] { 11, 11, 11, 11 })
	 *   new double[] { 11, 22, 33, 44, 55, 66, 77, 88 }
	 *     == removeDuplicates(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 })
	 *     == removeDuplicates(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88 })
	 * </pre>
	 */
	
	public static double[] removeDuplicates(double[] list) {
		if (list.length == 0) {
			return list;
		}
		if (list.length == 1) {
			return list;
		}
		int resultLength = numUnique(list);
		double[] result = new double[resultLength];
		int i = 0;
		int n = 1;
		result[0] = list[0];
		while (i < (list.length - 1)) {
			double x = list[i];
			double y = list[i+1];
			if (x != y) {result[n] = y; n += 1;}
			i += 1;
		}
		return result;
	}

	/*
	 * A main function for debugging -- change the name to "main" to run it (and
	 * rename the existing main method to something else). Change the test as
	 * appropriate.
	 */
	public static void main2(String[] args) {
		Trace.drawStepsOfMethod("removeDuplicates");
		Trace.run();
		testRemoveDuplicates("11 21 31 41", "11 21 31 41");
		testRemoveDuplicates("11 21", "11 11 21");
	}

	/**
	 * A test program, using private helper functions. See below. To make typing
	 * tests a little easier, I've written a function to convert strings to arrays.
	 * See below.
	 */
	public static void main(String[] args) {
		testAllSame(true, "11 11 11 11");
		testAllSame(true, "5 5 5");
		testAllSame(false, "11 5 11 11");
		testAllSame(false, "11 11 5 11");
		testAllSame(false, "11 11 11 5");
		testAllSame(false, "5 11 11 11");
		testAllSame(false, "11 5 5 11 11");
		testAllSame(false, "11 11 5 5 11");
		testAllSame(false, "11 11 5 11 5");
		testAllSame(false, "5 5 11 11 11");
		testAllSame(false, "11 11 11 5 5");
		testAllSame(true, "11");
		testAllSame(true, "2");
		testAllSame(true, "");

		// for numUnique: array must be sorted
		testNumUnique(4, "11 21 21 21 31 41 41 41 41");
		testNumUnique(1, "11 11 11 11");
		testNumUnique(4, "11 21 31 41");
		testNumUnique(4, "11 11 11 21 31 31 31 31 41");
		testNumUnique(4, "11 11 21 21 21 31 31 41 41 41 41");
		testNumUnique(8, "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71 81 81");
		testNumUnique(8, "11 21 31 41 41 41 41 41 51 51 61 71 81");
		testNumUnique(7, "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71");
		testNumUnique(7, "11 21 31 41 41 41 41 41 51 51 61 71");
		testNumUnique(8, "-81 -81 -81 -81 -71 -61 -51 -51 -51 -51 -41 -41 -31 -21 -11 -11 -11");
		testNumUnique(3, "-11 -11 -11 0 0 11 11 11");
		testNumUnique(2, "0 11 11 11");
		testNumUnique(2, "-Infinity 11 11 11");
		testNumUnique(2, "11 11 11 Infinity");
		testNumUnique(1, "11 11");
		testNumUnique(1, "11");
		testNumUnique(0, "");

		// for removeDuplicates: array must be sorted
		testRemoveDuplicates("11", "11 11 11 11");
		testRemoveDuplicates("11 21", "11 11 21");
		testRemoveDuplicates("11 21 31 41", "11 21 31 41");
		testRemoveDuplicates("11 21 31 41", "11 11 11 21 31 31 31 31 41");
		testRemoveDuplicates("11 21 31 41", "11 21 21 21 31 41 41 41 41");
		testRemoveDuplicates("11 21 31 41", "11 11 21 21 21 31 31 41 41 41 41");
		testRemoveDuplicates("11 21 31 41 51 61 71 81", "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71 81 81");
		testRemoveDuplicates("11 21 31 41 51 61 71 81", "11 21 31 41 41 41 41 41 51 51 61 71 81");
		testRemoveDuplicates("11 21 31 41 51 61 71", "11 11 11 11 21 31 41 41 41 41 41 51 51 61 71");
		testRemoveDuplicates("11 21 31 41 51 61 71", "11 21 31 41 41 41 41 41 51 51 61 71");
		testRemoveDuplicates("-81 -71 -61 -51 -41 -31 -21 -11", "-81 -81 -81 -81 -71 -61 -51 -51 -51 -51 -41 -41 -31 -21 -11 -11 -11");
		testRemoveDuplicates("-11 0 11", "-11 -11 -11 0 0 11 11 11");
		testRemoveDuplicates("0 11", "0 11 11 11");
		testRemoveDuplicates("-Infinity 11", "-Infinity 11 11 11");
		testRemoveDuplicates("Infinity 11", "Infinity 11 11 11");
		testRemoveDuplicates("NaN 11", "NaN 11 11 11");
		testRemoveDuplicates("11", "11 11");
		testRemoveDuplicates("11", "11");
		testRemoveDuplicates("", "");
		StdOut.println("Finished tests");
	}

	private static void testAllSame(boolean expected, String list) {
		double[] aList = doublesFromString(list);
		boolean actual = allSame(aList);
		if (!Arrays.equals(aList, doublesFromString(list))) {
			StdOut.format("Failed allSame([%s]): Array modified\n", list);
		}
		if (expected != actual) {
			StdOut.format("Failed allSame([%s]): Expecting (%b) Actual (%b)\n", list, expected, actual);
		}
	}

	private static void testNumUnique(int expected, String list) {
		double[] aList = doublesFromString(list);
		int actual = numUnique(aList);
		if (!Arrays.equals(aList, doublesFromString(list))) {
			StdOut.format("Failed numUnique([%s]): Array modified\n", list);
		}
		if (expected != actual) {
			StdOut.format("Failed numUnique([%s]): Expecting (%d) Actual (%d)\n", list, expected, actual);
		}
	}

	private static void testRemoveDuplicates(String expected, String list) {
		double[] aList = doublesFromString(list);
		double[] actual = removeDuplicates(aList);
		if (!Arrays.equals(aList, doublesFromString(list))) {
			StdOut.format("Failed removeDuplicates([%s]): Array modified\n", list);
		}
		double[] aExpected = doublesFromString(expected);
		// != does not do what we want on arrays
		if (!Arrays.equals(aExpected, actual)) {
			StdOut.format("Failed removeDuplicates([%s]): Expecting (%s) Actual (%s)\n", list,
					Arrays.toString(aExpected), Arrays.toString(actual));
		}
	}

	/* A utility function to create an array of doubles from a string. */
	// The string should include a list of numbers, separated by single spaces.
	private static double[] doublesFromString(String s) {
		if ("".equals(s))
			return new double[0]; // empty array is a special case
		String[] nums = s.split(" ");
		double[] result = new double[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			try {
				result[i] = Double.parseDouble(nums[i]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(
						String.format("Bad argument \"%s\": could not parse \"%s\" as a double", s, nums[i]));
			}
		}
		return result;
	}
}