package vn.smartdev.product.handlingData;

import jdk.nashorn.internal.objects.NativeRegExp;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nhat on 29/11/2016.
 */
public class HandlingEmulatorData {
    //1.Emulator Product And Category

    //initialized ListCategory()
    public List<Category> createListCategory(int number)
    {
        List<Category> listCategory = new ArrayList<Category>();
        for(int i = 0 ; i < number ; i++)
        {
            Category category = new Category();
            category.setCategoryName("category_"+i);
            listCategory.add(category);
        }
        return listCategory;
    }

    //initialized productMap()
    public Map<String,Product> productMap = new HashMap<String,Product>();

    //initialized createProductMap()
    public Map<String,Product> createProductMap(int number,List<Category> listCategory)
        {
            Map<String,Product> createProductMap = new HashMap<String,Product>();

            for(int i = 0 ; i < listCategory.size() ; i++)
            {
                for(int j = 0 ; j < number ; j++)
                {
                    Product product = new Product();
                    product.setProductName("name_"+j);
                    product.setDescription("description_"+j);
                    product.setCategory(listCategory.get(i));
                    createProductMap.put("productMap_"+i+" - "+j,product);
                }
            }
            return createProductMap;
    }

    //initialized listProduct()
    public List<Product> createListProduct(Map<String,Product> createProductMap)
    {
        List<Product> listProduct = new ArrayList<Product>();
        for(int i = 0 ;  i < createProductMap.size() ; i++)
        {
            listProduct.add(createProductMap.get("productMap_"+i));
        }
        return listProduct;
    }
    public Product createNewProduct()
    {
        Product product = new Product();
        product.setProductName("name_13");
        product.setDescription("description_13");
        return product;
    }
    public ProductDetail createProductDetail(Product product)
    {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId("123456789");
        productDetail.setProductDetailName("productDetailName_13");
        productDetail.setDescription("productDetailDescription_13");
        productDetail.setProductDetailPrice(13);
        productDetail.setSupplyer("productDetailSupplyer_13");
        productDetail.setProductDetailQuantity(13);
        productDetail.setProductDetailStatus(1);
        productDetail.setProduct(product);
        return productDetail;
    }
    public ProductImage createProductImage(ProductDetail productDetail)
    {
        ProductImage productImage = new ProductImage();
        productImage.setProductDetail(productDetail);
        productImage.setUrl("productImage_13");
        return productImage;
    }

    //ProductDetail
    public List<ProductDetail> createListProductDetail(List<Product> listProduct,int number)
    {
        List<ProductDetail> listProductDetail = new ArrayList<ProductDetail>();
        for(int i = 0; i < listProduct.size() ; i++)
        {
            for(int j = 0 ; j < number ; j++)
            {
                ProductDetail productDetail = new ProductDetail();
                productDetail.setProductDetailName("productDetailCode_"+i+"-"+j);
                productDetail.setDescription("productDetailDescription_" + i + "-" + j);
                productDetail.setProductDetailPrice(i);
                productDetail.setProductDetailQuantity(i);
                productDetail.setSupplyer("productDetailSupplyer_" + i + "-" + j);
                productDetail.setProduct(listProduct.get(i));
                listProductDetail.add(productDetail);
            }
        }
        return listProductDetail;
    }
    public ProductDetail createNewProductDetail()
    {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId("productDetailId_30");
        productDetail.setProductDetailName("productDetailCode_30");
        productDetail.setDescription("productDetailDescription_30");
        productDetail.setProductDetailPrice(30);
        productDetail.setProductDetailQuantity(30);
        productDetail.setSupplyer("productDetailSupplyer_30");
        return productDetail;
    }

    //productImages
    public List<ProductImage> createListProductImages(List<ProductDetail> listProductDetails,int number)
    {
        List<ProductImage> listProductImages = new ArrayList<ProductImage>();
        for(int i = 0 ; i < listProductDetails.size() ; i++)
        {
            for(int j = 0 ; j < number ; j++)
            {
                ProductImage productImage = new ProductImage();
                productImage.setUrl("image_"+i+"-"+j);
                productImage.setProductDetail(listProductDetails.get(i));
                listProductImages.add(productImage);
            }
        }
        return listProductImages;
    }
    public ProductImage createProductImages()
    {
        ProductImage productImage = new ProductImage();
        productImage.setId("productImageId_73");
        productImage.setUrl("image_73");
        return productImage;
    }
}
