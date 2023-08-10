package algs15.perc;

 import stdlib.*;
 import algs15.*;

// Uncomment the import statements above.

// You can test this using InteractivePercolationVisualizer and PercolationVisualizer
// All methods should make at most a constant number of calls to a UF data structure.
// You can use more than one UF data structure.
// You can assume that N>1
public class Percolation {
	int N;
	boolean[] open;
	WeightedUF full;
	WeightedUF perc;
	// TODO: more fields to add here
	public Percolation(int N) {
		if (N < 2) throw new IllegalArgumentException();
		this.N = N;
		this.open = new boolean[N*N];
		this.full = new WeightedUF(N*N);
		this.perc = new WeightedUF(N*N);
		for (int m = 0; m < N; m++) {{full.union(0, m);};}
		for (int m = 0; m < N; m++) {perc.union(0, m);}
		for (int m = (N*N) - N+1; m < N*N; m++) {perc.union((N*N)-N+1, m);}
		// TODO: more to do here
	}
	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
			open[i*N+j] = true;
			if ((i-1)*N+j >=  0 && open[(i-1)*N+j] == true) {perc.union(i*N+j, (i-1)*N+j); full.union(i*N+j, (i-1)*N+j);}
			if ((i*N+j-1) > ((N*i -1)) && open[i*N+j-1] == true) {perc.union(i*N+j, i*N+j-1); full.union(i*N+j, i*N+j-1);}
			if (i*N+j+1 <= (N*(i+1) -1) && open[i*N+j+1] == true) {perc.union(i*N+j, i*N+j+1); full.union(i*N+j, i*N+j+1);}
			if ((i+1)*N+j <= ((N*N)-1) && open[(i+1)*N+j] == true) {perc.union(i*N+j, (i+1)*N+j); full.union(i*N+j, (i+1)*N+j);}
		
		// TODO: more to do here.
	}
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		return open[i*N+j];
	}
	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		if (i*N+j < N) {if (open[i*N+j] == true) {return true;}}
		if (i*N+j < N) {if (open[i*N+j] == false) {return false;}}
		if (full.connected(0, i*N+j) == true) {return true;}
		else {return false;}
	}
	// does the system percolate?
	public boolean percolates() {
		// TODO
		return perc.connected(0, (N*N)-1);
		
	}
}