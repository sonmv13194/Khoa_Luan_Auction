package vn.smartdev.product.servicesImpl;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.product.dao.entity.Product;
import vn.smartdev.product.dao.entity.ProductDetail;
import vn.smartdev.product.dao.entity.ProductImage;
import vn.smartdev.product.dao.repository.ProductImageRepository;
import vn.smartdev.product.handlingData.HandlingEmulatorData;

import java.util.List;

/**
 * Created by Nhat on 26/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductImageServicesImplTest extends HandlingEmulatorData {
    //initialized object
    //InjecMock : required MockitoJunitRunner create object for variable
    //set these value for these properties in object mock

    @InjectMocks
    private ProductImageServicesImpl productImageServices;

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
        List<ProductImage> listProductImages = createListProductImages(listProductDetail, 2);


        //3.ProductImage

        //initialized emulator data and check fillAll()
        Mockito.when(productImageRepository.findAll()).thenReturn(listProductImages);

        //initialized emulator dât and check findOne()
        Mockito.when(productImageRepository.findOne("productImageId_73")).thenReturn(createProductImages());

    }


    @Test
    public void testGetListProductImage() throws Exception {
        List<ProductImage> listProductImages = productImageServices.getListProductImage();
        Assertions.assertThat(listProductImages.size()).isEqualTo(72);
    }

    @Test
    public void testGetProductImage() throws Exception {
        ProductImage productImage = productImageServices.getProductImage("productImageId_73");
        Assertions.assertThat(productImage.getId()).isEqualTo("productImageId_73");
    }

    @Test
    public void testSavePorductImage() throws Exception {
        //captor in productImagesRepository get ProductImages when saveProductImages from server
        ArgumentCaptor<ProductImage> productImageArgumentCaptor = ArgumentCaptor.forClass(ProductImage.class);
        productImageServices.savePorductImage(createProductImages());

        Mockito.verify(productImageRepository,Mockito.times(1)).save(productImageArgumentCaptor.capture());
        ProductImage productImage = productImageArgumentCaptor.getValue();
        Assertions.assertThat(productImage.getId()).isEqualTo("productImageId_73");
        Assertions.assertThat(productImage.getUrl()).isEqualTo("image_73");
    }

    @Test
    public void testDeleteProductImage() throws Exception {
        //captor in productImagesRepository get ProductImages when saveProductImages from server
        ArgumentCaptor<String> productImageArgumentCaptor = ArgumentCaptor.forClass(String.class);
        productImageServices.deleteProductImage("productImageId_74");

        Mockito.verify(productImageRepository,Mockito.times(1)).delete(productImageArgumentCaptor.capture());
        String productImageId = productImageArgumentCaptor.getValue();
        Assertions.assertThat(productImageId).isEqualTo("productImageId_74");
    }

    @Test
    public void testUploadFile() throws Exception {

    }
}