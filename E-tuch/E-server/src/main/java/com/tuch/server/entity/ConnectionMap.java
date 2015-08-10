/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.entity
 * FILE    NAME: ConnectionMap.java
 */
package com.tuch.server.entity;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年7月23日 上午10:43:56
 * @version <b>1.0.0</b>
 */

@Component
public class ConnectionMap {

	private Map<ChannelId, Channel> connection = new HashMap<ChannelId, Channel>();

	/**
	 * 获得connection
	 * 
	 * @return Map<ChannelId,Channel>
	 */
	public Map<ChannelId, Channel> getConnection() {
		return connection;
	}

	/**
	 * 设置connection
	 * 
	 * @param connection
	 */
	public void setConnection(Map<ChannelId, Channel> connection) {
		this.connection = connection;
	}

}
