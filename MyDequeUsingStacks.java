// Exercise 1.4.31
package algs14;
import stdlib.*;
import java.util.NoSuchElementException;
import algs13.ResizingArrayStack;

/*
Here is the kind of output I get before fixing the move method.

    4000     0.4   3.1
    8000     1.5   4.1
   16000     4.9   3.2
   32000    21.6   4.4

Here is the kind of output I get after fixing the move method.
You can see that it is much faster, but not very consistent.
This is due to garbage collection and other system effects.

    4000     0.0   0.7
    8000     0.0   1.2
   16000     0.0   2.2
   32000     0.0   0.2
   64000     0.0   1.5
  128000     0.0   5.7
  256000     0.1   5.3
  512000     0.2   2.1
 1024000     0.4   1.9
 2048000     0.7   2.0
 4096000     2.5   3.6

    4000     0.0   0.8
    8000     0.0   1.6
   16000     0.0   1.8
   32000     0.0   0.1
   64000     0.0   2.0
  128000     0.0   4.5
  256000     0.1   5.7
  512000     0.2   1.8
 1024000     0.3   1.8
 2048000     0.7   2.1
 4096000     3.7   5.1


    4000     0.0   0.7
    8000     0.0   2.0
   16000     0.0   1.9
   32000     0.0   0.2
   64000     0.0   1.7
  128000     0.0   4.4
  256000     0.0   1.6
  512000     0.1   2.3
 1024000     0.1   0.6
 2048000     0.1   2.0
 4096000     0.2   2.4
 */

public class MyDequeUsingStacks<T> {
	ResizingArrayStack<T> sl  = new ResizingArrayStack<>();
	ResizingArrayStack<T> sr  = new ResizingArrayStack<>();
	public boolean isEmpty ()      { return sl.isEmpty() && sr.isEmpty(); }
	public int size ()             { return sl.size() + sr.size(); }
	public void pushLeft (T item)  { sl.push (item); }
	public void pushRight (T item) { sr.push (item); }

	private void move (ResizingArrayStack<T> from, ResizingArrayStack<T> to) {
		if (!to.isEmpty ()) throw new IllegalArgumentException();
		if (from.isEmpty ()) throw new IllegalArgumentException();
		ResizingArrayStack<T> tmp = new ResizingArrayStack<>();
		int x = from.size() / 2;
		while (from.size () > x && from.size() > 1) {
			tmp.push (from.pop());
		}
		while (!from.isEmpty ()) {
			to.push (from.pop());
			
		}
		while (!tmp.isEmpty ()) {
			from.push (tmp.pop());
			
		}
		
		
		// TODO: 
		// Run the main method below.  
		// Note that the execution is correct (that's the first part of the test).
		// Note also that performance is terrible (that's the second part of the test).
		// In particular, for N pops, the running time increases proportionally to N^2.
		// So the amortized time for each pop is linear (proportional to N).
		// 
		// Your goal is to change this method so that overall performance of 
		// the main method improves, by altering the number of elements moved 
		// from "from" to "to".
		//
		// Your solution must continue to pass the correctness tests below.
		// It must also have amortized constant time per pop.
		// So for N pops, the running time should increase proportionally to N.
		//
		// You can use one temporary stack to help you:
		//   ResizingArrayStack<T> tmp = new ResizingArrayStack<>();
		// You may find it helpful to print the sizes while debugging:
		//   StdOut.println ("from: " + from.size () + " to: " + to.size ());
		// You can print out the content of the stacks by uncommenting the 
		// lines in popLeft and popRight, below.
	}

	public T popLeft () {
		if (isEmpty()) { throw new NoSuchElementException(); }
		if (sl.isEmpty ()) { 
			//StdOut.println("r2l before: " + sl + " : " + sr);
			move (sr, sl); 
			//StdOut.println("r2l after:  " + sl + " : " + sr);
		}
		return sl.pop ();
	}

	public T popRight () {
		if (isEmpty()) { throw new NoSuchElementException(); }
		if (sr.isEmpty ()) { 
			//StdOut.println("l2r before: " + sl + " : " + sr);
			move (sl, sr); 
			//StdOut.println("l2r after:  " + sl + " : " + sr);
		}
		return sr.pop ();
	}

