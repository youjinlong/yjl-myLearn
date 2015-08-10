/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.service
 * FILE    NAME: IClientInfoService.java
 */ 
package com.tuch.server.service;

import com.tuch.common.util.Pagination;
import com.tuch.server.entity.ClientInfo;

public interface IClientInfoService  {
	
	public Pagination<ClientInfo> clientInfoList(Pagination<ClientInfo> pagination);

}
