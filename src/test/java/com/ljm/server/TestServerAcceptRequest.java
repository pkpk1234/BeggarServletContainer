package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static org.junit.Assert.assertTrue;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class TestServerAcceptRequest {
	private static Server server;
	// 设置超时时间为500毫秒
	private static final int TIMEOUT = 500;

	@BeforeClass
	public static void init() {
		ServerConfig serverConfig = new ServerConfig();
		server = ServerFactory.getServer(serverConfig);
	}

	@Test
	public void testServerAcceptRequest() {
		// 如果server没有启动，首先启动server
		if (server.getStatus().equals(ServerStatus.STOPED)) {
            //在另外一个线程中启动server
		    new Thread(() -> {
				server.start();
			}).start();
            //如果server未启动，就sleep一下
			while (server.getStatus().equals(ServerStatus.STOPED)) {
                System.out.println("等待server启动");
			    try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Socket socket = new Socket();
			SocketAddress endpoint = new InetSocketAddress("localhost",
					ServerConfig.DEFAULT_PORT);
			try {
				// 试图发送请求到服务器，超时时间为TIMEOUT
				socket.connect(endpoint, TIMEOUT);
				assertTrue("服务器启动后，能接受请求", socket.isConnected());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					socket.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@AfterClass
	public static void destroy() {
		server.stop();
	}
}
