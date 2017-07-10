//5.  要求从控制台输入英语单词及单词解释两项数据，
//    把录入的数据追加到文件中。要求提供单词查询功能。
//    用户输入单词后，从单词库文件中查找，如果存在则输出
//    该单词的解释。注意，单词不能有重复，如果重复则覆盖替换
//以前的解释数据。

package a2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Dictionary {
	static String read(String fileName, String word) {
		try {
			String encoding = "UTF-8";
			File file = new File(fileName);
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int row = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					String[] p = lineTxt.split(" ");
					if(p[0].equals(word)) 
						return p[1];
//					System.out.println(lineTxt);
					row = row + 1;
				}
				read.close();
				return null;
			} else {
				System.out.println("*** Can't find this file");
				return null;
			}
		} catch (Exception e) {
			System.out.println("*** Error, when read this file");
			e.printStackTrace();
			return null;
		}
	}
	
	static void writeLine(String word){
		try {
			FileWriter fw = new FileWriter("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/Dictionary.txt", true);
	        PrintWriter pw = new PrintWriter(fw);  
	        pw.println(word);
	        pw.close();
		} catch (Exception e) {
			System.out.println("*** Error, when read this file");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {		
		if(read("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/Dictionary.txt", args[0]) != null){
			System.out.println(read("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/bin/a2/Dictionary.txt", args[0]));
		}else{
			writeLine(args[0] + " " + args[1]);
			System.out.println("Can't find this word, but we have append this to the dictionary!");
		}
	}
}
