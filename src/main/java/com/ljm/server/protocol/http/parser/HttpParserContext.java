package com.ljm.server.protocol.http.parser;

/**
 * HTTP Message解析上下文
 *
 * @author 李佳明 https://github.com/pkpk1234
 */
public class HttpParserContext {

    private static final ThreadLocal<byte[]> HTTP_MESSAGE_BYTES = new ThreadLocal<>();
    private static final ThreadLocal<String> REQUEST_QUERY_STRING = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> HAS_BODY = new ThreadLocal<Boolean>() {
        @Override
        protected Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private static final ThreadLocal<Integer> BYTES_LENGTH_BEFORE_BODY = new ThreadLocal<>();
    private static final ThreadLocal<String> CONTENT_TYPE = new ThreadLocal<>();
    private static final ThreadLocal<String> HTTP_METHOD = new ThreadLocal<>();
    private static final ThreadLocal<String> ENCODING = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "utf-8";
        }
    };

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
        return HAS_BODY.get();
    }

    public static void setHasBody(boolean iHasBody) {
        HAS_BODY.set(iHasBody);
    }

    public static int getBytesLengthBeforeBody() {
        return BYTES_LENGTH_BEFORE_BODY.get();
    }

    public static void setBytesLengthBeforeBody(int iBytesLengthBeforeBody) {
        BYTES_LENGTH_BEFORE_BODY.set(iBytesLengthBeforeBody);
    }

    public static String getContentType() {
        return CONTENT_TYPE.get();
    }

    public static void setContentType(String contentType) {
        CONTENT_TYPE.set(contentType);
    }

    public static String getHttpMethod() {
        return HTTP_METHOD.get();
    }

    public static void setHttpMethod(String method) {
        HTTP_METHOD.set(method);
    }

    public static String getENCODING() {
        return ENCODING.get();
    }

    public static void setEncoding(String encoding) {
        ENCODING.set(encoding);
    }

    public static void removeAll() {
        HTTP_MESSAGE_BYTES.remove();
        REQUEST_QUERY_STRING.remove();
        HAS_BODY.remove();
        BYTES_LENGTH_BEFORE_BODY.remove();
        CONTENT_TYPE.remove();
        HTTP_METHOD.remove();
        ENCODING.remove();
    }
}
