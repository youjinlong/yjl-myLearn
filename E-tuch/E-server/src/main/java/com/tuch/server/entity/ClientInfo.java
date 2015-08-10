/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.entity
 * FILE    NAME: ClientInfo.java
 */
package com.tuch.server.entity;

import com.tuch.common.entity.IEntity;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年7月23日 上午11:44:06
 * @version <b>1.0.0</b>
 */
public class ClientInfo implements IEntity<String> {

	private String id;
	private String clientName;
	private String address;
	private String linkMan;
	private String code;
	private String status;

	/**
	 * 获得id
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获得clientName
	 * 
	 * @return String
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * 设置clientName
	 * 
	 * @param clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * 获得address
	 * 
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获得linkMan
	 * 
	 * @return String
	 */
	public String getLinkMan() {
		return linkMan;
	}

	/**
	 * 设置linkMan
	 * 
	 * @param linkMan
	 */
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	/**
	 * 获得code
	 * 
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置code
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获得status
	 * 
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
