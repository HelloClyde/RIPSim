package Router.a.client;

import java.awt.geom.IllegalPathStateException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import Router.a.RouterInfoItem;
import Router.a.server.Router;

public class ClientDemo {
	public static void main(String[] args){
		Router routerC = new Router(7791, "C");
		ArrayList<RouterInfoItem> RouterCTable = new ArrayList<RouterInfoItem>();
		RouterCTable.add(new RouterInfoItem("N1", 5));
		RouterCTable.add(new RouterInfoItem("N2", 4));
		RouterCTable.add(new RouterInfoItem("N3", 8));
		RouterCTable.add(new RouterInfoItem("N6", 4));
		RouterCTable.add(new RouterInfoItem("N8", 3));
		routerC.Accept(RouterCTable, "");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入服务器IP：");
		String iPAddrString;
		while (true){
			String line = scanner.nextLine();
			if (line.matches("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))")){
				iPAddrString = line;
				break;
			}
			else{
				System.out.println("请输入正确的IPV4地址格式");
			}
		}
		routerC.Send(iPAddrString);
	}
}
