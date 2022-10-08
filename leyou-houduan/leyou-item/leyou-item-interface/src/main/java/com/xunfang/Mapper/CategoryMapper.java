package com.xunfang.Mapper;

import com.xunfang.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface CategoryMapper extends Mapper<Category> {

    @Update("update tb_category set name = #{name} where id =#{id} ")
    public void updateCategoryById(@Param("id") Long id, @Param("name") String name);


    @Select("SELECT *\n" +
            "FROM tb_category_brand tcb LEFT JOIN tb_category tc ON tcb.category_id = tc.id \n" +
            "WHERE tcb.brand_id = #{bid}")
    public List<Category> getCategoryByid(@Param("bid") Long bid);

}
