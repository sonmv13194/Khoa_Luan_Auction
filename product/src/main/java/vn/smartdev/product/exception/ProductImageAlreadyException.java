package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class ProductImageAlreadyException extends Exception{
    public ProductImageAlreadyException() {
        super();
    }

    public ProductImageAlreadyException(String message) {
        super(message);
    }

    public ProductImageAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ProductImageAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductImageAlreadyException(Throwable cause) {
        super(cause);
    }
}
