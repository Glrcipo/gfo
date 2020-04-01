package com.gfo.gfo.util;

import lombok.Getter;
import lombok.Setter;

/**
 * 用于封装响应结果的类
 * @param <T>
 */
@Getter
@Setter
public class JsonResult<T>{
    private Integer code; // 状态
    private String message; // 错误信息
    private T data; // 数据

    public JsonResult() {
        super();
    }
    public JsonResult(Throwable ex) {
        super();
        this.message = ex.getMessage();
    }
    public JsonResult(Integer code) {
        super();
        this.code = code;
    }
    public JsonResult(Integer code,String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public JsonResult(String message) {
        super();
        this.message = message;
    }
    public JsonResult(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }
    public JsonResult(Integer code,String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
}