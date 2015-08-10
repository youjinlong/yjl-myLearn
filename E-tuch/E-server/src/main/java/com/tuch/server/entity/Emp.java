/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.entity
 * FILE    NAME: Emp.java
 */
package com.tuch.server.entity;

import java.util.Date;

import com.tuch.common.entity.IEntity;

/**
 * 测试 emp
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:30:56
 * @version <b>1.0.0</b>
 */
public class Emp implements IEntity<String> {

	private String id;
	private String eName;
	private String job;
	private String mgr;
	private Date hireDate;
	private double sal;
	private String comm;
	private String deptNo;

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
	 * 获得eName
	 * 
	 * @return String
	 */
	public String geteName() {
		return eName;
	}

	/**
	 * 设置eName
	 * 
	 * @param eName
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}

	/**
	 * 获得job
	 * 
	 * @return String
	 */
	public String getJob() {
		return job;
	}

	/**
	 * 设置job
	 * 
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * 获得mgr
	 * 
	 * @return String
	 */
	public String getMgr() {
		return mgr;
	}

	/**
	 * 设置mgr
	 * 
	 * @param mgr
	 */
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	/**
	 * 获得hireDate
	 * 
	 * @return Date
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * 设置hireDate
	 * 
	 * @param hireDate
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * 获得sal
	 * 
	 * @return double
	 */
	public double getSal() {
		return sal;
	}

	/**
	 * 设置sal
	 * 
	 * @param sal
	 */
	public void setSal(double sal) {
		this.sal = sal;
	}

	/**
	 * 获得comm
	 * 
	 * @return String
	 */
	public String getComm() {
		return comm;
	}

	/**
	 * 设置comm
	 * 
	 * @param comm
	 */
	public void setComm(String comm) {
		this.comm = comm;
	}

	/**
	 * 获得deptNo
	 * 
	 * @return String
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * 设置deptNo
	 * 
	 * @param deptNo
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

}
