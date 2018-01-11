package com.ljm.server;

import com.ljm.server.config.ServerConfig;
import com.ljm.server.demo.EchoEventHandler;
import com.ljm.server.event.listener.EventListener;
import com.ljm.server.io.connection.Connection;
import com.ljm.server.io.connector.impl.socket.SocketConnector;
import com.ljm.server.io.connector.impl.socket.SocketConnectorFactory;
import com.ljm.server.io.event.listener.impl.ConnectionEventListener;
import com.ljm.server.io.utils.IoUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import static org.junit.Assert.assertTrue;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class TestServerAcceptRequest extends TestServerBase {
    private static Logger logger = LoggerFactory.getLogger(TestServerAcceptRequest.class);
    private static Server server;
    // 设置超时时间为500毫秒
    private static final int TIMEOUT = 500;

    @BeforeClass
    public static void init() {
        EventListener<Connection> socketEventListener =
                new ConnectionEventListener(new EchoEventHandler());
        SocketConnector connector = SocketConnectorFactory.build(ServerConfig.DEFAULT_PORT, socketEventListener);
        ServerConfig serverConfig = ServerConfig.builder().addConnector(connector).build();
        server = ServerFactory.getServer(serverConfig);
    }

    @Test
    public void testServerAcceptRequest() {
        // 如果server没有启动，首先启动server
        if (server.getStatus().equals(ServerStatus.STOPED)) {
            startServer(server);
            waitServerStart(server);
            Socket socket = new Socket();
            SocketAddress endpoint = new InetSocketAddress("localhost",
                    ServerConfig.DEFAULT_PORT);
            try {
                // 试图发送请求到服务器，超时时间为TIMEOUT
                socket.connect(endpoint, TIMEOUT);
                assertTrue("服务器启动后，能接受请求", socket.isConnected());
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            } finally {
                IoUtils.closeQuietly(socket);
            }
        }
    }

    @AfterClass
    public static void destroy() {
        server.stop();
    }
}
