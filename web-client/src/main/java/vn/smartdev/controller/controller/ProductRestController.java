package vn.smartdev.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.manager.ProductDetailServices;
import vn.smartdev.product.manager.ProductServices;

import java.util.List;

/**
 * Created by Nhat on 08/12/2016.
 */
@RestController
@RequestMapping(value="/")
public class ProductRestController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductDetailServices productDetailServices;

    @RequestMapping(value="/productAll",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> viewRestProduct()
    {
        List<Product> listProducts = productServices.getListProduct();
        if(listProducts.isEmpty())
        {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(listProducts,HttpStatus.OK);
    }
}
