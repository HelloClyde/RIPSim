package Router.a.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import Router.a.RouterInfoItem;

public class ServerDemo {
	
	public static void main(String[] args){
		Router routerB = new Router(7791,"B");
		ArrayList<RouterInfoItem> RouterBTable = new ArrayList<RouterInfoItem>();
		RouterBTable.add(new RouterInfoItem("N1",5, "A"));
		RouterBTable.add(new RouterInfoItem("N2", 3, "C"));
		RouterBTable.add(new RouterInfoItem("N6", 6, "F"));
		RouterBTable.add(new RouterInfoItem("N8", 4, "E"));
		routerB.Accept(RouterBTable, "");
		System.out.println("·��" + routerB.Name + "��ʼ·�ɱ�");
		routerB.ShowTable();
		routerB.startAccept();
		System.out.println("·��" + routerB.Name + "���պ��·�ɱ�");
		routerB.ShowTable();
	}
}
