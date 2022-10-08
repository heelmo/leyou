package com.xunfang.web;

import com.xunfang.common.pojo.PageUtils;
import com.xunfang.pojo.Brand;
import com.xunfang.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
key 关键字，page
先写pojo数据传输对象
mapper 数据访问对象
seriver 服务
controller 控制器
SELECT * FROM `tb_brand` LIMIT 0, 1000
select * form tb_brand where name like '%key' or letter = 'key' limit
*/
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    //前端接受{item，total} 分页信息
    @RequestMapping("page")
    public ResponseEntity<PageUtils<Brand>> pageBrand(@RequestParam(value = "key", required = false) String key,
                                                      @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                      @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                                                      @RequestParam(value = "sortBy", required = false) String sortBy,
                                                      @RequestParam(value = "desc", required = false) Boolean desc) {
        PageUtils<Brand> brandList = brandService.pageBrand(key, page, rows, sortBy, desc);
        return ResponseEntity.ok(brandList);
    }

    //编辑操作：将编辑的对象回显到页面
    //删除操作：拿到id，删除品牌，分类，关系表也要删除
    //http://api.leyou.com/api/item/category/bid/1528
    //brand表id
    /*
     * 请求方法
     *
     *
     * */

    @PostMapping
    public void addBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        System.out.println(brand);
        System.out.println(cids);
        brandService.addBrand(brand, cids);
    }

    @PutMapping
    public void updateBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        System.out.println(brand);//更新brand
        System.out.println(cids);//删除原有的，新增新的
        brandService.updateBrand(brand, cids);
    }

    @DeleteMapping("{bid}")
    public void deletBrandById(@PathVariable("bid") Long bid) {
        brandService.deleteById(bid);
    }

    //spu商品显示
    @GetMapping("cid/{cid}")
    public List<Brand> getSpuByBrandName(@PathVariable("cid") Long cid) {
        List<Brand> brandByCid = brandService.getSpuByBrandName(cid);
        for (Brand brand :
                brandByCid) {
            //System.out.println(brand);
        }
        return brandByCid;
    }

}