	public String toString () {
		if (isEmpty ()) return "[ ]";

		ResizingArrayStack<T> srBackwards = new ResizingArrayStack<>();
		for (T item : sr)
			srBackwards.push (item);

		StringBuilder sb = new StringBuilder ("[ ");
		for (T item : sl) {
			sb.append (item);
			sb.append (" ");
		}
		for (T item : srBackwards) {
			sb.append (item);
			sb.append (" ");
		}

		sb.append ("]");
		return sb.toString ();
	}
	private void check (String expected) {
		if (expected != null) {
			if (!expected.equals (this.toString ())) throw new Error ("Expected \"" + expected + "\", got \"" + this + "\"");
		}
		//StdOut.println (this);
	}
	private void check (T iExpected, T iActual, String expected) {
		if (!iExpected.equals (iActual)) throw new Error ("Expected \"" + iExpected + "\", got \"" + iActual + "\"");
		check (expected);
	}
	private void check (T iExpected, T iActual) {
		if (!iExpected.equals (iActual)) throw new Error ("Expected \"" + iExpected + "\", got \"" + iActual + "\"");
	}
	private static void correctnessTest () {
		MyDequeUsingStacks<Integer> d1 = new MyDequeUsingStacks<> ();
		d1.pushLeft(0);
		d1.pushLeft(1);
		d1.pushLeft(2);
		d1.pushLeft(3);
		d1.check(0,d1.popRight());
		d1.check(3,d1.popLeft());
		d1.check(1,d1.popRight());
		d1.check(2,d1.popLeft());
		d1.pushRight(0);
		d1.pushRight(1);
		d1.pushRight(2);
		d1.pushRight(3);
		d1.check(0,d1.popLeft());
		d1.check(3,d1.popRight());
		d1.check(1,d1.popLeft());
		d1.check(2,d1.popRight());

		Integer k;

		if (!d1.isEmpty ()) throw new Error();
		d1.pushLeft (11);
		d1.check ("[ 11 ]");
		d1.pushLeft (12);
		d1.check ("[ 12 11 ]");
		k = d1.popLeft ();
		d1.check (12, k, "[ 11 ]");
		k = d1.popLeft ();
		d1.check (11, k, "[ ]");

		try {
			d1.popLeft ();
			throw new Error ("Expected exception");
		} catch (NoSuchElementException e) {}

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushLeft (i); }
		for (int i = 0; i < 20; i++) { d1.check (19-i, d1.popLeft ()); }

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushLeft (i); }
		for (int i = 0; i < 20; i++) { d1.check (i, d1.popRight ()); }

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushLeft (i); }
		for (int i = 0; i < 10; i++) { d1.check (i, d1.popRight ()); }
		for (int i = 0; i < 10; i++) { d1.check (19-i, d1.popLeft ()); }

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushLeft (i); }
		for (int i = 0; i < 10; i++) { d1.check (19-i, d1.popLeft ()); }
		for (int i = 0; i < 10; i++) { d1.check (i, d1.popRight ()); }

		if (!d1.isEmpty ()) throw new Error();
		d1.pushRight (11);
		d1.check ("[ 11 ]");
		d1.pushRight (12);
		d1.check ("[ 11 12 ]");
		k = d1.popRight ();
		d1.check (12, k, "[ 11 ]");
		k = d1.popRight ();
		d1.check (11, k, "[ ]");

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushRight (i); }
		for (int i = 0; i < 20; i++) { d1.check (19-i, d1.popRight ()); }

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushRight (i); }
		for (int i = 0; i < 20; i++) { d1.check (i, d1.popLeft ()); }

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushRight (i); }
		for (int i = 0; i < 10; i++) { d1.check (i, d1.popLeft ()); }
		for (int i = 0; i < 10; i++) { d1.check (19-i, d1.popRight ()); }

		if (!d1.isEmpty ()) throw new Error();
		for (int i = 0; i < 20; i++) { d1.pushRight (i); }
		for (int i = 0; i < 10; i++) { d1.check (19-i, d1.popRight ()); }
		for (int i = 0; i < 10; i++) { d1.check (i, d1.popLeft ()); }

		try {
			d1.popRight ();
			throw new Error ("Expected exception");
		} catch (NoSuchElementException e) {}
		
		StdOut.println("Finished correctness test.");
	}

	private static void performanceTest() {
		int MIN = 2000;
		int MAX = 4096000;		
		double prev = timeTrial(MIN);
		for (int N = MIN*2; N<=MAX; N += N) {
			double time = timeTrial(N);
			StdOut.format("%8d %9.3f %5.1f\n", N, time, time/prev);
			prev = time;
		}
	}
	private static double timeTrial(int N) {
		int NUM_TRIALS = 1;
		MyDequeUsingStacks<Integer> d1 = new MyDequeUsingStacks<> ();
		Stopwatch sw = new Stopwatch ();
		for (int trial=0; trial < NUM_TRIALS; trial++) {
			for (int i=0; i<2*N; i++) {
				d1.pushLeft (i);
			}
			for (int i=0; i<N; i++) {
				d1.popRight ();
				d1.popLeft ();
			}
		}
		return sw.elapsedTime ();
	}


	public static void main (String args[]) {
		//Trace.drawStepsOfMethod ("correctnessTest");
		//Trace.drawStepsOfMethod ("move");
		//Trace.run ();
		correctnessTest ();
		performanceTest ();
	}
}
