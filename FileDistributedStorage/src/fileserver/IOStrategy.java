package fileserver;
import java.net.*;
/*
	�ṩЭ����Զ���
*/
public interface IOStrategy
{
	public void service(Socket socket);
}
