package com.ljm.server.protocol.http.response;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/22
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum HttpStatus {
    STATUS_404(404, "Not Found"), STATUS_200(200, "OK");
    private int statusCode;
    private String reason;

    HttpStatus(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }
}
