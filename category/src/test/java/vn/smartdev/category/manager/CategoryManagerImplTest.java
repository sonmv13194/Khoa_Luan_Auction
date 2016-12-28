package vn.smartdev.category.manager;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import vn.smartdev.category.dao.entity.Category;
import vn.smartdev.category.dao.manager.CategoryManagerImpl;
import vn.smartdev.category.dao.repository.CategoryRepository;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by XuanVinh on 12/28/2016.
 */
public class CategoryManagerImplTest {

    @InjectMocks
    CategoryManagerImpl categoryManager;

    @Mock
    CategoryRepository categoryRepository;

    private Map<String, Category> categoryMap;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        categoryMap = PrepareCategory.prepareListCategory(10);

        Mockito.when(categoryRepository.findAll()).thenAnswer(new Answer<List<Category>>() {
            @Override
            public List<Category> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<Category> listCategory = PrepareCategory.getListCategory(categoryMap);
                return listCategory;
            }
        });
        Category category = new Category();
        category.setId("01");
        Mockito.when(categoryRepository.findOne("01")).thenReturn(category);

    }

    @Test
    public void testGetListCategory() throws Exception {
        List<Category> categories = categoryManager.getListCategory();
        Assertions.assertThat(categories.size()).isEqualTo(categoryMap.size());

    }

    @Test
    public void testGetCategory() throws Exception {
        Category category = categoryManager.getCategory("01");
        Assertions.assertThat(category.getId()).isEqualTo("01");

    }

    @Test
    public void testSaveCategory() throws Exception {
        ArgumentCaptor<Category> categoryStringArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        Category category = PrepareCategory.getCategory();
        categoryManager.saveCategory(category);
        Mockito.verify(categoryRepository, Mockito.times(1)).save(categoryStringArgumentCaptor.capture());
        Category categoryCheck = categoryStringArgumentCaptor.getValue();
        Assertions.assertThat(categoryCheck.getId()).isEqualTo("01");

    }

    @Test
    public void testDeleteCategory() throws Exception {
        ArgumentCaptor<String> categoryStringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Category category = PrepareCategory.getCategory();
        categoryManager.deleteCategory(category.getId());
        Mockito.verify(categoryRepository, Mockito.times(1)).delete(categoryStringArgumentCaptor.capture());
        String id = categoryStringArgumentCaptor.getValue();
        Assertions.assertThat(id).isEqualTo("01");
    }
}