package Router.a;

import java.io.Serializable;
import java.util.ArrayList;

public class NetInfomation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1199943616143844647L;
	ArrayList<RouterInfoItem> RouterTables;
	String fromRouterNameString;
	
	public NetInfomation(ArrayList<RouterInfoItem> mTable,String mName){
		this.RouterTables = mTable;
		this.fromRouterNameString = mName;
	}

	public ArrayList<RouterInfoItem> getRouterTables() {
		return RouterTables;
	}

	public String getFromRouterNameString() {
		return fromRouterNameString;
	}
	
	
}
