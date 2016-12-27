package vn.smartdev.invoice.dao.manager;

import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.entity.InvoiceDetail;
import vn.smartdev.invoice.exception.InvoiceDetailNotFoundException;

import java.util.List;

/**
 * Created by nxmt on 26/12/2016.
 */
public interface InvoiceDetailManager {
    List<InvoiceDetail> getAll() throws Exception;
    void save(InvoiceDetail invoiceDetail) throws Exception ;
    void delete(String invoiceDetailId) throws InvoiceDetailNotFoundException;
    List<InvoiceDetail> findByInvoice(Invoice invoice) throws InvoiceDetailNotFoundException;
}
