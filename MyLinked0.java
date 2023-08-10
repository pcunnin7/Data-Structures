package algs13;
import java.text.DecimalFormat;
import stdlib.*;

/* 
 * Complete the methods below.
 * See the tests in main for examples of what each function should do.
 * 
 * deleteFirst should modify the list.
 * None of the other methods should modify the list.
 * 
 * You may not add any fields to the node or list classes.
 * You may not add any methods to the node class.
 * You may not create any new node objects or other objects.
 * For example, you cannot create a new Stack or ArrayList.
 * 
 * Each function must be independent: you cannot call one solution function from the other.  
 * You MAY add private methods to the list class 
 * (helper functions for recursion, if you chose to use it).
 */
public class MyLinked0 {
	static class Node {
		public Node (double item, Node next) { this.item = item; this.next = next; }
		public double item;
		public Node next;
	}
	Node first;

	// write a function to compute the size of the list
	public int size () {
		Node x = this.first;
		int result = 0;
		while (x != null) {result++;
		x = x.next;
			}
		return result; //TODO
	}

	// write a function to compute the sum of the positive elements of the list
	public double sumPositiveElements () {
		Node x = this.first;
		double result = 0;
		while (x != null) {
			if(x.item > 0){result = result + x.item;}
		x = x.next;
			}
		return result; //TODO
	}

	// delete the first element from this list, if it exists
	// do nothing if the list is empty
	public void deleteFirst () {
		Node x = this.first;
		if(x == null) {return;}
		this.first = this.first.next;
		return; //TODO
	}
	
	// return the length of the common prefix for this and that
	public int lengthOfCommonPrefix (MyLinked0 that) {
		Node x = this.first;
		Node y = that.first;
		double result = 0;
		while (x != null ) {
			if (y == null) {return (int)result;}
			if(x.item == y.item){result++;}
			if(x.item != y.item) {return (int)result;}
		x = x.next;
		y=y.next;
			}
		return (int)result; 
	}
	
	// return true if the even indexed elements are strictly increasing
	public boolean evenIndicesIncreasing () {
		Node x = this.first;
		if(x == null) {return true;}
		if(x.next == null) {return true;}
		while (x.next.next != null) {
			Node y = x.next.next;
			if(x.item >= y.item){return false;}
			if(y.next == null) {return true;}
			if(y.next.next == null) {return true;}
		x = x.next.next;
			}
		return true; //TODO
	}
	
	
	

	public static void main (String args[]) {
		//mainDebug ();
		mainRunTests ();
	}
	private static void mainDebug () {
		// Use this for debugging!
		// Uncomment the call in main to use this.
		// Add the names of helper functions if you use them.
		Trace.drawStepsOfMethod ("size");
		Trace.drawStepsOfMethod ("sumPositiveElements");
		Trace.drawStepsOfMethod ("deleteFirst");
		Trace.drawStepsOfMethod ("evenIndicesIncreasing");
		Trace.drawStepsOfMethod ("lengthOfCommonPrefix");
		Trace.run (); 
		// TODO:  Put the test here you want to debug:
		testSize (4, "11 -21.2 31 41");
	}
	private static void mainRunTests () {
		testSize (2, "11 21");	
		testSize (4, "11 -21.2 31 41");
		testSize (1, "11");
		testSize (0, "");	
		
		testSumPositiveElements (104, "11 -3 -4 21 31 41 -1");
		testSumPositiveElements (104, "11 -3 -4 21 31 -1 41");
		testSumPositiveElements (0, "-11.2");
		testSumPositiveElements (52, "11 -21 -31 41");
		testSumPositiveElements (0, "");
		testSumPositiveElements (11, "11");
		
		testDeleteFirst ("21 31", "11 21 31");	
		testDeleteFirst ("21 11", "31 21 11");
		testDeleteFirst ("21", "11 21");	
		testDeleteFirst ("", "11");
		testDeleteFirst ("", "");
		
		testLengthOfCommonPrefix (3, "11 21 31 41 5", "11 21 31 5 41");
		testLengthOfCommonPrefix (3, "11 21 31 5 41", "11 21 31 41 5");
		testLengthOfCommonPrefix (2, "11 21 31 41 5", "11 21 5 31 41");
		testLengthOfCommonPrefix (2, "11 21 5 31 41", "11 21 31 41 5");
		testLengthOfCommonPrefix (1, "11 21 31 41 5", "11 5 21 31 41");
		testLengthOfCommonPrefix (1, "11 5 21 31 41", "11 21 31 41");
		testLengthOfCommonPrefix (0, "11 21 31 41", "5 11 21 31 41");
		testLengthOfCommonPrefix (0, "5 11 21 31 41", "11 21 31 41");
		testLengthOfCommonPrefix (3, "11 21 31 41", "11 21 31 5 41");
		testLengthOfCommonPrefix (3, "11 21 31", "11 21 31 41");
		testLengthOfCommonPrefix (2, "11 21 31 41", "11 21");
		testLengthOfCommonPrefix (1, "11", "11 21 31 41");
		testLengthOfCommonPrefix (0, "11 21 31 41", "");
		testLengthOfCommonPrefix (0, "", "11 21 31 41");
		testLengthOfCommonPrefix (0, "", "");

		testEvenIndicesIncreasing(true,  "11 0 21 0 31 0 41");
		testEvenIndicesIncreasing(false, "11 0 21 0 5 0 31 0 41");
		testEvenIndicesIncreasing(false, "11 0 21 0 21 0 31 0 41");
		testEvenIndicesIncreasing(true,  "11 -1 21 -2 31 -3");
		testEvenIndicesIncreasing(false, "11 -1 21 -2 31 -3 5");
		testEvenIndicesIncreasing(true,  "11 -1 21 -2 31");
		testEvenIndicesIncreasing(false, "11 -1 21 -2 5 -3");
		testEvenIndicesIncreasing(true,  "11 -1 21 -2");
		testEvenIndicesIncreasing(true,  "11 -1 21");
		testEvenIndicesIncreasing(true,  "11 -1");
		testEvenIndicesIncreasing(true,  "11");
		testEvenIndicesIncreasing(true,  "");

		StdOut.println ("Finished tests");
	}
	

