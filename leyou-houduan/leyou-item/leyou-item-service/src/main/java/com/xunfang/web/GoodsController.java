package com.xunfang.web;

import com.xunfang.common.pojo.PageUtils;
import com.xunfang.pojo.Sku;
import com.xunfang.pojo.Spu;
import com.xunfang.pojo.SpuDetail;
import com.xunfang.service.GoodsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    /*
     * 查询对应分类下指定的所有商品：分页查询
     * page:当前页
     * rows:每页中的条数
     * saleable：是否下架
     * key:搜索的关键字
     * */
    @RequestMapping("spu/page")
    public ResponseEntity<PageUtils<Spu>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "key", required = false) String key) {
        return ResponseEntity.ok(goodsService.querySpuByPage(page, rows, saleable, key));
    }

    @DeleteMapping("spu/{id}")
    public ResponseEntity<Void> deleteSpu(@PathVariable("id") Long id) {

        goodsService.deleteSpu(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("goods")
    public ResponseEntity<Void> saveSpu(@RequestBody Spu spu) {
        goodsService.saveSpu(spu);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("spu/detail/{id}")
    public ResponseEntity<SpuDetail> querySpuDetailById(@PathVariable("id") Long id) {
        SpuDetail spuDetail = goodsService.querySpuDetailById(id);
        return ResponseEntity.ok(spuDetail);
    }

    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkuById(@RequestParam("id") Long id) {
        List<Sku> skus = goodsService.querySkuById(id);
        return ResponseEntity.ok(skus);
    }

    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody Spu spu) {
        goodsService.update(spu);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
