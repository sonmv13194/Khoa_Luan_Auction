package vn.smartdev.producttest;//package vn.smartdev.producttest;
//
//import org.fest.assertions.Assertions;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.stubbing.Answer;
//import vn.smartdev.category.dao.entity.Category;
//import vn.smartdev.product.dao.entity.Product;
//import vn.smartdev.product.dao.entity.ProductDetail;
//import vn.smartdev.product.dao.repository.ProductDetailRepository;
//import vn.smartdev.product.dao.repository.ProductRepository;
//import vn.smartdev.product.manager.ProductDetailServicesImpl;
//import vn.smartdev.product.manager.ProductServicesImpl;
//
//import java.util.List;
//
///**
// * Created by Nhat on 29/11/2016.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class ProductManagerTest extends HandlingEmulatorData{
//
//    //initialized object
//    //InjecMock : required MockitoJunitRunner create object for variable
//    //set these value for these properties in object mock
//
//    @InjectMocks
//    private ProductServicesImpl productServices;
//    @InjectMocks
//    private ProductDetailServicesImpl productDetailServices;
//
//    @Mock
//    private ProductRepository productRepository;
//    @Mock
//    private ProductDetailRepository productDetailRepository;
//
//    @Before
//    public void setUp()
//    {
//        //1.Emulator Category And Product
//        //create listCategory()
//        List<Category> listCategory = listCategory(3);
//        //create object map user emulator data
//        productMap = createProductMap(4,listCategory);
//
//        //initialized emulator data and check getListProduct()
//        Mockito.when(productRepository.findAll()).thenAnswer(new Answer<List<Product>>() {
//            @Override
//            public List<Product> answer(InvocationOnMock invocationOnMock) throws Throwable {
//                //create object listProduct
//                List<Product> listProduct = listProduct(productMap);
//                return listProduct;
//            }
//        });
//
//        //initialized emulartor data and check getProduct()
//        Mockito.when(productRepository.findOne("name_2")).thenReturn(new Product("name_2", "description_2", "category_1"));
//
//        //2.Emulator Product And ProductDetail
//        productDetailMap = createProductDetailMap(4,listCategory);
//
//        //initialized emulator data and check getListProductDetail()
//        Mockito.when(productDetailRepository.findAll()).thenAnswer(new Answer<List<ProductDetail>>() {
//            @Override
//            public List<ProductDetail> answer(InvocationOnMock invocationOnMock) throws Throwable {
//                List<ProductDetail> listProductDetail = listProductDetail(productDetailMap);
//                return listProductDetail;
//            }
//        });
//        //initialized emulator data and check getProduct()
//        Mockito.when(productDetailRepository.findOne("productDetailCode_5")).thenReturn(new ProductDetail("description_5","productDetailCode_5",5*10,5,1,"supplyer_5"));
//
//        //initialized emulator data and check getTotal()
//        Mockito.when(productDetailRepository.findOne("productDetailCode_6")).thenReturn(new ProductDetail("description_6", "productDetailCode_6", 6 * 10, 6, 1, "supplyer_6"));
//    }
//    //Test Product and ProductDetail
//    @Test
//    public void shouldReturn12WhenGetListProduct()
//    {
//        List<Product> listProduct = productServices.getListProduct();
//        Assertions.assertThat(listProduct.size() == 12);
//    }
//    @Test
//    public void shouldReturnName_2WhenGetProduct()
//    {
//        Product product =  productServices.getProduct("name_2");
//        Assertions.assertThat(product.getProductName()).isEqualTo("name_2");
//    }
//
//    @Test
//    public void shouldReturnName_13WhenSaveProduct()
//    {
//        //implement captor data in productRepository ,select product captor send from server,capture this
//        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
//        Product product = new Product("name_13","description_13","category_13");
//        productServices.saveProduct(product);
//
//        Mockito.verify(productRepository,Mockito.times(1)).save(productArgumentCaptor.capture());
//        Product productNew = productArgumentCaptor.getValue();
//        //get Parameter
//        String nameProduct = productNew.getProductName();
//        String description = productNew.getDescription();
//        String categoryId = productNew.getCategory_Id();
//
//        Assertions.assertThat(nameProduct).isEqualTo("name_13");
//        Assertions.assertThat(description).isEqualTo("description_13");
//        Assertions.assertThat(categoryId).isEqualTo("category_13");
//    }
//
//    @Test
//    public void shouldReturnName_11WhenDeleteProduct()
//    {
//        //implement captor data in productRepository,select name captor send from server , capture this
//        ArgumentCaptor<String> productStringNameArgumentCaptor = ArgumentCaptor.forClass(String.class);
//
//        productServices.deleteProduct("name_11");
//        Mockito.verify(productRepository, Mockito.times(1)).delete(productStringNameArgumentCaptor.capture());
//        String nameProduct = productStringNameArgumentCaptor.getValue();
//
//        Assertions.assertThat(nameProduct).isEqualTo("name_11");
//
//
//    }
//    //Test Product and ProductDetail
//    @Test
//    public void shouldReturn12WhenGetListProductDetail()
//    {
//        List<ProductDetail> listProductDetail = productDetailServices.getListProductDetail();
//        Assertions.assertThat(listProductDetail.size() == 13);
//    }
//    //loi~ , tim ra trong ngay mai 29/11/2016
////    @Test
////    public void shouldReturnProductDetailCode_5WhenGetProductDetail()
////    {
////        ProductDetail productDetail = productDetailServices.getProductDetail("productDetailCode_5");
////        Assertions.assertThat(productDetail.getProductDetailCode()).isEqualTo("productDetailCode_5");
////    }
////    @Test
////    public void shouldReturn360WhenGetTotalById()
////    {
////        double actual = productDetailServices.getTotal("productDetailCode_6");
////        Assertions.assertThat(actual).isEqualTo(360);
////
////    }
//}
