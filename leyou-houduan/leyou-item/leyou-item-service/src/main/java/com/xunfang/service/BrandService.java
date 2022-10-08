package com.xunfang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xunfang.Mapper.BrandMapper;
import com.xunfang.common.pojo.PageUtils;
import com.xunfang.pojo.Brand;
import com.xunfang.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandMapper brandMapper;

    public PageUtils<Brand> pageBrand(String key, Integer page, Integer rows, String sortBy, Boolean desc) {

        //分页
        PageHelper.startPage(page, rows);
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if (key != null && !"".equals(key)) {
            criteria.orLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        if (sortBy != null && !"".equals(sortBy)) {
            String sc = desc ? " desc" : " asc";
            String orderStr = sortBy + " " + sc;
            example.setOrderByClause(orderStr);
        }

        //执行查询操作
        List<Brand> brandList = brandMapper.selectByExample(example);

        PageInfo pageInfo = new PageInfo(brandList);

        int total = (int) pageInfo.getTotal();//总条数根据查询结果来

        PageUtils<Brand> pageUtils = new PageUtils<Brand>(total, brandList);


        return pageUtils;
    }


    public void addBrand(Brand brand, List<Long> cids) {
        //1 新增到表中
        brandMapper.insertSelective(brand);
        //brand中没有id
        Long brandId = brand.getId();
        //2 插入到关系表中tb_caregory_brand
        for (Long cid : cids) {
            brandMapper.insertCategoryBrand(cid, brandId);
        }
    }

    public void updateBrand(Brand brand, List<Long> cids) {

        brandMapper.updateByPrimaryKey(brand);
        //删除原有的
        brandMapper.deleteCategoryByBrandId(brand.getId());
        for (Long cid : cids) {
            brandMapper.insertCategoryBrand(cid, brand.getId());
        }
    }

    public void deleteById(Long bid) {
        //删除关联表 tb_category_brand
        brandMapper.deleteCategoryByBrandId(bid);
        //删除品牌
        brandMapper.deleteByPrimaryKey(bid);
    }

    //spu显示品牌
    public List<Brand> getSpuByBrandName(Long cid) {

        List<Brand> SpuByBrandName=brandMapper.getSpuByBrandName(cid);
        return SpuByBrandName;
    }

}
