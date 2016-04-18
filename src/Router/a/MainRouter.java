package Router.a;

import java.util.ArrayList;

public class MainRouter {
	public ArrayList<RouterInfoItem> mRouterTables;
	
	public MainRouter(){
		this.mRouterTables = new ArrayList<RouterInfoItem>();
	}
	
	public void Accept(ArrayList<RouterInfoItem> otherRouterTablesSrc,String otherRouterName){
		//copy
		ArrayList<RouterInfoItem> otherRouterTables = new ArrayList<RouterInfoItem>();
		for (int i = 0;i < otherRouterTablesSrc.size();i ++){
			otherRouterTables.add(new RouterInfoItem(otherRouterTablesSrc.get(i).getDesNetWorkAddr(), otherRouterTablesSrc.get(i).getDistance(), otherRouterTablesSrc.get(i).getNextRouterAddr()));
		}
		for (int i = 0;i < otherRouterTables.size();i ++){
			if (!otherRouterName.equals("")){
				otherRouterTables.get(i).setNextRouterAddr(otherRouterName);
				if (otherRouterTables.get(i).getDistance() < 16){
					otherRouterTables.get(i).DistanceAdd();
				}
			}
			RouterInfoItem tempRouterInfoItem = this.SearchNetWorkAddr(otherRouterTables.get(i));
			if (tempRouterInfoItem == null){
				this.mRouterTables.add(otherRouterTables.get(i));
			}
			else{
				if (tempRouterInfoItem.getNextRouterAddr().equals(
						otherRouterTables.get(i).getNextRouterAddr())){
					this.mRouterTables.remove(tempRouterInfoItem);
					this.mRouterTables.add(otherRouterTables.get(i));
				}
				else{
					if (tempRouterInfoItem.getDistance() > otherRouterTables.get(i).getDistance()){
						this.mRouterTables.remove(tempRouterInfoItem);
						this.mRouterTables.add(otherRouterTables.get(i));
					}
				}
			}
		}
	}
	
	public void ShowTable(){
		System.out.println("NetWorkAddr\tDistance\tNextAddr");
		for (int i = 0;i < this.mRouterTables.size();i ++){
			RouterInfoItem temp = this.mRouterTables.get(i);
			System.out.println(temp.getDesNetWorkAddr() + "\t" + temp.getDistance() + "\t" + temp.getNextRouterAddr());
		}
	}
	
	public void ShowTable(ArrayList<RouterInfoItem> mTables){
		System.out.println("NetWorkAddr\tDistance\tNextAddr");
		for (int i = 0;i < mTables.size();i ++){
			RouterInfoItem temp = mTables.get(i);
			System.out.println(temp.getDesNetWorkAddr() + "\t" + temp.getDistance() + "\t" + temp.getNextRouterAddr());
		}
	}
	
	public RouterInfoItem SearchNetWorkAddr(RouterInfoItem otherRouterInfoItem){
		for (int i = 0;i < this.mRouterTables.size();i ++){
			if (this.mRouterTables.get(i).getDesNetWorkAddr().equals(
					otherRouterInfoItem.getDesNetWorkAddr())){
				return this.mRouterTables.get(i);
			}
		}
		return null;
	}
	
	static public void main(String[] args){
		MainRouter RouterB = new MainRouter();
		ArrayList<RouterInfoItem> RouterBTable = new ArrayList<RouterInfoItem>();
		RouterBTable.add(new RouterInfoItem("N1",5, "A"));
		RouterBTable.add(new RouterInfoItem("N2", 3, "C"));
		RouterBTable.add(new RouterInfoItem("N6", 6, "F"));
		RouterBTable.add(new RouterInfoItem("N8", 4, "E"));
		RouterB.Accept(RouterBTable, "");
		RouterB.ShowTable();
		ArrayList<RouterInfoItem> RouterCTable = new ArrayList<RouterInfoItem>();
		RouterCTable.add(new RouterInfoItem("N1", 5));
		RouterCTable.add(new RouterInfoItem("N2", 4));
		RouterCTable.add(new RouterInfoItem("N3", 8));
		RouterCTable.add(new RouterInfoItem("N6", 4));
		RouterCTable.add(new RouterInfoItem("N8", 3));
		RouterB.Accept(RouterCTable, "C");
		RouterB.ShowTable();
	}
}
