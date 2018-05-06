package cn.fly.elec.domain;

import java.io.Serializable;
import java.util.Date;

public class ElecCommonMsg implements Serializable{

	private String comId;		//主见id
	private String stationRun;	//站点运行情况
	private String devRun;		//设备运行情况
	private Date createDate;	//创建日期
	
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
