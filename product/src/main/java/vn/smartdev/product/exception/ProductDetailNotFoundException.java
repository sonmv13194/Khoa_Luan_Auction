package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class ProductDetailNotFoundException extends Exception{
    public ProductDetailNotFoundException() {
        super();
    }

    public ProductDetailNotFoundException(String message) {
        super(message);
    }

    public ProductDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductDetailNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductDetailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
