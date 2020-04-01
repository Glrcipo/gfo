package com.gfo.gfo.Service.ex;

/**
 * 插入数据异常
 */
public class InsertException extends ServiceException {
    private static final long serialVersionUID = -8643720368862383421L;

    public InsertException() {
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}