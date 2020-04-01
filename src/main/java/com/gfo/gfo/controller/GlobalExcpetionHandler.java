package com.gfo.gfo.controller;

import com.gfo.gfo.Service.ex.*;
import com.gfo.gfo.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcpetionHandler {
    private   Integer OK = 2000;
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable ex) {
        JsonResult<Void> jsonResult = new JsonResult<>(ex);

        if (ex instanceof UsernameDuplicateException) {
            jsonResult.setCode(4000);
            jsonResult.setMessage("注册失败！您尝试注册的用户名已经被占用！");
        } else if (ex instanceof UserNotFoundException) {
            jsonResult.setCode(4001);
            jsonResult.setMessage("登录失败！用户数据不存在！");
        } else if (ex instanceof PasswordNotMatchException) {
            jsonResult.setCode(4002);
            jsonResult.setMessage("登录失败！密码错误！！");
        } else if (ex instanceof InsertException) {
            jsonResult.setCode(5000);
            jsonResult.setMessage("注册失败！执行插入数据时出现未知错误！");
        }else if (ex instanceof UpdateException) {
            jsonResult.setCode(5001);
        } else if (ex instanceof FileEmptyException) {
            jsonResult.setCode(6000);
        } else if (ex instanceof FileSizeException) {
            jsonResult.setCode(6001);
        } else if (ex instanceof FileTypeException) {
            jsonResult.setCode(6002);
        } else if (ex instanceof FileUploadStateException) {
            jsonResult.setCode(6003);
        } else if (ex instanceof FileUploadIOException) {
            jsonResult.setCode(6004);
        }

        return jsonResult;
    }
}