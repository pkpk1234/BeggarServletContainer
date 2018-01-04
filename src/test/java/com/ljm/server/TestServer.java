package com.ljm.server;

import com.ljm.server.impl.SimpleServer;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/4
 */
public class TestServer {
	private static final Server SERVER = new SimpleServer();

	@BeforeClass

	@Test
	public void testServerStart() {
		SERVER.start();
	}

	@Test
	public void testServerStop() {
		SERVER.stop();
	}
}
