public class InsertionSort {

	public static void sort(int[] a) {
		if (a == null || a.length < 2) {
			return;
		}

		for (int i = 1; i < a.length; i++) {
			int p = i;
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					p = j;
					break;
				}
			}

			if (p == i) {
				continue;
			}

			int key = a[i];

			for (int j = i - 1; j >= p; j--) {

				a[j + 1] = a[j];
			}

			a[p] = key;

		}

	}

	public static void main(String[] args) {
		int[] a = { 1, 9, 8, -3, 5 };
		sort(a);
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				System.out.println(a[i]);
			} else {
				System.out.print(a[i] + ", ");
			}
		}

	}

}
