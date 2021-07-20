package com.liu.esweb.service.impl;

import com.liu.esweb.bean.goods.Goods;
import com.liu.esweb.repository.goods.GoodsRepository;
import com.liu.esweb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    @Qualifier("goodsRepository")
    private GoodsRepository goodsRepository;


    @Override
    public Optional<Goods> findById(String id) {
        //CrudRepository中的方法
        return goodsRepository.findById(id);
    }

    @Override
    public Goods save(Goods blog) {
        return goodsRepository.save(blog);
    }

    @Override
    public void delete(Goods blog) {
        goodsRepository.delete(blog);
    }

    @Override
    public Optional<Goods> findOne(String id) {
        return goodsRepository.findById(id);
    }

    @Override
    public List<Goods> findAll() {
        return (List<Goods>) goodsRepository.findAll();
    }

    @Override
    public Page<Goods> findByAuthor(String author, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Goods> findByTitle(String title, PageRequest pageRequest) {
        return null;
    }

//    @Override
//    public Page<Goods> findByAuthor(String author, PageRequest pageRequest) {
//        return goodsRepository.findByAuthor(author, pageRequest);
//    }
//
//    @Override
//    public Page<Goods> findByTitle(String title, PageRequest pageRequest) {
//        return goodsRepository.findByTitle(title, pageRequest);
//    }
}
