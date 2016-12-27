package vn.smartdev.invoice.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.entity.InvoiceDetail;
import vn.smartdev.invoice.dao.repository.InvoiceDetailRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nxmt on 26/12/2016.
 */
@Component
public class InvoiceDetailManagerImpl implements InvoiceDetailManager{

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    @Override
    public void save(InvoiceDetail invoiceDetail) {
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public void delete(String invoiceDetailId) {
        invoiceDetailRepository.delete(invoiceDetailId);
    }

    @Override
    public List<InvoiceDetail> findByInvoice(Invoice invoice) {
        return invoiceDetailRepository.findByInvoice(invoice);
    }
}
