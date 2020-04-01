package com.gfo.gfo.dto;

public class Result<T> {
    private String code;
    private String message;
    private T data;

    public Result() {
        this.code = ResultType.SUCCESS.getCode();
        this.message = ResultType.SUCCESS.getLabel();
        this.data = null;
    }

    public Result<T> message(String code, String msg) {
        this.code = code;
        this.message = msg;
        return this;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> success() {
        this.code = ResultType.SUCCESS.getCode();
        this.message = ResultType.SUCCESS.getLabel();
        return this;
    }

    public Result<T> success(String msg, T data) {
        this.data = data;
        this.code = ResultType.SUCCESS.getCode();
        this.message = msg;
        return this;
    }

    public Result<T> success(T data) {
        this.data = data;
        this.code = ResultType.SUCCESS.getCode();
        this.message = ResultType.SUCCESS.getLabel();
        return this;
    }

    public Result<T> fail(String msg) {
        this.code = ResultType.FAIL.getCode();
        this.message = msg;
        return this;
    }

    public boolean isSuccess() {
        return ResultType.SUCCESS.code.equals(this.getCode());
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    static enum ResultType {
        SUCCESS("success", "成功"),
        FAIL("fail", "失败"),
        WAITING("waiting", "等待");

        private String code;
        private String label;

        private ResultType(String code, String label) {
            this.code = code;
            this.label = label;
        }

        public String getCode() {
            return this.code;
        }

        public String getLabel() {
            return this.label;
        }
    }
}

