package Router.b;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SimScreen extends JPanel{
	ArrayList<SimRouter> RouterList;
	ArrayList<RouterPos> RouterPos;
	ArrayList<NetPos> NetPos;
	public boolean IsDivide = false;
	
	public SimScreen(ArrayList<SimRouter> mList){
		this.RouterList = mList;
		Point Ra = new Point(54,226);
		Point Rb = new Point(242,321);
		Point Rc = new Point(599,312);
		Point Rd = new Point(407,260);
		Point Re = new Point(389,125);
		Point Rf = new Point(784,224);
		this.RouterPos = new ArrayList<RouterPos>();
		this.RouterPos.add(new RouterPos("A",Ra));
		this.RouterPos.add(new RouterPos("B",Rb));
		this.RouterPos.add(new RouterPos("C",Rc));
		this.RouterPos.add(new RouterPos("D",Rd));
		this.RouterPos.add(new RouterPos("E",Re));
		this.RouterPos.add(new RouterPos("F",Rf));
		Point N1 = new Point(207,142);
		Point N2 = new Point(255,242);
		Point N3 = new Point(108,313);
		Point N4 = new Point(415,341);
		Point N5 = new Point(591,149);
		Point N6 = new Point(695,279);
		this.NetPos = new ArrayList<NetPos>();
		this.NetPos.add(new NetPos("1",N1));
		this.NetPos.add(new NetPos("2",N2));
		this.NetPos.add(new NetPos("3",N3));
		this.NetPos.add(new NetPos("4",N4));
		this.NetPos.add(new NetPos("5",N5));
		this.NetPos.add(new NetPos("6",N6));
	}
	
	@Override
	public void paint(Graphics g){
		Font fsib30 = new Font(g.getFont().getFontName(), Font.BOLD, 14);
		g.setFont(fsib30);
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		drawLineNode(g,"A","1");
		drawLineNode(g,"A","2");
		drawLineNode(g,"A","3");
		drawLineNode(g,"1","E");
		drawLineNode(g,"E","5");
		drawLineNode(g,"2","D");
		drawLineNode(g,"3","B");
		drawLineNode(g,"D","5");
		drawLineNode(g,"B","4");
		drawLineNode(g,"4","C");
		drawLineNode(g,"C","6");
		drawLineNode(g,"6","F");
		drawLineNode(g,"5","F");
		g.setColor(Color.gray);
		for (int i = 0;i < this.NetPos.size();i ++){
			g.fillOval(this.NetPos.get(i).Pos.x - 10, this.NetPos.get(i).Pos.y - 10, 20, 20);
			g.drawString("Net" + this.NetPos.get(i).Name,this.NetPos.get(i).Pos.x + 20,this.NetPos.get(i).Pos.y + 20);
		}
		for (int i = 0;i < this.RouterPos.size();i ++){
			g.setColor(Color.blue);
			g.fillRect(this.RouterPos.get(i).Pos.x - 10, this.RouterPos.get(i).Pos.y - 10, 20, 20);
			g.setColor(Color.red);
			g.drawString("Router" + this.RouterPos.get(i).Name,this.RouterPos.get(i).Pos.x + 20,this.RouterPos.get(i).Pos.y);
			SimRouter TempR = this.Get(RouterPos.get(i).Name);
			for (int j = 0;j < TempR.mRouterTables.size();j ++){
				g.drawString(TempR.mRouterTables.get(j).getDesNetWorkAddr() + "   " + TempR.mRouterTables.get(j).getDistance() + "   " + TempR.mRouterTables.get(j).getNextRouterAddr(),
						this.RouterPos.get(i).Pos.x + 20, this.RouterPos.get(i).Pos.y + (j+1) * 20);
			}
		}
		if (IsDivide){
			//732.253
			int x = 732;
			int y = 253;
			int len = 40;
			g.setColor(Color.red);
			g.drawLine(x - len / 2,y , x + len / 2, y);
			g.drawLine(x,y - len / 2 , x, y + len / 2);
		}
	}
	
	private SimRouter Get(String RouterName){
		for (int i = 0;i < this.RouterList.size();i ++){
			SimRouter TempRouter = this.RouterList.get(i);
			if (TempRouter.getName().equals(RouterName)){
				return TempRouter;
			}
		}
		return null;
	}
	
	private void drawLineNode(Graphics g,String a,String b){
		Point pa,pb;
		if (a.charAt(0) >= '1' && a.charAt(0) <= '9'){
			pa = GetNPos(a);
		}
		else{
			pa = GetRPos(a);
		}
		if (b.charAt(0) >= '1' && b.charAt(0) <= '9'){
			pb = GetNPos(b);
		}
		else{
			pb = GetRPos(b);
		}
		g.drawLine(pa.x,pa.y,pb.x,pb.y);
	}
	
	private Point GetRPos(String name){
		for (int i = 0;i < this.RouterPos.size();i ++){
			if (this.RouterPos.get(i).Name.equals(name)){
				return this.RouterPos.get(i).Pos;
			}
		}
		return null;
	}
	
	private Point GetNPos(String name){
		for (int i = 0;i < this.NetPos.size();i ++){
			if (this.NetPos.get(i).Name.equals(name)){
				return this.NetPos.get(i).Pos;
			}
		}
		return null;
	}
}

class RouterPos{
	String Name;
	Point Pos;
	
	public RouterPos(String name,Point pos){
		this.Name = name;
		this.Pos = pos;
	}
}

class NetPos{
	String Name;
	Point Pos;
	
	public NetPos(String name,Point pos){
		this.Name = name;
		this.Pos = pos;
	}
}
