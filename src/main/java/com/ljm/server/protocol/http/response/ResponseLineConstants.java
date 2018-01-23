package com.ljm.server.protocol.http.response;

import com.ljm.server.protocol.http.HttpProtocol;
import com.ljm.server.protocol.http.ResponseLine;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018/1/22
 */
public interface ResponseLineConstants {
	ResponseLine RES_404 = new ResponseLine(HttpProtocol.VERSION11.toString(),
			HttpStatus.STATUS_404.getStatusCode(), HttpStatus.STATUS_404.getReason());

	ResponseLine RES_200 = new ResponseLine(HttpProtocol.VERSION11.toString(),
			HttpStatus.STATUS_200.getStatusCode(), HttpStatus.STATUS_200.getReason());
}
