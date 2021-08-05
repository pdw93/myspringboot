package com.ssnail.myspringboot.controller.vo;

/**
 * @author pengdengwang
 * @since 2021/8/5
 */
public class Result<T> {
    private boolean success = false;
    private T data = null;
    private String msg = "";
    private String code = "500";
    private String traceId;

    public Result() {
        setupTraceId();
    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<T>();
        r.setData(data);
        r.setSuccess(true);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }

    public static <T> Result<T> fail(String code, String msg) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    private void setupTraceId() {
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public String getTraceId() {
        return traceId;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }
}
