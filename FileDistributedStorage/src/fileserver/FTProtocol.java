package fileserver;

import java.net.Socket;
import java.io.*;
import java.util.*;

public class FTProtocol implements IOStrategy {

	@Override
	public void service(Socket socket) {
		String client = socket.getInetAddress().getHostName() + "(" + socket.getInetAddress().getHostAddress() + ")";
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			String filename = null;
			long len = 0;
			byte[] buffer = new byte[4096];
			long r = 0;
			int rr = 0;
			while (true) {
				int command = dis.readInt();
				switch (command) {
				case 1: // file upload
					filename = dis.readUTF();
					len = dis.readLong();
					FileOutputStream fos = new FileOutputStream(new File(
							FTServer.share, filename));
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					r = 0;
					rr = 0;

					while (r < len) {
						if (len - r >= buffer.length) {
							rr = dis.read(buffer, 0, buffer.length);
						} else {
							rr = dis.read(buffer, 0, (int) (len - r));
						}

						r = r + rr;
						bos.write(buffer, 0, rr);
					}
					bos.close();
					fos.close();
					break;
				case 2: // file download
					filename = dis.readUTF();
					dos.writeUTF(filename);
					File t = new File(FTServer.share, filename);
					dos.writeLong(t.length());
					dos.flush();
					FileInputStream fis = new FileInputStream(t);
					BufferedInputStream bis = new BufferedInputStream(fis);

					while ((rr = bis.read(buffer)) != -1) {
						dos.write(buffer, 0, rr);
						dos.flush();
					}
					bis.close();
					fis.close();
					break;
				case 3: // list files
					String[] files = FTServer.share.list();
					List<String> list = new LinkedList<String>();
					for(int i=0;i<files.length;i++) {
						if(new File(FTServer.share, files[i]).isDirectory()) continue;
						list.add(files[i]);
					}
					files = list.toArray(new String[0]);
					dos.writeInt(files.length);
					dos.flush();
					for (int i = 0; i < files.length; i++) {
						dos.writeUTF(files[i]);
					}
					dos.flush();
					break;
				}
			}
		} catch (Exception e) {
			if (e instanceof EOFException) {
				System.out.println(client + " disconnected");
			} else {
				e.printStackTrace();
			}
		}
	}
}