	/* ToString method to print */
	public String toString () { 
		// Use DecimalFormat #.### rather than String.format 0.3f to leave off trailing zeroes
		DecimalFormat format = new DecimalFormat ("#.###");
		StringBuilder result = new StringBuilder ("[ ");
		for (Node x = first; x != null; x = x.next) {
			result.append (format.format (x.item));
			result.append (" ");
		}
		result.append ("]");
		return result.toString ();
	}

	/* Method to create lists */
	public static MyLinked0 of(String s) {
		var result = new MyLinked0 ();
		if ("".equals (s)) return result;
		
		Node first = null;
		String[] nums = s.split (" ");
		for (int i = nums.length-1; i >= 0; i--) {
			try { 
				double num = Double.parseDouble (nums[i]); 
				first = new Node (num, first);      
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException (String.format ("Bad argument \"%s\": could not parse \"%s\" as a double", s, nums[i]));
			}
		}
		result.first = first;
		return result;
	}

	// lots of copy and paste in these test!
	private static void testSize (int expected, String sList) {
		var list = MyLinked0.of (sList);
		String sStart = list.toString ();
		int actual = list.size();
		if (expected != actual) {
			StdOut.format ("Failed %s.size(): Expecting (%d) Actual (%d)\n", sStart, expected, actual);
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.size(): List changed to %s\n", sStart, sEnd);
		}
	}	
	private static void testSumPositiveElements (double expected, String sList) {
		var list = MyLinked0.of (sList);
		String sStart = list.toString ();
		double actual = list.sumPositiveElements ();
		if (expected != actual) {
			StdOut.format ("Failed %s.sumPositiveElements(): Expecting (%f) Actual (%f)\n", sStart, expected, actual);
		}
		String sEnd = list.toString ();
		if (!sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sumPositiveElements(): List changed to %s\n", sStart, sEnd);
		}
	}
	private static void testDeleteFirst (String expected, String sList) {
		String sExpected = MyLinked0.of (expected).toString ();
		var list = MyLinked0.of (sList);
		String sStart = list.toString ();
		list.deleteFirst ();
		String sEnd = list.toString ();
		if (! sExpected.equals (sEnd)) {
			StdOut.format ("Failed %s.deleteFirst(): Expecting %s Actual %s\n", sStart, sExpected, sEnd);
		}
	}	
	private static void testEvenIndicesIncreasing(boolean expected, String sList) {
		var list = MyLinked0.of (sList);
		String sStart = list.toString ();
		boolean actual = list.evenIndicesIncreasing ();
		if (expected != actual) {
			StdOut.format ("Failed %s.evenIndicesIncreasing(): Expecting (%b) Actual (%b)\n", sStart, expected, actual);
		}
		String sEnd = list.toString ();
		if (!sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.evenIndicesIncreasing(): List changed to %s\n", sStart, sEnd);
		}
	}
	private static void testLengthOfCommonPrefix(int expected, String sList1, String sList2) {
		var list1 = MyLinked0.of (sList1);
		var list2 = MyLinked0.of (sList2);
		String sStart1 = list1.toString ();
		String sStart2 = list2.toString ();
		int actual = list1.lengthOfCommonPrefix(list2);
		if (expected != actual) {
			StdOut.format ("Failed %s.lengthOfCommonPrefix(%s): Expecting (%d) Actual (%d)\n", sStart1, sStart2, expected, actual);
		}
		String sEnd1 = list1.toString ();
		if (!sStart1.equals (sEnd1)) {
			StdOut.format ("Failed %s.lengthOfCommonPrefix(%s): List changed to %s\n", sStart1, sStart2, sEnd1);
		}
		String sEnd2 = list2.toString ();
		if (!sStart2.equals (sEnd2)) {
			StdOut.format ("Failed %s.lengthOfCommonPrefix(%s): List changed to %s\n", sStart1, sStart2, sEnd2);
		}
	}
}