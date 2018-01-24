package com.ljm.server.protocol.http;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 * <p>
 * 参考 https://tools.ietf.org/html/rfc2616#page-31 Status-Line = HTTP-Version SP
 * Status-Code SP Reason-Phrase CRLF
 */
public class ResponseLine implements StartLine {
	private final String httpVersion;
	private final int statusCode;
	private final String reason;

	public ResponseLine(String httpVersion, int statusCode, String reason) {
		this.httpVersion = httpVersion;
		this.statusCode = statusCode;
		this.reason = reason;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getReason() {
		return reason;
	}

	public String asString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(this.httpVersion).append(" ").append(this.statusCode)
				.append(" ").append(this.reason);
		return stringBuffer.toString();
	}

	@Override
	public String getHttpVersion() {
		return httpVersion;
	}
}
