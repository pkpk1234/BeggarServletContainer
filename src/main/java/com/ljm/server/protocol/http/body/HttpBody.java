package com.ljm.server.protocol.http.body;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/13
 */
public class HttpBody {
	private String contentType;
	private String encoding;
	private byte[] content;
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public HttpBody(InputStream inputStream) {

		this.inputStream = inputStream;
	}

	public HttpBody(byte[] content) {
		this.content = content;
	}

	public HttpBody(String contentType, String encoding, byte[] content) {
		this.contentType = contentType;
		this.encoding = encoding;
		this.content = content;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * 获取HttpBody内容 无法用String表示的内容，比如图片、文件
	 *
	 * @return
	 */
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getContentType() {
		return this.contentType;
	}

	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * 获取获取HttpBody内容 可以用String表示的内容，比如json字符串
	 *
	 * @return
	 */
	public String getBodyAsString() throws UnsupportedEncodingException {
		return new String(this.content, this.encoding);
	}

}
