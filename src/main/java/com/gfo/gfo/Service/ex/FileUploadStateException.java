package com.gfo.gfo.Service.ex;

/**
 * @ClassName FileUploadStateException
 * @Description TODO
 * @Author hp
 * @Date 2020/3/24 21:12
 * @Version 1.0
 */
public class FileUploadStateException extends ServiceException {
    private static final long serialVersionUID = -4335994353332866543L;

    public FileUploadStateException() {
    }

    public FileUploadStateException(String message) {
        super(message);
    }

    public FileUploadStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadStateException(Throwable cause) {
        super(cause);
    }

    public FileUploadStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}