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
//import org.mockito.runners.MockitoJUnitRunner;
//import vn.smartdev.category.dao.entity.Category;
//import vn.smartdev.product.dao.entity.Product;
//import vn.smartdev.product.dao.entity.ProductDetail;
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
//public class ProductDetailServicesImplTest extends HandlingEmulatorData {
//
//    //initialized object
//    //InjecMock : required MockitoJunitRunner create object for variable
//    //set these value for these properties in object mock
//    @InjectMocks
//    private ProductServicesImpl productServices;
//
//    @InjectMocks
//    private ProductDetailServicesImpl productDetailServices;
//
//    @InjectMocks
//    private ProductImageServicesImpl productImageServices;
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
//        //create ListProductDetail
//        List<ProductDetail> listProductDetail = createListProductDetail(listProduct, 3);
//
//        //1.ProductDetail
//        Mockito.when(productDetailRepository.findAll()).thenReturn(listProductDetail);
//
//        //initialized data when getProductDetail
//        Mockito.when(productDetailRepository.findOne("123456789")).thenReturn(createProductDetail(listProduct.get(0)));
//
//        //initialized data when findTop6ByOrderByCreateByDesc()
//
//    }
//
//    @Test
//    public void testGetListProductDetail() throws Exception {
//        List<ProductDetail> listProductDetails = productDetailServices.getListProductDetail();
//        Assertions.assertThat(listProductDetails.size()).isEqualTo(36);
//    }
//
//    @Test
//    public void testGetProductDetail() throws Exception {
//        ProductDetail productDetail = productDetailServices.getProductDetail("123456789");
//        Assertions.assertThat(productDetail.getId()).isEqualTo("123456789");
//        Assertions.assertThat(productDetail.getProductDetailName()).isEqualTo("productDetailName_13");
//        Assertions.assertThat(productDetail.getDescription()).isEqualTo("productDetailDescription_13");
//        Assertions.assertThat(productDetail.getProductDetailQuantity()).isEqualTo(13);
//        Assertions.assertThat(productDetail.getSupplyer()).isEqualTo("productDetailSupplyer_13");
//        Assertions.assertThat(productDetail.getProductDetailQuantity()).isEqualTo(13);
//    }
//
//    @Test
//    public void testGetTotal() throws Exception {
//
//    }
//
//    @Test
//    public void testDeleteProductDetail() throws Exception {
//        //captor in productDetailRepository get Id ProductDetail when implement deleteProductDetail() from server
//        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        productDetailServices.deleteProductDetail("productDetailId_25");
//
//        Mockito.verify(productDetailRepository, Mockito.times(1)).delete(stringArgumentCaptor.capture());
//        String productDetailId = stringArgumentCaptor.getValue();
//
//        Assertions.assertThat(productDetailId).isEqualTo("productDetailId_25");
//    }
//
//    @Test
//    public void testSaveProductDetail() throws Exception {
//        //captor in productDetailRepository get ProductDetail when implement SaveProductDetail() from server
//        ArgumentCaptor<ProductDetail> productDetailArgumentCaptor = ArgumentCaptor.forClass(ProductDetail.class);
//        productDetailServices.saveProductDetail(createProductDetail(createNewProduct()));
//
//        Mockito.verify(productDetailRepository, Mockito.times(1)).save(productDetailArgumentCaptor.capture());
//        ProductDetail productDetail = productDetailArgumentCaptor.getValue();
//
//        Assertions.assertThat(productDetail.getId()).isEqualTo("123456789");
//        Assertions.assertThat(productDetail.getDescription()).isEqualTo("productDetailDescription_13");
//        Assertions.assertThat(productDetail.getProductDetailName()).isEqualTo("productDetailName_13");
//        Assertions.assertThat(productDetail.getProductDetailPrice()).isEqualTo(13);
//        Assertions.assertThat(productDetail.getProductDetailQuantity()).isEqualTo(13);
//        Assertions.assertThat(productDetail.getSupplyer()).isEqualTo("productDetailSupplyer_13");
//    }
//
//    @Test
//    public void testUpdateProductDetail() throws Exception {
//        //captor in productDetailRepository get ProductDetail when implement SaveProductDetail() from server
//        ArgumentCaptor<ProductDetail> productDetailArgumentCaptor = ArgumentCaptor.forClass(ProductDetail.class);
//        productDetailServices.saveProductDetail(createProductDetail(createNewProduct()));
//
//        Mockito.verify(productDetailRepository, Mockito.times(1)).save(productDetailArgumentCaptor.capture());
//        ProductDetail productDetail = productDetailArgumentCaptor.getValue();
//
//        Assertions.assertThat(productDetail.getId()).isEqualTo("123456789");
//        Assertions.assertThat(productDetail.getDescription()).isEqualTo("productDetailDescription_13");
//        Assertions.assertThat(productDetail.getProductDetailName()).isEqualTo("productDetailName_13");
//        Assertions.assertThat(productDetail.getProductDetailPrice()).isEqualTo(13);
//        Assertions.assertThat(productDetail.getProductDetailQuantity()).isEqualTo(13);
//        Assertions.assertThat(productDetail.getSupplyer()).isEqualTo("productDetailSupplyer_13");
//    }
//
//    @Test
//    public void testFindTop6ByOrderByCreateByDesc() throws Exception {
//
//    }
//
//    @Test
//    public void testFindTop6ByOrderByProductDetailPriceDesc() throws Exception {
//
//    }
//
//    @Test
//    public void testFindTop3ByOrderByProductDetailPriceAsc() throws Exception {
//
//    }
//
//    @Test
//    public void testFindTop8ByOrderByCreateByAsc() throws Exception {
//
//    }
//
//    @Test
//    public void testFindByOrderByProductDetailPriceAsc() throws Exception {
//
//    }
//
//    @Test
//    public void testFindByOrderByProductDetailPriceDesc() throws Exception {
//
//    }
//
//    @Test
//    public void testGetListProductDetailByProduct() throws Exception {
//
//    }
//}