package com.xunfang.web;


import com.xunfang.pojo.Category;
import com.xunfang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @RequestMapping("list")
    public ResponseEntity<List<Category>> lisCategoryById(@RequestParam("pid") Long pid){
        List<Category> categoryList=categoryService.listCategoryById(pid);
        return ResponseEntity.ok(categoryList);
    }
    @PostMapping("add")
    public void addCategory(@RequestBody Category category){
        categoryService.addCaategory(category);
    }
    @GetMapping("delete")
    public void deleteCategory(@RequestParam("id")Long id){

        categoryService.deleteCategoryByid(id);
    }

    @PostMapping("edit")
    public  void updateCategoryById(@RequestBody Category category){
        System.out.println(category.getId()+"   "+category.getName());
        categoryService.updateCategory(category);

    }

    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> getCategoryByBrandId(@PathVariable("bid")Long bid){

        System.out.println(bid);
        //通过brangId拿到categoryId 通过categoryIds查询对应的列表 关联查询
        //tb_category_brand tb_
        return ResponseEntity.ok(categoryService.getCategoryByBid(bid));
    }
}
