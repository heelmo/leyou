package com.xunfang.Mapper;

import com.xunfang.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {

    @Insert("INSERT INTO tb_category_brand (category_id,brand_id) VALUES(#{cid},#{brandId})")
    public void insertCategoryBrand(@Param("cid") Long cid,@Param("brandId") Long brandId);

    @Delete("DELETE FROM tb_category_brand WHERE brand_id=#{bid}")
    public void deleteCategoryByBrandId(@Param("bid") Long bid);

    //spu显示
    @Select("select tc.* from tb_category_brand tcb left join tb_brand tc on tcb.brand_id = tc.id where tcb.category_id = #{cid}")
    List<Brand> getSpuByBrandName(Long cid);

}
