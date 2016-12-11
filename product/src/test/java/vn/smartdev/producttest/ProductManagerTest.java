package vn.smartdev.producttest;
import org.aspectj.weaver.ast.Literal;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.repository.ProductDetailRepository;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.dao.repository.ProductRepository;
import vn.smartdev.product.manager.ProductDetailServicesImpl;
import vn.smartdev.product.manager.ProductImageServicesImpl;
import vn.smartdev.product.manager.ProductServicesImpl;

import java.util.List;

/**
 * Created by Nhat on 29/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductManagerTest extends HandlingEmulatorData{

    //initialized object
    //InjecMock : required MockitoJunitRunner create object for variable
    //set these value for these properties in object mock

    @InjectMocks
    private ProductServicesImpl productServices;
    @InjectMocks
    private ProductDetailServicesImpl productDetailServices;
    @InjectMocks
    private ProductImageServicesImpl productImageServices;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductDetailRepository productDetailRepository;
    @Mock
    private ProductImageRepository productImageRepository;

    @Before
    public void setUp()
    {
        //1.Emulator Category And Product
        //create listCategory()
        List<Category> listCategory = createListCategory(3);
        //create object map user emulator data
        productMap = createProductMap(4,listCategory);
        //create ListProduct
        List<Product> listProduct = createListProduct(productMap);
        //create ListProductDetail
        List<ProductDetail> listProductDetail = createListProductDetail(listProduct,3);
        //create ListProductImage
        List<ProductImage> listProductImages = createListProductImages(listProductDetail,2);

        //1.Product

        //initialized emulator data and check getListProduct()
        Mockito.when(productRepository.findAll()).thenAnswer(new Answer<List<Product>>() {
            @Override
            public List<Product> answer(InvocationOnMock invocationOnMock) throws Throwable {
                //create object listProduct
                return listProduct;
            }
        });

        //initialized emulator data and check getOne(String id)
        Mockito.when(productRepository.findOne("name_2")).thenAnswer(new Answer<Product>() {
            @Override
            public Product answer(InvocationOnMock invocationOnMock) throws Throwable {
                Product product = new Product();
                product.setProductName("name_2");
                product.setDescription("description_2");
                return product;
            }
        });

        //2.ProductDetail

        //initialized emulator data and check findAll()
        Mockito.when(productDetailRepository.findAll()).thenReturn(listProductDetail);

        //initialized emulator data and check getOne(String id)
        Mockito.when(productDetailRepository.findOne("productDetailId_30")).thenReturn(createNewProductDetail());

        //3.ProductImage

        //initialized emulator data and check fillAll()
        Mockito.when(productImageRepository.findAll()).thenReturn(listProductImages);

        //initialized emulator dât and check findOne()
        Mockito.when(productImageRepository.findOne("productImageId_73")).thenReturn(createProductImages());
    }

    //1.Test Product

    @Test
    public void shouldReturn12WhenGetListProduct()
    {
        List<Product> listProduct = productServices.getListProduct();
        Assertions.assertThat(listProduct.size()).isEqualTo(12);
    }
    @Test
    public void shouldReturnName_2WhenGetOneProduct()
    {
       Product product = productServices.getProduct("name_2");
       Assertions.assertThat(product.getProductName()).isEqualTo("name_2");
    }


    @Test
    public void shouldReturnName_13WhenSaveProduct()
    {
        //implement captor data in productRepository ,select product captor send from server,capture this
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        Product product = createNewProduct();
        productServices.saveProduct(product);

        Mockito.verify(productRepository,Mockito.times(1)).save(productArgumentCaptor.capture());
        Product productNew = productArgumentCaptor.getValue();
        //get Parameter

        Assertions.assertThat(productNew.getProductName()).isEqualTo("name_13");
        Assertions.assertThat(productNew.getDescription()).isEqualTo("description_13");
    }

    @Test
    public void shouldReturnProductId10WhenDeleteProduct()
    {
        //implement captor data in productRepository ,select id captor send from server
        ArgumentCaptor<String> productArgumentCaptor = ArgumentCaptor.forClass(String.class);
        productServices.deleteProduct("productId_10");

        Mockito.verify(productRepository, Mockito.times(1)).delete(productArgumentCaptor.capture());
        String productId = productArgumentCaptor.getValue();

        Assertions.assertThat(productId).isEqualTo("productId_10");
    }

    //2.Test ProductDetail
    @Test
    public void shouldReturn36WhenGetListProductDetail()
    {
        List<ProductDetail> listProductDetail = productDetailServices.getListProductDetail();
        Assertions.assertThat(listProductDetail.size()).isEqualTo(36);
    }

    @Test
    public void shouldReturnProductDetailCode_30WhenGetProductDetail()
    {
        ProductDetail productDetail = productDetailServices.getProductDetail("productDetailId_30");
        Assertions.assertThat(productDetail.getId()).isEqualTo("productDetailId_30");
    }

    @Test
    public void shouldReturnProductDetail30WhenSaveProduct()
    {
        //captor in productDetailRepository get ProductDetail when implement SaveProductDetail() from server
        ArgumentCaptor<ProductDetail> productDetailArgumentCaptor = ArgumentCaptor.forClass(ProductDetail.class);
        productDetailServices.saveProductDetail(createNewProductDetail());

        Mockito.verify(productDetailRepository,Mockito.times(1)).save(productDetailArgumentCaptor.capture());
        ProductDetail productDetail = productDetailArgumentCaptor.getValue();

        Assertions.assertThat(productDetail.getId()).isEqualTo("productDetailId_30");
        Assertions.assertThat(productDetail.getDescription()).isEqualTo("productDetailDescription_30");
        Assertions.assertThat(productDetail.getProductDetailCode()).isEqualTo("productDetailCode_30");
        Assertions.assertThat(productDetail.getProductDetailPrice()).isEqualTo(30);
        Assertions.assertThat(productDetail.getProductDetailQuantity()).isEqualTo(30);
        Assertions.assertThat(productDetail.getSupplyer()).isEqualTo("productDetailSupplyer_30");
    }

    @Test
    public void shouldReturnProductDetailId_25WhenDeleteProduct()
    {
        //captor in productDetailRepository get Id ProductDetail when implement deleteProductDetail() from server
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        productDetailServices.deleteProductDetail("productDetailId_25");

        Mockito.verify(productDetailRepository, Mockito.times(1)).delete(stringArgumentCaptor.capture());
        String productDetailId = stringArgumentCaptor.getValue();

        Assertions.assertThat(productDetailId).isEqualTo("productDetailId_25");
    }
    @Test
    public void shouldReturn72WhenGetListProducImages()
    {
        List<ProductImage> listProductImages = productImageServices.getListProductImage();
        Assertions.assertThat(listProductImages.size()).isEqualTo(72);
    }

    @Test
    public void shouldReturnUrlImages_73WhenGetOne()
    {
        ProductImage productImage = productImageServices.getProductImage("productImageId_73");
        Assertions.assertThat(productImage.getId()).isEqualTo("productImageId_73");
    }
    @Test
    public void shouldReturnProductImages_73WhenSaveProductImages()
    {
        //captor in productImagesRepository get ProductImages when saveProductImages from server
        ArgumentCaptor<ProductImage> productImageArgumentCaptor = ArgumentCaptor.forClass(ProductImage.class);
        productImageServices.savePorductImage(createProductImages());

        Mockito.verify(productImageRepository,Mockito.times(1)).save(productImageArgumentCaptor.capture());
        ProductImage productImage = productImageArgumentCaptor.getValue();
        Assertions.assertThat(productImage.getId()).isEqualTo("productImageId_73");
        Assertions.assertThat(productImage.getUrl()).isEqualTo("image_73");
    }
    @Test
    public void shouldReturnProductImagesId_74WhenDeleteProductImages()
    {
        //captor in productImagesRepository get ProductImages when saveProductImages from server
        ArgumentCaptor<String> productImageArgumentCaptor = ArgumentCaptor.forClass(String.class);
        productImageServices.deleteProductImage("productImageId_74");

        Mockito.verify(productImageRepository,Mockito.times(1)).delete(productImageArgumentCaptor.capture());
        String productImageId = productImageArgumentCaptor.getValue();
        Assertions.assertThat(productImageId).isEqualTo("productImageId_74");
    }

}
