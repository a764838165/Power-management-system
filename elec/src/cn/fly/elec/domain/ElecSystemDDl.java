package cn.fly.elec.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @po持久层对象 对应数据库表elec_systemddl
 *
 */
public class ElecSystemDDl implements Serializable{
/**
 * CREATE TABLE Elec_SystemDDL(
	SeqID INT NOT NULL,          
	Keyword VARCHAR(20)   NULL,  
	DdlCode INT  NULL,           
	DdlName VARCHAR(50)  NULL    
) 
 */
	private Integer seqID;       //主键ID(自增长)
	private String keyword;      //查询关键字
	private Integer ddlCode;     //数据字典的code
	private String ddlName;      //数据字典的value
	public Integer getSeqID() {
		return seqID;
	}
	public void setSeqID(Integer seqID) {
		this.seqID = seqID;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getDdlCode() {
		return ddlCode;
	}
	public void setDdlCode(Integer ddlCode) {
		this.ddlCode = ddlCode;
	}
	public String getDdlName() {
		return ddlName;
	}
	public void setDdlName(String ddlName) {
		this.ddlName = ddlName;
	}
	
	
	
	
}
