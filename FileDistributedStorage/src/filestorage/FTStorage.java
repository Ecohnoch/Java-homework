package filestorage;

import java.io.IOException;
import java.util.Properties;

import fileserver.FTServer;

public class FTStorage {
	private String server;
	private String ip;
	private int port;
	private String root_folder;
	private double spareVolume,realVolume;
	private boolean ifUse;
	public FTStorage(int id) throws IOException
	{
		String idStr=id+"";
		String storageName="storage"+idStr;
		Properties p = new Properties();
		p.load(FTServer.class.getClassLoader().getResourceAsStream(storageName));
		this.server=p.getProperty("server");
		this.ip=p.getProperty("ip");
		this.port=Integer.parseInt(p.getProperty("port"));
		this.root_folder=p.getProperty("root");
		this.realVolume=Integer.parseInt((p.getProperty("volume")).substring(1));
		this.spareVolume=this.realVolume;
		this.ifUse=true;
	}
	public String getServer()
	{
		return server;
	}
	public void setServer(String s)
	{
		server=s;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String i)
	{
		ip=i;
	}
	public int getPort()
	{
		return port;
	}
	public void setPort(int p)
	{
		port=p;
	}
	public double getRealVolume()
	{
		return realVolume;
	}
	public boolean getIfUse()

	{
		return ifUse;
	}
	public void setIfuse(boolean i)
	{
		ifUse=i;
	}
	

}

