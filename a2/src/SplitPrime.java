//4.  编写程序求出1万以内的所有素数，然后再判断这些素数中哪些是由素数拼接而成的。
//    例如素数23就符合条件，23本身是素数，其由素数2，和素数3拼接（连接）组成。
//    素数29就不满足条件，2是素数，而9不是素数。素数307不满足条件，不能忽略0. 
//	7907这个素数符合条件，7是素数，907是素数。
//需要把符合条件的拼接素数全部输出，并统计个数。

package a2;

public class SplitPrime {
	static int[] getAllPrime(){
		int[] a = Prime.getAllPrime();
		return a;
	}
	
	static boolean isSplitPrime(int num){
		int n1 = num / 10;
		int n2 = num % 10;
		int bit = 1;
		boolean flag = true;
		if(n1 == 0) return false;
		while(n1 != 0){
			
			if(Prime.isPrime(n1) && Prime.isPrime(n2) && flag)
				return true;
			if(Prime.isPrime(n1) && isSplitPrime(n2) && flag)
				return true;
			if(isSplitPrime(n1) && Prime.isPrime(n2) && flag)
				return true;
			if(isSplitPrime(n1) && isSplitPrime(n2) && flag)
				return true;
			
			n2 = (n1 % 10) * (int)Math.pow(10, bit) + n2;
			if(n1 % 10 == 0) flag = false;
			else flag = true;
			n1 = n1 / 10;
			bit = bit + 1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = getAllPrime();
		int ans = 0;
 		for(int i : a)
 			if(isSplitPrime(i)){
 				System.out.println(i);
 				ans = ans + 1;
 			}
 		System.out.println(ans);
	}

}
