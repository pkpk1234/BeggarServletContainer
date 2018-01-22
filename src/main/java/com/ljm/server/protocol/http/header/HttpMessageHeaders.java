package com.ljm.server.protocol.http.header;

import com.google.common.collect.LinkedListMultimap;

import java.util.List;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class HttpMessageHeaders implements IMessageHeaders {

	private final LinkedListMultimap<String, HttpHeader> headersMultiMap;

	public HttpMessageHeaders() {
		this.headersMultiMap = LinkedListMultimap.create();
	}

	private HttpMessageHeaders(Builder builder) {
		headersMultiMap = builder.headersMultiMap;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@Override
	public List<HttpHeader> getHeaders(String headerName) {
		return this.headersMultiMap.get(headerName);
	}

	@Override
	public HttpHeader getFirstHeader(String headerName) {
		List<HttpHeader> headers = this.headersMultiMap.get(headerName);
		if (headers.isEmpty()) {
			return null;
		}
		else {
			return headers.get(0);
		}
	}

	@Override
	public List<HttpHeader> getAllHeaders() {
		return this.headersMultiMap.values();
	}

	@Override
	public void addHeader(HttpHeader httpHeader) {
		this.headersMultiMap.put(httpHeader.getName(), httpHeader);
	}

	@Override
	public void removeHeader(HttpHeader httpHeader) {
		this.headersMultiMap.remove(httpHeader.getName(), httpHeader);
	}

	@Override
	public void removeHeaders(String headerName) {
		this.headersMultiMap.removeAll(headerName);
	}

	@Override
	public boolean hasHeader(String headerName) {
		return this.headersMultiMap.containsKey(headerName);
	}

	@Override
	public Set<String> getHeaderNames() {
		return this.headersMultiMap.keySet();
	}

	@Override
	public String asString() {
		StringBuffer stringBuffer = new StringBuffer();
		for (HttpHeader header : this.headersMultiMap.values()) {
			stringBuffer.append(header.getName()).append(":").append(header.getValue())
					.append("\r\n");
		}
		return stringBuffer.toString();
	}

	public static final class Builder {
		private final LinkedListMultimap<String, HttpHeader> headersMultiMap;

		private Builder() {
			this.headersMultiMap = LinkedListMultimap.create();
		}

		public Builder addHeader(String name, String value) {
			this.headersMultiMap.put(name, new HttpHeader(name, value));
			return this;
		}

		public HttpMessageHeaders build() {
			return new HttpMessageHeaders(this);
		}
	}
}
