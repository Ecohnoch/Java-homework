//3.  编写程序求出1万以内的所有素数，并将这些素数输出到一个文本文件中，每行文本只包含一个素数数据。
//    该文本文件内容要求可以用记事本程序来查看。


package a2;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Prime {
	static boolean isPrime(int x){
		if(x == 2) return true;
		if(x == 1) return false;
		if(x % 2 == 0) return false;
		for(int j = 3; j <= Math.sqrt(x); j = j + 2)
			if(x % j == 0)
				return false;
		return true;
	}
	
	static void writeLine(int x){
		try {
			FileWriter fw = new FileWriter("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/output.txt", true);
	        PrintWriter pw = new PrintWriter(fw);    
	        pw.println(x);
	        System.out.println(x);
	        pw.close();
		} catch (Exception e) {
			System.out.println("*** Error, when read this file");
			e.printStackTrace();
		}
	}
	
	public static int start;
	public static int[] getAllPrime(){
		int[] ans = new int[100000];
		File f = new File("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/output.txt");
		f.delete();
		start = 0;
		for(int i = 1; i < 10001; ++i)
			if(isPrime(i)){
				ans[start] = i;
				start = start + 1;
			}
		return ans;
	}
	
	public static void main(String[] args) {
		File f = new File("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/output.txt");
		f.delete();
		int ans = 0;
		for(int i = 1; i < 10001; ++i)
			if(isPrime(i)){
				writeLine(i);
				ans = ans + 1;
			}
		System.out.println(ans);
	}
}
