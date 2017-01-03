package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class ProductImageNotFoundException extends Exception{
    public ProductImageNotFoundException() {
        super();
    }

    public ProductImageNotFoundException(String message) {
        super(message);
    }

    public ProductImageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductImageNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductImageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
