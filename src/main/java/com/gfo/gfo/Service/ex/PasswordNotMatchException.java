package com.gfo.gfo.Service.ex;

/**
 * @ClassName PasswordNotMatchException
 * @Description TODO
 * @Author hp
 * @Date 2020/3/24 17:45
 * @Version 1.0
 */
public class PasswordNotMatchException extends ServiceException {
    private static final long serialVersionUID = 5988534521002110906L;

    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}