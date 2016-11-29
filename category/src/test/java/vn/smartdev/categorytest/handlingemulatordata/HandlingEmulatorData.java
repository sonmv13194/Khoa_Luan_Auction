package vn.smartdev.categorytest.handlingemulatordata;

import vn.smartdev.category.dao.entity.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nhat on 28/11/2016.
 */
public class HandlingEmulatorData {
    //initialized new Map be save emulator data
    protected Map<String,Category> categoryMap = new HashMap<String,Category>();

    protected Map<String,Category> createCategoryMap(int number)
    {
       Map<String,Category> createCategoryMap = new HashMap<String,Category>();
        for(int i = 0 ; i < number ; i++)
        {
            Category category = new Category("category_"+i);
            createCategoryMap.put("categoryMap_"+i,category);
        }
        return createCategoryMap;
    }

    protected List<Category> getListCategory(Map<String,Category> categoryMap)
    {
        List<Category> listCategory = new ArrayList<Category>();
        for(int i = 0 ; i < categoryMap.size() ; i++)
        {
            listCategory.add(categoryMap.get("categoryMap_"+i));
        }
        return listCategory;
    }
}
