package com.xunfang.web;

import com.xunfang.pojo.SpecGroup;
import com.xunfang.pojo.SpecParam;
import com.xunfang.service.SpecificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@RequestMapping("spec")

public class SpecificationController {
    @Resource
    private SpecificationService specificationService;

    @RequestMapping("spec/groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid) {

        return ResponseEntity.ok(specificationService.queryGroupByCid(cid));
    }

    //增删改查
    //RequestBody：获取请求传过来的json格式对象
    //RequestParam:获取请求传过来的参数
    //PathVariable:获取路径中传过来的属性
    @PostMapping("spec/group")
    public ResponseEntity<Void> addSpecGroup(@RequestBody SpecGroup specGroup) {
        specificationService.addSpecGroup(specGroup);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
     * 请求方式delete
     *
     * */
    @DeleteMapping("spec/group/{id}")
    public ResponseEntity<Void> deleteSpecGroup(@PathVariable("id") Long id) {

        specificationService.deleteSpecGroup(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("spec/group")
    public ResponseEntity<Void> updateSpecGroup(@RequestBody SpecGroup specGroup) {
        //System.out.println(specGroup.getId()+"   "+specGroup.getName());
        specificationService.updateSpecGroup(specGroup);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
     * 请求方式git
          * */
    @GetMapping("spec/params")
    public ResponseEntity<List<SpecParam>> queryParamByGid(@RequestParam(value = "gid",required = false) Long gid,@RequestParam(value = "cid",required = false) Long cid){
        if(gid!=null)
            return ResponseEntity.ok(specificationService.queryParamByGid(gid));
        else
            return ResponseEntity.ok(specificationService.queryParamByCid(cid));

    }

    @PostMapping("spec/param")
    public ResponseEntity<Void> addSpecParam(@RequestBody SpecParam specParam) {
        specificationService.addSpecParam(specParam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("spec/param/{id}")
    public ResponseEntity<Void> deleteSpecParam(@PathVariable("id") Long id) {

        specificationService.deleteSpecParam(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("spec/param")
    public ResponseEntity<Void> updateSpecParam(@RequestBody SpecParam specParam) {
        specificationService.updateSpecParam(specParam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
