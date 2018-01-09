package com.ljm.server;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/9
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestServer.class,
        TestServerAcceptRequest.class
})
public class TestServerSuite {
}
