public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
	private Key[] pq;	// pq[i] = ith element on pq
	private int N;		// number of elements on pq

	public UnorderedMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Key x) {
		pq[N++] = x;
	}

	public Key delMax()
	{
		int max = 0;
		for (int i = 1; i < N; i++)
			if (less(max, i)) max = i;
		exch(max, N-1);
		return pq[--N];
	}

	// Is item v less than w
	private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0; 
    }

    // Swap item in array a[] at index i with the one at index j
    private static void exch (Comparable[] a, int i, int j) {
    	Comparable swap = a[i];
    	a[i] = a[j];
    	a[j] = swap;
    }

    //Test if any array is sorted
    private static boolean isSorted(Comparable[] a) {
    	for (int i = 1; i < a.length; i++)
    		if (less(a[i], a[i-1])) return false;
    	return true;
    }
}