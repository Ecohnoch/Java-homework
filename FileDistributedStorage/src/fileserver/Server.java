package fileserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import filestorage.FTStorage;;
public class Server {
	boolean WorkCondition;
	public Server() throws IOException
	{
		/*File file=new File("log.txt");
		if(!file.isFile())       //是否有配置文件，即是否为第一次启动
		{
			storage1=new FTStorage(1);
			storage2=new FTStorage(2);
			storage3=new FTStorage(3);
			storage4=new FTStorage(4);
			ArrayList<FTStorage> List = new ArrayList<FTStorage>(4);
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			List.add(storage1);List.add(storage2);
			List.add(storage3);List.add(storage4);
			for(int i=0;i< 4 ;i++)
			{
				bw.write(List.get(i).getServer());
				bw.newLine();
				bw.write(List.get(i).getIp());
				bw.newLine();
				bw.write(List.get(i).getPort());
				bw.newLine();
				bw.write((int) List.get(i).getRealVolume());
				bw.newLine();
				if(List.get(i).getIfUse())
				{
					bw.write("true");
					bw.newLine();
				}
				else
				{
					bw.write("false");
					bw.newLine();
				}
				bw.flush();
			}
		}
		else
		{
			//把log.txt中的配置写入
		}*/
	}
	//public FTStorage 
}
