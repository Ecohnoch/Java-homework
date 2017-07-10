//2.  给定文本文件，文件名称为a.txt，文件内容为一个8行8列的字符矩阵，内容为1和0字符，
//    请编程计算出该矩阵中水平方向或者垂直方向或者斜线方向连续1最多的个数。
//    例如：
//    11001101
//    10110101
//    01010101
//    11001000
//    01010101
//    11001101
//    00011000
//    11110000

package a2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Counter {
	public static int[][] data = new int[8][8];
	static void read(String fileName) {
		try {
			String encoding = "UTF-8";
			File file = new File(fileName);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int row = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					for(int i = 0; i < 8; ++i){
						data[row][i] = Integer.valueOf(lineTxt.charAt(i)) - 48;
					}
//					System.out.println(lineTxt);
					row = row + 1;
				}
				read.close();
			} else {
				System.out.println("*** Can't find this file");
			}
		} catch (Exception e) {
			System.out.println("*** Error, when read this file");
			e.printStackTrace();
		}
	}
	
	static int[][] h = new int[8][8];
	static int[][] v = new int[8][8];
	static int[][] t = new int[8][8];

	static int bfs(int x, int y){
		if((x < 0) || (y < 0) || (x > 7) || (y > 7)) return 0;
		
		if(data[x][y] == 0){
			h[x][y] = 0;
			v[x][y] = 0;
			t[x][y] = 0;
			return 0;
		}
		
		if(x == 0){
			h[x][y] = 1;
		}else{
			h[x][y] = 1 + h[x - 1][y];
		}
		
		if(y == 0){
			v[x][y] = 1;
		}else{
			v[x][y] = 1 + v[x][y - 1];
		}
		
		if(x == 0 && y == 0){
			t[x][y] = 1;
		}else if(x == 0 && y != 0){
			t[x][y] = 1;
		}else if(x != 0 && y == 0){
			t[x][y] = 1;
		}else{
			t[x][y] = 1 + t[x - 1][y - 1];
		}
		
		return Math.max(h[x][y], Math.max(v[x][y], t[x][y]));
	}
	

	public static void main(String[] args) {
		read("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/a.txt");
		int ans = 0;
		for(int i = 0; i < 8; ++i){
			for(int j = 0; j < 8; ++j){
				ans = Math.max(ans, bfs(i, j));
			}
		}
		System.out.println(ans);
	}

}
