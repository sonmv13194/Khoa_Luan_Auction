package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class UploadFileFailedException  extends Exception{
    public UploadFileFailedException() {
        super();
    }

    public UploadFileFailedException(String message) {
        super(message);
    }

    public UploadFileFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadFileFailedException(Throwable cause) {
        super(cause);
    }

    protected UploadFileFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
