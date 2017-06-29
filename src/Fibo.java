public class Fibo {
	public static void main(String[] args) {
		Fibo f = new Fibo();
		
		long startTime = System.currentTimeMillis();
		System.out.println(f.fibo1(30));
		long endTime = System.currentTimeMillis();

		System.out.println((double)(endTime - startTime));

		
		System.out.println(f.fibo2(30));
		
		startTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis();
		System.out.println((double)(endTime - startTime));
	}

	public int fibo1(int n) { 
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		if (n >= 2)
			return fibo1(n - 1) + fibo1(n - 2);
		return -1;
	}

	public int fibo2(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		int ans = 2, tmp1 = 1, tmp2 = 1;
		for (int i = 2; i < n; ++i) {
			ans = (tmp1 + tmp2);
			tmp1 = tmp2;
			tmp2 = ans;
		}
		return ans;
	}
}
