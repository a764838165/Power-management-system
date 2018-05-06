package cn.fly.elec.web.from;

import java.io.Serializable;

public class ElecCommonMsgFrom implements Serializable{

	private String comId;		//主见id
	private String stationRun;	//站点运行情况
	private String devRun;		//设备运行情况
	private String createDate;	//创建日期
	
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getStationRun() {
		return stationRun;
	}
	public void setStationRun(String stationRun) {
		this.stationRun = stationRun;
	}
	public String getDevRun() {
		return devRun;
	}
	public void setDevRun(String devRun) {
		this.devRun = devRun;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
