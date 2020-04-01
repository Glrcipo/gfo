package com.gfo.gfo.Service.ex;

/**
 * @ClassName UserNotFoundException
 * @Description TODO
 * @Author hp
 * @Date 2020/3/24 17:40
 * @Version 1.0
 */
public class UserNotFoundException extends ServiceException {
    private static final long serialVersionUID = 3903670143665288212L;

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}