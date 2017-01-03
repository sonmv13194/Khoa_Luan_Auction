package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class ProductDetailAlreadyException extends Exception{
    public ProductDetailAlreadyException() {
        super();
    }

    public ProductDetailAlreadyException(String message) {
        super(message);
    }

    public ProductDetailAlreadyException(Throwable cause) {
        super(cause);
    }

    public ProductDetailAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ProductDetailAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
