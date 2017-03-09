package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class ProductAlreadyException extends Exception{
    public ProductAlreadyException() {
        super();
    }
    public ProductAlreadyException(String message)
    {
        super(message);
    }
    public ProductAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductAlreadyException(Throwable cause) {
        super(cause);
    }

    protected ProductAlreadyException(String message, Throwable cause,
                                       boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
