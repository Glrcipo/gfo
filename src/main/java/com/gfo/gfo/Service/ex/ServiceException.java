package com.gfo.gfo.Service.ex;

/**
 * 异常类的基类
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -8770815773974995839L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}