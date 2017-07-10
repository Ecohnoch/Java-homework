//6.  通过命令行参数输入一个文件夹的路径名称，然后编写程序找出该文件夹下文件名称重复并且文件大小也一样的文件，
//    如果没有“重复文件”，则输出“没有重复文件”的提示，如果有，需要输出文件名称，和文件所在的文件夹路径（绝对路径）。
//	提示，需要遍历该文件夹下所有子文件夹，设计一个文件类，属性包括文件名称，文件路径，文件大小，然后进行“重复”
//	判断，如果文件重复，则需要记录并输出，有可能有文件名重复，但是文件大小不一样，重复的文件可能不止2个，可能
//	在不同的子文件夹下有多个文件重复。

package a2;

import java.io.File;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class MyFile {
	public static Map<String, File> fileMap = new HashMap<String, File>();
	public static void traverseFolder1(String path) {
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
                    list.add(file2);
                } else {
                	if(fileMap.containsKey(getRealName(file2.getName()))){
                		System.out.println("Repeat:");
                		System.out.println(file2.getName()+" "+file2.getPath()+" "+String.valueOf(file2.length()));
                		System.out.println(fileMap.get(getRealName(file2.getName())).getName() + " "+file2.getPath()+" "+String.valueOf(fileMap.get(getRealName(file2.getName())).length()));
                	}else
                		fileMap.put(getRealName(file2.getName()), file2);
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        list.add(file2);
                    } else {
                    	if(fileMap.containsKey(getRealName(file2.getName()))){
                    		System.out.println("Repeat:");
                    		System.out.println(file2.getName()+" "+file2.getPath()+" "+String.valueOf(file2.length()));
                    		System.out.println(fileMap.get(getRealName(file2.getName())).getName() + " "+file2.getPath()+" "+String.valueOf(fileMap.get(getRealName(file2.getName())).length()));
                    	}else
                    		fileMap.put(getRealName(file2.getName()), file2);
                    }
                }
            }
        } else {
            System.out.println("*** Can't find this folder!");
        }
    }
	
	static String getRealName(String name){
		return name.substring(0, name.lastIndexOf('.'));
	}
	public static void main(String[] args) {
		traverseFolder1("/Users/ecohnoch/Desktop/SmallTerm-homeWork-master/a2/src/a2");
	}
	
}
