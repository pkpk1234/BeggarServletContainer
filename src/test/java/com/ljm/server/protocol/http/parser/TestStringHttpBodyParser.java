package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpBody;
import org.junit.Test;
import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class TestStringHttpBodyParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestStringHttpBodyParser.class);
    private static final String HTTP_BODY = "{\n" +
            "    \"code\": 200,\n" +
            "    \"data\": {\n" +
            "        \"user\": {\n" +
            "            \"accountId\": 3,\n" +
            "            \"allowCollaboDocs\": false,\n" +
            "            \"allowUserVolumeSettings\": true,\n" +
            "            \"allowWebdocs\": true,\n" +
            "            \"appId\": \"OneBox\",\n" +
            "            \"batchDownload\": false,\n" +
            "            \"cloudUserId\": 137391,\n" +
            "            \"deviceAddress\": \"10.148.9.122\",\n" +
            "            \"deviceAgent\": \"Chrome\",\n" +
            "            \"deviceOS\": \"Windows\",\n" +
            "            \"deviceType\": 0,\n" +
            "            \"enterpriseId\": 1,\n" +
            "            \"event\": {\n" +
            "                \"createdAt\": 1516154891193,\n" +
            "                \"createdBy\": 137607,\n" +
            "                \"deviceAddress\": \"10.148.9.122\",\n" +
            "                \"deviceAgent\": \"Chrome\",\n" +
            "                \"deviceType\": 0,\n" +
            "                \"type\": \"USER_LOGIN\"\n" +
            "            },\n" +
            "            \"expiredAt\": 1516160290185,\n" +
            "            \"fileCount\": 0,\n" +
            "            \"id\": 137607,\n" +
            "            \"loginName\": \"l00388716\",\n" +
            "            \"maxVersions\": 0,\n" +
            "            \"name\": \"lijiaming 00388716\",\n" +
            "            \"openQR\": true,\n" +
            "            \"parameter\": {\n" +
            "                \"bestStorage\": \"Shenzhen\",\n" +
            "                \"bestStorageId\": \"2\",\n" +
            "                \"isSwitchRegion\": \"true\",\n" +
            "                \"storage\": \"ShenzhenChina\",\n" +
            "                \"storageId\": \"45\"\n" +
            "            },\n" +
            "            \"principalType\": 1,\n" +
            "            \"proxyAddress\": \"10.2.144.184\",\n" +
            "            \"recycleDays\": 0,\n" +
            "            \"regionId\": 0,\n" +
            "            \"resourceType\": -1,\n" +
            "            \"spaceQuota\": 0,\n" +
            "            \"spaceUsed\": 0,\n" +
            "            \"teamSpaceFlag\": 0,\n" +
            "            \"teamSpaceMaxNum\": 0,\n" +
            "            \"token\": \"OneBox/784cb75313408b11a9bede5397389536\",\n" +
            "            \"type\": 0\n" +
            "        }\n" +
            "    },\n" +
            "    \"msg\": \"ntlmsuccess\"\n" +
            "}";
    private static final String HTTP_MESSAGE =
            "POST / HTTP1.1\r\n" +
                    "Host:www.wrox.com\r\n" +
                    "User-Agent:Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022)\r\n" +
                    "Content-Type:application/json\r\n" +
                    "Connection: Keep-Alive\r\n\r\n" +
                     HTTP_BODY;

    @Test
    public void test() throws IOException {
        StringHttpBodyParser stringHttpBodyParser
                = new StringHttpBodyParser();
        InputStream inputStream = new ByteArrayInputStream(HTTP_MESSAGE.getBytes("UTF-8"));
        inputStream.mark(Integer.MAX_VALUE);
        HttpBody<String> body = stringHttpBodyParser.parse(inputStream, "application/json", "UTF-8");
        assertEquals(HTTP_BODY, body.getBodyContent());
    }
}
