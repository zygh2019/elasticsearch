package com.liu.esweb.controller.goods;


import com.liu.esweb.bean.goods.Goods;
import com.liu.esweb.common.pojo.PageReq;
import com.liu.esweb.common.pojo.po.query.goods.GoodsQueryPO;
import com.liu.esweb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author shengbinliu
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/goods/{id}")
    @ResponseBody
    public Goods getBookById(@PathVariable String id){
        Optional<Goods> opt =goodsService.findById(id);
        Goods book=opt.get();
        System.out.println(book);
        return book;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(){
        Goods book=new Goods("1","黑人牙膏","黑人牙膏",1.1,1);
        System.out.println(book);
        goodsService.save(book);
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Goods> findAll(){

        return goodsService.findAll();
    }


    @RequestMapping("/findPage")
    @ResponseBody
    public List<Goods> findPage(PageReq<GoodsQueryPO> pageRequest){

        return goodsService.findPage(pageRequest);
    }
}
