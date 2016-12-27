package vn.smartdev.invoice.exception;

/**
 * Created by nxmt on 27/12/2016.
 */
public class InvoiceDetailNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvoiceDetailNotFoundException() {
        super();
    }

    public InvoiceDetailNotFoundException(String message) {
        super(message);
    }

    public InvoiceDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvoiceDetailNotFoundException(Throwable cause) {
        super(cause);
    }

    protected InvoiceDetailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
