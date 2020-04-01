package com.gfo.gfo.Service.ex;

/**
 * @ClassName FileUploadIOException
 * @Description TODO
 * @Author hp
 * @Date 2020/3/24 21:13
 * @Version 1.0
 */
public class FileUploadIOException extends ServiceException {
    private static final long serialVersionUID = -7743721120747054939L;

    public FileUploadIOException() {
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    public FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}