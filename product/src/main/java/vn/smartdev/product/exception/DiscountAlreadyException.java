package vn.smartdev.product.exception;

/**
 * Created by nhatnguyen on 30/12/2016.
 */
public class DiscountAlreadyException extends Exception{
    public DiscountAlreadyException() {
        super();
    }

    public DiscountAlreadyException(String message) {
        super(message);
    }

    public DiscountAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiscountAlreadyException(Throwable cause) {
        super(cause);
    }

    protected DiscountAlreadyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
