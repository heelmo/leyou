package com.xunfang.service;

import com.xunfang.Mapper.CategoryMapper;
import com.xunfang.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static javafx.beans.binding.Bindings.select;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;//封装属性和方法，操作数据库
    public List<Category> listCategoryById(Long pid){

        Category category=new Category();
        category.setParentId(pid);
        List<Category> categoryList=categoryMapper.select(category);
        return categoryList;
    }

    public void addCaategory(Category category) {
        categoryMapper.insert(category);
    }

    public void deleteCategoryByid(Long id) {
        //categoryMapper.deleteByPrimaryKey(id);
        Category category=new Category();
        category.setId(id);
        categoryMapper.delete(category);
    }

    public void updateCategory(Category category) {
        //通过主键更新，除了id、name有值，如果更据
        categoryMapper.updateCategoryById(category.getId(),category.getName());
    }


    public List<Category> getCategoryByBid(Long bid) {
       List<Category>categories= categoryMapper.getCategoryByid(bid);
       return categories;
    }
}
