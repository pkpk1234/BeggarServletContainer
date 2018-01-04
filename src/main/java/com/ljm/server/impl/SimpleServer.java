package com.ljm.server.impl;

import com.ljm.server.Server;
import com.ljm.server.ServerStatus;
import com.ljm.server.config.ServerConfig;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 */
public class SimpleServer implements Server {

	private ServerStatus serverStatus = ServerStatus.STOPED;
	private final int port;

	public SimpleServer(ServerConfig serverConfig) {
		this.port = serverConfig.getPort();
	}

	@Override
	public void start() {
		this.serverStatus = ServerStatus.STARTED;
		System.out.println("Server start");
	}

	@Override
	public void stop() {
		this.serverStatus = ServerStatus.STOPED;
		System.out.println("Server stop");
	}

	@Override
	public ServerStatus getStatus() {
		return serverStatus;
	}

	@Override
	public int getPort() {
		return port;
	}
}
