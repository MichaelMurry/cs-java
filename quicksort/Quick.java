public class Quick {

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		while (true) {
			
			// find item on left to swap
			while (less(a[++i], a[lo]))
				if (i == hi) break;

			// find item on right to swap
			while (less(a[lo], a[--j]))
				if (j == lo) break;

			// check if pointers cross
			if (i >= j) break;

			// swap
			exch(a, i, j);
		}

		// swap with partitioning item
		exch(a, lo, j);
		return j;
	}

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0; 
    }

    private static void exch() {}
}