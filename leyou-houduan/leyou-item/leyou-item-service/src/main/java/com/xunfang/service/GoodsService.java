package com.xunfang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xunfang.Mapper.*;
import com.xunfang.common.pojo.PageUtils;
import com.xunfang.pojo.Sku;
import com.xunfang.pojo.Spu;
import com.xunfang.pojo.SpuDetail;
import com.xunfang.pojo.Stock;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    @Resource
    private SpuMapper spuMapper;
    @Resource
    private SpuDetailMapper spuDetailMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private BrandMapper brandMapper;
    @Resource
    private SkuMapper skuMapper;
    @Resource
    private StockMapper stockMapper;

    public PageUtils<Spu> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key) {
        //分页
        PageHelper.startPage(page, rows);
        //创建spu实体类的通用mybatis对象
        Example example = new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        //判断关键字搜索关键字
        if (StringUtils.isNotBlank(key)) {
            //添加关键字条件查询 模糊查询 like title %k%
            criteria.andLike("title", "%" + key + "%");
        }
        //上下架过滤
        if (saleable != null) {
            criteria.andEqualTo("saleable", saleable);
        }
        //根据时间默认排序
        example.setOrderByClause("last_update_time DESC");
        //查询
        List<Spu> spus = spuMapper.selectByExample(example);
        //解析分类和品牌的名字
        loadCategoryAndBrandName(spus);
        //解析分页的结果
        PageInfo<Spu> info = new PageInfo<>(spus);
        return new PageUtils<Spu>((int) info.getTotal(), info.getList());

    }

    public void loadCategoryAndBrandName(List<Spu> spus) {
        //根据遍历得到每个商品得到分类名和品牌名
        //brandMapper.selectByPrimaryKey(spu.getBrandId()).getName()：是一个完整的分类对象
        //现在只需要名称
        for (Spu spu : spus) {
            //根据品牌id查询名称
            spu.setBname(brandMapper.selectByPrimaryKey(spu.getBrandId()).getName());
            //根据分类id查询到分类的名称
            spu.setCname(
                    // 手机/手机通讯/手机
                    categoryMapper.selectByPrimaryKey(spu.getCid1()).getName() + "/" +
                            categoryMapper.selectByPrimaryKey(spu.getCid2()).getName() + "/" +
                            categoryMapper.selectByPrimaryKey(spu.getCid3()).getName());

        }
    }

    public void deleteSpu(Long id) {
        spuMapper.deleteByPrimaryKey(id);//通过主键id删除
        spuDetailMapper.deleteByPrimaryKey(id);
        stockMapper.deleteByPrimaryKey(id);
        skuMapper.deleteByPrimaryKey(id);
    }

    @Transactional//事务注解，增删改查要写
    public void saveSpu(Spu spu) {

        //增加Spu表中的内容
        //spu.setId(null);
        spu.setValid(true);//是否有效
        spu.setSaleable(true);//上架
        spu.setCreateTime(new Date());//创建时间为系统时间
        spu.setLastUpdateTime(spu.getCreateTime());//更新时间为当时时间
        //新增spu
        int count = spuMapper.insert(spu);
        if (count >= 1) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }

        //增加SpuDetali的内容
        SpuDetail spuDetail = spu.getSpuDetail();
        spuDetail.setSpuId(spu.getId());//根据数据库可知 spuDetail中的spu_id就是spu表中的
        //spuDetailMapper.insertSelective(spuDetail);
        spuDetailMapper.insert(spuDetail);
        //增加sku stock中的内容
        List<Sku> skus = spu.getSkus();
        for (Sku sku : skus) {
            //新增sku
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(sku.getCreateTime());
            sku.setSpuId(spu.getId());
            //新增sku
            //skuMapper.insertSelective(sku);
            int num = skuMapper.insert(sku);
            if (num >= 1) {
                System.out.println("添加成功！");
            }
            //新增库存信息
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            //stockMapper.insertSelective(stock);
            stockMapper.insert(stock);

        }
    }

    //数据回显spudetail
    public SpuDetail querySpuDetailById(Long id) {
        return spuDetailMapper.selectByPrimaryKey(id);
    }

    //数据回显sku
    public List<Sku> querySkuById(Long spuId) {
        Sku sku = new Sku();
        sku.setSpuId(spuId);
        List<Sku> skuList = this.skuMapper.select(sku);
        skuList.forEach(sku1 -> {
            Stock stock = new Stock();
            stock.setSkuId(sku1.getId());
            Stock stock1 = this.stockMapper.selectByPrimaryKey(stock);
            sku1.setStock(stock1.getStock());
        });
        return skuList;
    }

    @Transient
    public void update(Spu spu) {
        // 查询以前sku
        List<Sku> skus = querySkuById(spu.getId());
        // 如果以前存在，则删除
        if (!CollectionUtils.isEmpty(skus)) {
            List<Long> ids = skus.stream().map(s -> s.getId()).collect(Collectors.toList());
            // 删除以前库存
            Example example = new Example(Stock.class);
            example.createCriteria().andIn("skuId", ids);
            this.stockMapper.deleteByExample(example);

            // 删除以前的sku
            Sku record = new Sku();
            record.setSpuId(spu.getId());
            skuMapper.delete(record);

        }
        // 新增sku和库存
        List<Sku> skus1 = spu.getSkus();
        for (Sku sku : skus1) {
            //新增sku
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(sku.getCreateTime());
            sku.setSpuId(spu.getId());
            skuMapper.insertSelective(sku);

            //新增库存信息
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            stockMapper.insertSelective(stock);
        }
        // 更新spu
        spu.setLastUpdateTime(new Date());
        spu.setCreateTime(null);
        spu.setValid(null);
        spu.setSaleable(null);
        spuMapper.updateByPrimaryKeySelective(spu);
        // 更新spu详情
        spuDetailMapper.updateByPrimaryKeySelective(spu.getSpuDetail());
    }

}
