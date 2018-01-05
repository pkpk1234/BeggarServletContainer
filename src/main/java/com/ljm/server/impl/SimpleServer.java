package com.ljm.server.impl;

import com.ljm.server.Server;
import com.ljm.server.ServerStatus;
import com.ljm.server.config.ServerConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 */
public class SimpleServer implements Server {

	private volatile ServerStatus serverStatus = ServerStatus.STOPED;
	private final int port;
	private ServerSocket serverSocket;

	public SimpleServer(ServerConfig serverConfig) {
		this.port = serverConfig.getPort();
	}

	@Override
	public void start() {
		Socket socket = null;
		try {
			this.serverSocket = new ServerSocket(this.port);
			this.serverStatus = ServerStatus.STARTED;
			System.out.println("Server start");
			while (true) {
				socket = serverSocket.accept();// 从连接队列中取出一个连接，如果没有则等待
				System.out.println(
						"新增连接：" + socket.getInetAddress() + ":" + socket.getPort());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (socket != null) {
				try {
					socket.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void stop() {
		try {
			if (this.serverSocket != null) {
				this.serverSocket.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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
