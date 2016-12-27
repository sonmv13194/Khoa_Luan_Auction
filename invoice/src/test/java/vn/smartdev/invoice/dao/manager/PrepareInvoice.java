package vn.smartdev.invoice.dao.manager;

import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.invoice.dao.entity.Invoice;
import vn.smartdev.invoice.dao.entity.InvoiceDetail;
import vn.smartdev.invoice.dao.entity.Status;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nguyen on 30/11/2016.
 */
public class PrepareInvoice {
    protected static Map<String, Invoice> prepareListInvoice(int number){
        Map<String, Invoice> prepareInvoice = new HashMap<String, Invoice>();
        for (int i = 0; i < number; i ++){
            Invoice invoice = new Invoice();
            invoice.setId("invoice" + i );
            invoice.setUsername("invoice of " + i );
            prepareInvoice.put("invoiceMap " + i, invoice);
        }
        return prepareInvoice;
    }

    protected static List<Invoice> getListInvoice(Map<String, Invoice> invoiceMap){
        List<Invoice> invoices = new ArrayList<Invoice>();
        for (int i = 0; i < invoiceMap.size(); i ++){
            invoices.add(invoiceMap.get("invoiceMap " + i));
        }
        return invoices;
    }
//    protected static InvoiceModel getInvoiceModel(){
//        InvoiceModel invoice = new InvoiceModel();
//        invoice.setId("invoice 1");
//        invoice.setAddress("NPN");
//        invoice.setStatus(Status.NotYet);
//        invoice.setEmail("toannxm.it");
//        invoice.setCity("DN");
//        invoice.setFirstName("Toan");
//        invoice.setLastName("Minh");
//        invoice.setPhone("0936054481");
//        invoice.setUsername("toan");
//        invoice.setInvoiceDate(Date.valueOf("2016-10-12"));
//        InvoiceDetail invoiceDetail = new InvoiceDetail();
//        invoiceDetail.setId("invoiceDetail 1");
//        invoiceDetail.setDiscount(10);
//        invoiceDetail.setProductDetail(prepareProductDetail());
//        invoiceDetail.setQuantity(1);
//        invoiceDetail.setAmount(100);
//        List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
//        invoiceDetails.add(invoiceDetail);
//        invoice.setInvoiceDetails(invoiceDetails);
//        return invoice;
//    }
    protected static Invoice getInvoice(){
        Invoice invoice = new Invoice();
        invoice.setId("invoice 1");
        invoice.setAddress("NPN");
        invoice.setStatus(Status.NotYet);
        invoice.setEmail("toannxm.it");
        invoice.setCity("DN");
        invoice.setFirstName("Toan");
        invoice.setLastName("Minh");
        invoice.setPhone("0936054481");
        invoice.setUsername("toan");
        invoice.setInvoiceDate(Date.valueOf("2016-10-12"));
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setId("invoiceDetail 1");
        invoiceDetail.setDiscount(10);
        invoiceDetail.setProductDetail(prepareProductDetail());
        invoiceDetail.setQuantity(1);
        invoiceDetail.setAmount(100);
        List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
        invoiceDetails.add(invoiceDetail);
        invoice.setInvoiceDetails(invoiceDetails);
        return invoice;
    }
//    protected static List<CartModel> prepareCart(){
//        List<CartModel> cartModels = new ArrayList<CartModel>();
//        CartModel cartModel = new CartModel();
//        cartModel.setProductDetail(prepareProductDetail());
//        cartModel.setDiscount(10);
//        cartModel.setQuantity(1);
//        cartModels.add(cartModel);
//        return cartModels;
//    }
    protected static Product prepareProduct(){
        Product product = new Product("Ao Jean","Blue");
        product.setId("product 1");
        product.setCategory(new Category("Ao"));
        return product;
    }
//    protected static ProductImage prepareProductImage(){
//        ProductImage productImage = new ProductImage();
//        productImage.setId("productImage 1");
//        productImage.setUrl("productImage1.jpg");
//        productImage.setProductDetail(prepareProductDetail());
//        return productImage;
//    }
    protected static ProductDetail prepareProductDetail(){
        ProductDetail productDetail = new ProductDetail("abc", "So mi", 100, 10, 1, "DN");
        productDetail.setProduct(prepareProduct());
        productDetail.setId("productDetail 1");
        return productDetail;
    }
}
