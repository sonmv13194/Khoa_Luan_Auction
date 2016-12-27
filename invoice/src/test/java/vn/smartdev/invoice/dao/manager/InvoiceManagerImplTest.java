package vn.smartdev.invoice.dao.manager;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.repository.InvoiceDetailRepository;
import vn.smartdev.invoice.dao.repository.InvoiceRepository;
import vn.smartdev.invoice.exception.InvoiceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nxmt on 23/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class InvoiceManagerImplTest {
    @InjectMocks
    InvoiceManagerImpl invoiceManagerImpl;

    @Mock
    InvoiceRepository invoiceRepository;

    @Mock
    InvoiceDetailRepository invoiceDetailRepository;

    private Map<String, Invoice> invoiceMap;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        invoiceMap = PrepareInvoice.prepareListInvoice(10);
        Mockito.when(invoiceRepository.findAll()).thenAnswer(new Answer<List<Invoice>>() {
            @Override
            public List<Invoice> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<Invoice> listInvoice = PrepareInvoice.getListInvoice(invoiceMap);
                return listInvoice;
            }
        });
        Mockito.when(invoiceRepository.findByUsername("invoice of 1")).thenAnswer(new Answer<List<Invoice>>() {
            @Override
            public List<Invoice> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<Invoice> invoicesByUser = new ArrayList<Invoice>();
                List<Invoice> invoices = PrepareInvoice.getListInvoice(invoiceMap);
                for(Invoice invoice : invoices){
                    if(invoice.getUsername().equalsIgnoreCase("invoice of 1")){
                        invoicesByUser.add(invoice);
                    }
                }
                return invoicesByUser;
            }
        });
        Invoice invoice = new Invoice();
        invoice.setId("invoice 1");
        Mockito.when(invoiceRepository.findOne("invoice 1")).thenReturn(invoice);
    }
    @Test
    public void getAll() throws Exception {
        List<Invoice> invoices = invoiceManagerImpl.findAll();
        Assertions.assertThat(invoices.size()).isEqualTo(10);
    }

    @Test
    public void findById() throws InvoiceNotFoundException {
        Invoice invoice = invoiceManagerImpl.findById("invoice 1");
        Assertions.assertThat(invoice.getId()).isEqualTo("invoice 1");
    }

    @Test
    public void save() throws Exception {
        ArgumentCaptor<Invoice> invoiceStringArgumentCaptor = ArgumentCaptor.forClass(Invoice.class);
        Invoice invoice = PrepareInvoice.getInvoice();
        invoiceManagerImpl.save(invoice);
        Mockito.verify(invoiceRepository, Mockito.times(1)).save(invoiceStringArgumentCaptor.capture());
        Invoice invoiceCheck = invoiceStringArgumentCaptor.getValue();
        Assertions.assertThat(invoiceCheck.getId()).isEqualTo("invoice 1");
    }

    @Test
    public void delete() throws InvoiceNotFoundException {
        ArgumentCaptor<String> invoiceStringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Invoice invoice = PrepareInvoice.getInvoice();
        invoiceManagerImpl.delete(invoice.getId());
        Mockito.verify(invoiceRepository, Mockito.times(1)).delete(invoiceStringArgumentCaptor.capture());
        String id = invoiceStringArgumentCaptor.getValue();
        Assertions.assertThat(id).isEqualTo("invoice 1");
    }
}