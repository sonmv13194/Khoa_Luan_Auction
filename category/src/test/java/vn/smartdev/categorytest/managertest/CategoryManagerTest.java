package vn.smartdev.categorytest.managertest;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.repository.CategoryRepository;
import vn.smartdev.category.manager.servicesImpl.CategoryServicesImpl;
import vn.smartdev.categorytest.handlingemulatordata.HandlingEmulatorData;

import java.util.List;

/**
 * Created by Nhat on 28/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryManagerTest extends HandlingEmulatorData{
    //initialized new object test
    //@InjecMock : required MockitoJunitRunner create object for variable
    //set these value for these properties object Moc

    //initialized object emulator data
    @InjectMocks
    private CategoryServicesImpl categoryServices;

    //initialized object need test
    @Mock
    private CategoryRepository categoryRepository;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        //create object map user emulator inside database
        categoryMap = createCategoryMap(4);

        //implement emulator data and getListCategory()
        Mockito.when(categoryRepository.findAll()).thenAnswer(new Answer<List<Category>>() {
            @Override
            public List<Category> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<Category> listCategory = getListCategory(categoryMap);
                return listCategory;
            }
        });

        //implement emulator data and getCategory()
        Mockito.when(categoryRepository.findOne("category_2")).thenReturn(new Category("category_2"));

    }

    @Test
    public void shouldReturn4WhenGetListCategory()
    {
        List<Category> listCategory = categoryServices.getListCategory();
        Assertions.assertThat(listCategory.size()).isEqualTo(4);
    }

    @Test
    public void shouldReturnCategory_2WhenGetCategoryByName()
    {
        Category category = categoryServices.getCategory("category_2");
        Assertions.assertThat(category.getCategoryName()).isEqualTo("category_2");
    }

    @Test
    public void shouldReturnCategory_3WhenDeleteCategory()
    {
        //implement emulator data and deleteCategory()
        ArgumentCaptor<String> categoryNameStringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        categoryServices.deleteCategory("category_3");

        Mockito.verify(categoryRepository, Mockito.times(1)).delete(categoryNameStringArgumentCaptor.capture());
        String categoryName = categoryNameStringArgumentCaptor.getValue();

        Assertions.assertThat(categoryName).isEqualTo("category_3");
    }

    @Test
    public void shouldReturnCategory_5WhenSaveCategory()
    {
        //implement captor data in categoryRepository , select name captor send form server , capture this
        ArgumentCaptor<Category> categoryNameStringArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        Category category = new Category("category_5");
        categoryServices.saveCategory(category);

        Mockito.verify(categoryRepository,Mockito.times(1)).save(categoryNameStringArgumentCaptor.capture());
        Category categoryNew = categoryNameStringArgumentCaptor.getValue();
        String categoryName = categoryNew.getCategoryName();

        Assertions.assertThat(categoryName).isEqualTo("category_5");
    }
}


