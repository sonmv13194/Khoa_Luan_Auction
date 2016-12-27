package vn.smartdev.invoice.dao.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.repository.InvoiceRepository;

import java.util.List;

/**
 * Created by nxmt on 26/12/2016.
 */
@Component
public class InvoiceManagerImpl implements InvoiceManager {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void save(Invoice invoice) throws Exception {
        invoiceRepository.save(invoice);
    }

    @Override
    public void delete(String id) {
        invoiceRepository.delete(id);
    }

    @Override
    public Invoice findById(String id) {
        return invoiceRepository.findOne(id);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }
}
