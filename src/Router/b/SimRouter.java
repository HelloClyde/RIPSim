package Router.b;

import Router.a.*;

public class SimRouter extends MainRouter{
	String Name;
	String[] SurrNet;
	String[] SurrRouter;
	
	public SimRouter(String mName,String[] sNet,String[] sRouter){
		super();
		this.Name = mName;
		this.SurrNet = sNet;
		this.SurrRouter = sRouter;
		for (int i = 0;i < SurrNet.length;i ++){
			this.mRouterTables.add(new RouterInfoItem(SurrNet[i], 1, "-"));
		}
	}
	
	public String getName(){
		return Name;
	}
	
	public RouterInfoItem GetRouterInfoItemByNetAddr(String NetAddr){
		for (int i = 0;i < this.mRouterTables.size();i ++){
			if (this.mRouterTables.get(i).getDesNetWorkAddr().equals(NetAddr)){
				return this.mRouterTables.get(i);
			}
		}
		return null;
	}
}
