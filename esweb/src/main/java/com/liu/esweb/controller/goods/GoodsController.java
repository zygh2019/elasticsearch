package com.liu.esweb.controller.goods;


import com.liu.esweb.bean.goods.Goods;
import com.liu.esweb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author shengbinliu
 */
@Controller
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

}
