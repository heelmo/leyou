package com.xunfang.service;

import com.xunfang.Mapper.SpecGroupMapper;
import com.xunfang.Mapper.SpecParamMapper;
import com.xunfang.pojo.SpecGroup;
import com.xunfang.pojo.SpecParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationService {
    @Resource
    private SpecGroupMapper specGroupMapper;
    @Resource
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> queryGroupByCid(Long cid) {

        //创建一个规格组对象 传入cid(规格分组要依照商品分类)
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        //根据传入的cid商品分类id查询规格组对象
        List<SpecGroup> specGroups = specGroupMapper.select(specGroup);
        return specGroups;
    }

    @Transactional
    public void addSpecGroup(SpecGroup specGroup) {
        int result = specGroupMapper.insert(specGroup);
        if (result > 0) {
            System.out.println("添加成功!");
        }
    }

    @Transactional
    public void deleteSpecGroup(Long id) {
        specGroupMapper.deleteByPrimaryKey(id);//通过主键id删除
    }

    @Transactional//事务注解
    public void updateSpecGroup(SpecGroup specGroup) {

        specGroupMapper.updateByPrimaryKeySelective(specGroup);
        ;
    }

    public List<SpecParam> queryParamByGid(Long gid) {
        //根据传入的规格组id查询对应组中的所有规格参数
        //基本信息id  ---组：属性（大小 分辨率 品牌）
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        return specParamMapper.select(specParam);
    }

    //param
    @Transactional
    public void addSpecParam(SpecParam specParam) {
        int result = specParamMapper.insert(specParam);
        if (result > 0) {
            System.out.println("添加成功!");
        }
    }

    @Transactional
    public void deleteSpecParam(Long id) {

        specParamMapper.deleteByPrimaryKey(id);//通过主键id删除

    }

    @Transactional//事务注解
    public void updateSpecParam(SpecParam specParam) {

        specParamMapper.updateByPrimaryKeySelective(specParam);

    }

    public List<SpecParam> queryParamByCid(Long cid){
        //根据传入的规格组id查询对应组中的所有规格参数
        //基本信息:(大小 分辨率,品牌)
        SpecParam specParam = new SpecParam();
        specParam.setCid(cid);
        return specParamMapper.select(specParam);
    }


}
