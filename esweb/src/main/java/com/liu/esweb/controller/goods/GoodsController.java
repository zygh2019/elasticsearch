package com.liu.esweb.controller.goods;


import com.liu.esweb.bean.goods.Goods;
import com.liu.esweb.common.pojo.PageReq;
import com.liu.esweb.common.pojo.po.query.goods.GoodsQueryPO;
import com.liu.esweb.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author shengbinliu
 */
@RestController
@Api(value = "GoodsController", tags = "测试-es测试")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("/goods/{id}")
    @ApiOperation(value = "id查询")
    public Goods getBookById(@PathVariable String id){
        Optional<Goods> opt =goodsService.findById(id);
        Goods book=opt.get();
        System.out.println(book);
        return book;
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public void save(){
        Goods book=new Goods("2","黑人膏","黑人膏",1.1,1);
        System.out.println(book);
        goodsService.save(book);
    }
    @PostMapping("/findAll")
    @ApiOperation(value = "找到所有")
    public List<Goods> findAll(){

        return goodsService.findAll();
    }


    @PostMapping("/findPage")
    @ApiOperation(value = "分页")
    public List<Goods> findPage(@RequestBody  PageReq<GoodsQueryPO> pageRequest){

        return goodsService.findPage(pageRequest);
    }
}
