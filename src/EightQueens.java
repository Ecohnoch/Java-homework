public class EightQueens {
	public int[] a = { -1, -1, -1, -1, -1, -1, -1, -1 }; 
	public int ways = 0; 

	public boolean check(int row, int col) { 
		for (int i = 0; i < row; i++) {
			if (a[i] == col) { 
				return false;
			}
			if (row - i == Math.abs(col - a[i])) {
				return false;
			}
		}
		return true;
	}
	public void place(int n) {
		if (n == 8) { 
			ways++;
		} else {
			for(int i = 0; i < 8; ++i)
				if(check(n, i)){
					a[n] = i;
					place(n + 1);
				}
		}
	}

	public static void main(String[] args) {
		EightQueens eq = new EightQueens();
		eq.place(0);
		System.out.println(eq.ways);
	}

}
