package vn.smartdev.producttest;//package vn.smartdev.producttest;
//
//import vn.smartdev.category.dao.entity.Category;
//import vn.smartdev.product.dao.entity.Product;
//import vn.smartdev.product.dao.entity.ProductDetail;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Nhat on 29/11/2016.
// */
//public class HandlingEmulatorData {
//    //1.Emulator Product And Category
//
//    //initialized ListCategory()
//    protected List<Category> listCategory(int number)
//    {
//        List<Category> listCategory = new ArrayList<Category>();
//        for(int i = 0 ; i < number ; i++)
//        {
//            Category category = new Category("category_"+i);
//            listCategory.add(category);
//        }
//        return listCategory;
//    }
//
//    //initialized productMap()
//    protected Map<String,Product> productMap = new HashMap<String,Product>();
//
//    //initialized createProductMap()
//        protected Map<String,Product> createProductMap(int number,List<Category> listCategory)
//        {
//            Map<String,Product> createProductMap = new HashMap<String,Product>();
//
//            for(int i = 0 ; i < listCategory.size() ; i++)
//            {
//                for(int j = 0 ; j < number ; j++)
//                {
//                    Product product = new Product("name_"+j,"description_"+j,listCategory.get(i).getCategoryName());
//                    createProductMap.put("productMap_"+j,product);
//                }
//            }
//            return createProductMap;
//    }
//
//    //initialized listProduct()
//    protected List<Product> listProduct(Map<String,Product> createProductMap)
//    {
//        List<Product> listProduct = new ArrayList<Product>();
//        for(int i = 0 ;  i < createProductMap.size() ; i++)
//        {
//            listProduct.add(createProductMap.get("productMap_"+i));
//        }
//        return listProduct;
//    }
//
//    //2.Emulator Product And ProductDetail
//
//    //initialized productMap()
//    protected Map<String,ProductDetail> productDetailMap = new HashMap<String,ProductDetail>();
//
//    protected Map<String,ProductDetail> createProductDetailMap(int number,List<Category> listCategory)
//    {
//        Map<String,ProductDetail> createProductDetailMap = new HashMap<String,ProductDetail>();
//
//        for(int i = 0 ; i < listCategory.size() ; i++)
//        {
//            for(int j = 1 ;  j <= number ; j++)
//            {
//                Product product = new Product("name_"+j,"description_"+j,listCategory.get(i).getCategoryName());
//                ProductDetail productDetail = new ProductDetail("description_"+j,"productDetailCode_"+j,j*10,j,1,"supplyer_"+j);
//                createProductDetailMap.put("productDetailMap_"+j,productDetail);
//            }
//        }
//        return createProductDetailMap;
//    }
//
//    //initialized listProductDetail
//    protected List<ProductDetail> listProductDetail(Map<String,ProductDetail> productDetailMap)
//    {
//        List<ProductDetail> listProductDetail = new ArrayList<>();
//        for(int i = 0 ; i < productDetailMap.size() ; i++)
//        {
//            listProductDetail.add(productDetailMap.get("productDetailMap_"+i));
//        }
//        return listProductDetail;
//    }
//
//}
