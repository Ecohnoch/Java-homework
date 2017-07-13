package fileclient;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.security.Key;  
import java.security.SecureRandom;  
  
import javax.crypto.Cipher;  
import javax.crypto.CipherInputStream;  
import javax.crypto.CipherOutputStream;  
import javax.crypto.KeyGenerator; 
//���ܹ���
public class Encrypt {
	Key key;   
	  public Encrypt(String str) {   
	    getKey(str);//�����ܳ�   
	  }   
	  /**  
	  * ���ݲ�������KEY  
	  */   
	  public void getKey(String strKey) {   
	    try {   
	        KeyGenerator _generator = KeyGenerator.getInstance("DES");   
	        _generator.init(new SecureRandom(strKey.getBytes()));   
	        this.key = _generator.generateKey();   
	        _generator = null;   
	    } catch (Exception e) {   
	        throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);   
	    }   
	  }   
	  
	  /**  
	  * �ļ�file���м��ܲ�����Ŀ���ļ�destFile��  
	  *  
	  * @param file   Ҫ���ܵ��ļ� ��/Users/yuqiao/Desktop/Դ�ļ�.txt  
	  * @param destFile ���ܺ��ŵ��ļ��� ��/Users/yuqiao/Desktop/���ܺ��ļ�.txt  
	  */   
	  public void encrypt(String file, String destFile) throws Exception {   
	    Cipher cipher = Cipher.getInstance("DES");   
	    // cipher.init(Cipher.ENCRYPT_MODE, getKey());   
	    cipher.init(Cipher.ENCRYPT_MODE, this.key);   
	    InputStream is = new FileInputStream(file);   
	    OutputStream out = new FileOutputStream(destFile);   
	    CipherInputStream cis = new CipherInputStream(is, cipher);   
	    byte[] buffer = new byte[1024];   
	    int r;   
	    while ((r = cis.read(buffer)) > 0) {   
	        out.write(buffer, 0, r);   
	    }   
	    cis.close();   
	    is.close();   
	    out.close();   
	  }   
	  /**  
	  * �ļ�����DES�㷨�����ļ�  
	  *  
	  * @param file �Ѽ��ܵ��ļ� ��/Users/yuqiao/Desktop/���ܺ��ļ�.txt
	  *         * @param destFile  
	  *         ���ܺ��ŵ��ļ��� ��/Users/yuqiao/Desktop/���ܺ��ļ�.txt
	  */   
	  public void decrypt(String file, String dest) throws Exception {   
	    Cipher cipher = Cipher.getInstance("DES");   
	    cipher.init(Cipher.DECRYPT_MODE, this.key);   
	    InputStream is = new FileInputStream(file);   
	    OutputStream out = new FileOutputStream(dest);   
	    CipherOutputStream cos = new CipherOutputStream(out, cipher);   
	    byte[] buffer = new byte[1024];   
	    int r;   
	    while ((r = is.read(buffer)) >= 0) {   
	        System.out.println();  
	        cos.write(buffer, 0, r);   
	    }   
	    cos.close();   
	    out.close();   
	    is.close();   
	  }   
	  public static void main(String [] args) throws Exception{
		  Encrypt f = new Encrypt("/Users/yuqiao/Desktop/words.txt");

		  f.encrypt("/Users/yuqiao/Desktop/words.txt" ,"/Users/yuqiao/Desktop/words1.txt");
		  f.decrypt("/Users/yuqiao/Desktop/words1.txt" ,"/Users/yuqiao/Desktop/words3.txt");
		  
		  
	  }
	  
}
