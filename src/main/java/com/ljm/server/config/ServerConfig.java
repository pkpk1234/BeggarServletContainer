package com.ljm.server.config;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class ServerConfig {

	public static final int DEFAULT_PORT = 18080;
	private final int port;

	public ServerConfig(int PORT) {
		this.port = PORT;
	}

	public ServerConfig() {
		this.port = DEFAULT_PORT;
	}

	public int getPort() {
		return port;
	}
}
