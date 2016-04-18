package Router.a.server;

import java.io.*;
import java.net.*;
import java.util.*;

import Router.a.*;

public class Router extends MainRouter{
	int RouterAcceptPort;
	String Name;
	
	public Router(int mPort,String mName){
		this.RouterAcceptPort = mPort;
		this.Name = mName;
	}
	
	public boolean startAccept(){
		try {
			ServerSocket serverSocket = new ServerSocket(this.RouterAcceptPort);
			System.out.println(this.Name + "·��������,��ʼ��������·����������·�ɱ�...");
			Socket client = serverSocket.accept();
			System.out.println("");
			ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
			NetInfomation TempObj = (NetInfomation)objectInputStream.readObject();
			ArrayList<RouterInfoItem> TempTables = TempObj.getRouterTables();
			//����·�ɱ�
			for (int i = 0;i < TempTables.size();i ++){
				TempTables.get(i).setNextRouterAddr(TempObj.getFromRouterNameString());
				TempTables.get(i).DistanceAdd();
			}
			objectInputStream.close();
			client.close();
			serverSocket.close();
			System.out.println("����·��" + TempObj.getFromRouterNameString() + "��·�ɱ�");
			ShowTable(TempTables);
			this.Accept(TempTables, "");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean Send(String IPAddr){
		try {
			Socket client = new Socket(IPAddr,this.RouterAcceptPort);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
			NetInfomation TempObj = new NetInfomation(this.mRouterTables, this.Name);
			objectOutputStream.writeObject(TempObj);
			objectOutputStream.close();
			client.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
