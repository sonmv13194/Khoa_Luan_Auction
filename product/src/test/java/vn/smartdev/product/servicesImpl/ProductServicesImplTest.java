//package vn.smartdev.product.servicesImpl;
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
//import vn.smartdev.product.dao.entity.ProductImage;
//import vn.smartdev.product.dao.manager.ProductDetailManagerImpl;
//import vn.smartdev.product.dao.manager.ProductImageManagerImpl;
//import vn.smartdev.product.dao.manager.ProductManagerImpl;
//import vn.smartdev.product.dao.repository.ProductDetailRepository;
//import vn.smartdev.product.dao.repository.ProductImageRepository;
//import vn.smartdev.product.dao.repository.ProductRepository;
//import vn.smartdev.product.handlingData.HandlingEmulatorData;
//
//import java.util.List;
//
///**
// * Created by Nhat on 26/12/2016.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class ProductServicesImplTest extends HandlingEmulatorData {
//
//    //initialized object
//    //InjecMock : required MockitoJunitRunner create object for variable
//    //set these value for these properties in object mock
//    @InjectMocks
//    private ProductManagerImpl productManager;
//
//    @InjectMocks
//    private ProductDetailManagerImpl productDetailManager;
//
//    @InjectMocks
//    private ProductImageManagerImpl productImageManager;
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @Mock
//    private ProductDetailRepository productDetailRepository;
//
//    @Mock
//    private ProductImageRepository productImageRepository;
//
//    @Before
//    public void setUp() throws Exception {
//
//        //1.Emulator Category And Product
//        //create listCategory()
//        List<Category> listCategory = createListCategory(3);
//        //create object map user emulator data
//        productMap = createProductMap(4,listCategory);
//        //create ListProduct
//        List<Product> listProduct = createListProduct(productMap);
//
//        //initialized emulator data and check findAll()
//        Mockito.when(productRepository.findAll()).thenReturn(listProduct);
//
//        //initialized emulator data and check getOne(String id)
//        Mockito.when(productRepository.findOne("name_2")).then(new Answer<Product>() {
//            @Override
//            public Product answer(InvocationOnMock invocationOnMock) throws Throwable {
//                Product product = new Product();
//                product.setProductName("name_2");
//                product.setDescription("description_2");
//                product.setCategory(listCategory.get(0));
//                return product;
//            }
//        });
//
//    }
//
//    @Test
//    public void getListProduct() throws Exception {
//        List<Product> listProduct = productManager.getListProduct();
//        Assertions.assertThat(listProduct.size()).isEqualTo(12);
//
//    }
//
//    @Test
//    public void getProduct() throws Exception {
//        Product product = productManager.getProduct("name_2");
//        Assertions.assertThat(product.getProductName()).isEqualTo("name_2");
//        Assertions.assertThat(product.getDescription()).isEqualTo("description_2");
//        Assertions.assertThat(product.getCategory().getCategoryName()).isEqualTo("category_0");
//    }
//
//    @Test
//    public void saveProduct() throws Exception {
//        //implement captor data in productRepository ,select product captor send from server,capture this
//        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
//        Product product = createNewProduct();
//        productManager.saveProduct(product);
//
//        Mockito.verify(productRepository, Mockito.times(1)).save(productArgumentCaptor.capture());
//        Product productNew = productArgumentCaptor.getValue();
//        //get Parameter
//
//        Assertions.assertThat(productNew.getProductName()).isEqualTo("name_13");
//        Assertions.assertThat(productNew.getDescription()).isEqualTo("description_13");
//    }
//
//    @Test
//    public void deleteProduct() throws Exception {
//        //implement captor data in productRepository ,select id captor send from server
//        ArgumentCaptor<String> productArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        productManager.deleteProduct("productId_10");
//
//        Mockito.verify(productRepository, Mockito.times(1)).delete(productArgumentCaptor.capture());
//        String productId = productArgumentCaptor.getValue();
//
//        Assertions.assertThat(productId).isEqualTo("productId_10");
//    }
//
//    @Test
//    public void createProduct() throws Exception {
//        //implement captor data in productRepository , select data send from server , capture this
//        Product product = createNewProduct();
//        ProductDetail productDetail = createProductDetail(product);
//        ProductImage productImage = createProductImage(productDetail);
//
//        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
//        productManager.saveProduct(product);
//        Mockito.verify(productRepository,Mockito.times(1)).save(productArgumentCaptor.capture());
//        Product productTest = productArgumentCaptor.getValue();
//
//        ArgumentCaptor<ProductDetail> productDetailArgumentCaptor = ArgumentCaptor.forClass(ProductDetail.class);
//        productDetailManager.saveProductDetail(productDetail);
//        Mockito.verify(productDetailRepository,Mockito.times(1)).save(productDetailArgumentCaptor.capture());
//        ProductDetail productDetailTest = productDetailArgumentCaptor.getValue();
//
//        ArgumentCaptor<ProductImage> productImageArgumentCaptor = ArgumentCaptor.forClass(ProductImage.class);
//        productImageManager.saveProductImage(productImage);
//        Mockito.verify(productImageRepository,Mockito.times(1)).save(productImageArgumentCaptor.capture());
//        ProductImage productImageTest = productImageArgumentCaptor.getValue();
//
//
//        //Test
//        Assertions.assertThat(productTest.getProductName()).isEqualTo("name_13");
//        Assertions.assertThat(productTest.getDescription()).isEqualTo("description_13");
//
//        Assertions.assertThat(productDetailTest.getProductDetailName()).isEqualTo("productDetailName_13");
//        Assertions.assertThat(productDetailTest.getDescription()).isEqualTo("productDetailDescription_13");
//        Assertions.assertThat(productDetailTest.getProductDetailPrice()).isEqualTo(13);
//        Assertions.assertThat(productDetailTest.getSupplyer()).isEqualTo("productDetailSupplyer_13");
//        Assertions.assertThat(productDetailTest.getProductDetailQuantity()).isEqualTo(13);
//        Assertions.assertThat(productDetailTest.getProductDetailStatus()).isEqualTo(1);
//        Assertions.assertThat(productDetailTest.getProduct().getProductName()).isEqualTo("name_13");
//
//        Assertions.assertThat(productImageTest.getUrl()).isEqualTo("productImage_13");
//        Assertions.assertThat(productImageTest.getProductDetail().getProductDetailName()).isEqualTo("productDetailName_13");
//
//    }
//}