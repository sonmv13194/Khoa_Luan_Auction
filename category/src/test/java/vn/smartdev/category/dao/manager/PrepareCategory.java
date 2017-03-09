package vn.smartdev.category.dao.manager;

import vn.smartdev.category.dao.entity.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XuanVinh on 12/27/2016.
 */
public class PrepareCategory {
    //protected Map<String, Category> categoryMap = new HashMap<String, Category>();

    public static Map<String, Category> prepareListCategory(int number){
        Map<String, Category> preparecategory = new HashMap<String, Category>();
        for (int i=0; i<number; i++)
        {
            Category category = new Category();
            category.setId("category" + i);
            category.setCategoryName("category of" + i);
            preparecategory.put("categoryMap" + i,category);
        }
        return preparecategory;
    }

    public static List<Category> getListCategory(Map<String, Category> categoryMap)
    {
        List<Category> categories = new ArrayList<Category>();
        for (int i=0; i<categoryMap.size(); i++){
            categories.add(categoryMap.get("categoryMap" + i));
        }
        return categories;
    }

    public static Category getCategory(){
        Category category = new Category();
        category.setId("01");
        category.setCategoryName("abc");
        return category;
    }

    public static Category prepareCategory()
    {
        Category category = new Category();
        category.setId("01");
        category.setCategoryName("abc");
        return category;
    }
}
