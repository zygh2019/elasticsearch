package com.liu.esweb.service;

import com.liu.esweb.bean.goods.Goods;
import com.liu.esweb.common.pojo.PageReq;
import com.liu.esweb.common.pojo.po.query.goods.GoodsQueryPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface GoodsService {

    Optional<Goods> findById(String id);

    Goods save(Goods blog);

    void delete(Goods blog);

    Optional<Goods> findOne(String id);

    List<Goods> findAll();


    List<Goods> findPage(PageReq<GoodsQueryPO> pageRequest);
}