package com.ljm.server.protocol.http.parser;

import com.ljm.server.protocol.http.HttpConstants;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

/**
 * HTTP Message解析上下文
 *
 * @author 李佳明 https://github.com/pkpk1234
 */
public class HttpParserContext {

    private static final ThreadLocal<byte[]> HTTP_MESSAGE_BYTES = new ThreadLocal<>();
    private static final ThreadLocal<String> REQUEST_QUERY_STRING = new ThreadLocal<>();
    private static final ThreadLocal<BodyInfo> BODY_INFO = ThreadLocal.withInitial(() -> new BodyInfo());
    private static final ThreadLocal<Integer> BYTES_LENGTH_BEFORE_BODY = new ThreadLocal<>();
    private static final ThreadLocal<String> HTTP_METHOD = new ThreadLocal<>();
    private static final ThreadLocal<InputStream> INPUT_STREAM = new ThreadLocal<>();

    public static byte[] getHttpMessageBytes() {
        return HTTP_MESSAGE_BYTES.get();
    }

    public static void setHttpMessageBytes(byte[] iHttpMessageBytes) {
        HTTP_MESSAGE_BYTES.set(iHttpMessageBytes);
    }

    public static String getRequestQueryString() {
        return REQUEST_QUERY_STRING.get();
    }

    public static void setRequestQueryString(String iRequestQueryString) {
        REQUEST_QUERY_STRING.set(iRequestQueryString);
    }

    public static boolean getHasBody() {
        return BODY_INFO.get().isHasBody();
    }

    public static void setHasBody(boolean iHasBody) {
        BODY_INFO.get().setHasBody(iHasBody);
    }

    public static int getBytesLengthBeforeBody() {
        return BYTES_LENGTH_BEFORE_BODY.get();
    }

    public static void setBytesLengthBeforeBody(int iBytesLengthBeforeBody) {
        BYTES_LENGTH_BEFORE_BODY.set(iBytesLengthBeforeBody);
    }

    public static String getContentType() {
        return BODY_INFO.get().getContentType();
    }

    public static void setContentType(String contentType) {
        BODY_INFO.get().setContentType(contentType);
    }

    public static String getHttpMethod() {
        return HTTP_METHOD.get();
    }

    public static void setHttpMethod(String method) {
        HTTP_METHOD.set(method);
    }

    public static String getCharset() {
        return BODY_INFO.get().getCharset();
    }

    public static void setCharset(String charset) {
        BODY_INFO.get().setCharset(charset);
    }

    public static String getEncoding() {
        return BODY_INFO.get().getEncoding();
    }

    public static void setEncoding(String encoding) {
        BODY_INFO.get().setEncoding(encoding);
    }

    public static InputStream getInputStream() {
        return INPUT_STREAM.get();
    }

    public static void setInputStream(InputStream inputStream) {
        INPUT_STREAM.set(inputStream);
    }

    public static BodyInfo getBodyInfo() {
        return BODY_INFO.get();
    }

    public static void setBodyInfo(BodyInfo bodyInfo) {
        BODY_INFO.set(bodyInfo);
    }

    public static void setTransferEncoding(String transferEncoding) {
        BODY_INFO.get().setTransferEncoding(transferEncoding);
    }

    public static String getTransferEncoding() {
        String transferEncoding = BODY_INFO.get().getTransferEncoding();
        return StringUtils.isBlank(transferEncoding)
                ? HttpConstants.ENCODING_IDENTITY : transferEncoding;
    }

    public static void removeAll() {
        HTTP_MESSAGE_BYTES.remove();
        REQUEST_QUERY_STRING.remove();
        BODY_INFO.remove();
        BYTES_LENGTH_BEFORE_BODY.remove();
        HTTP_METHOD.remove();
        INPUT_STREAM.remove();
    }
}
