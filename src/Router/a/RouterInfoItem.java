package Router.a;

import java.io.Serializable;

public class RouterInfoItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2384675398435794627L;
	private String DesNetWorkAddr;
	private int Distance;
	private String nextRouterAddr;
	
	public RouterInfoItem(String mNet,int mDis,String mNext){
		this.DesNetWorkAddr = mNet;
		this.Distance = mDis;
		this.nextRouterAddr = mNext;
	}
	
	public RouterInfoItem(String mNet,int mDis){
		this.DesNetWorkAddr = mNet;
		this.Distance = mDis;
	}
	
	public String getDesNetWorkAddr() {
		return DesNetWorkAddr;
	}
	public void setDesNetWorkAddr(String desNetWorkAddr) {
		DesNetWorkAddr = desNetWorkAddr;
	}
	public int getDistance() {
		return Distance;
	}
	public void setDistance(int distance) {
		Distance = distance;
	}
	public String getNextRouterAddr() {
		return nextRouterAddr;
	}
	public void setNextRouterAddr(String nextRouterAddr) {
		this.nextRouterAddr = nextRouterAddr;
	}
	public void DistanceAdd(){
		this.Distance ++;
	}
	
}
