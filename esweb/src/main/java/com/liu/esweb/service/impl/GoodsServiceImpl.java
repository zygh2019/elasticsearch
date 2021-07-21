package com.liu.esweb.service.impl;

import com.liu.esweb.bean.goods.Goods;
import com.liu.esweb.common.pojo.PageReq;
import com.liu.esweb.common.pojo.po.query.goods.GoodsQueryPO;
import com.liu.esweb.repository.goods.GoodsRepository;
import com.liu.esweb.service.GoodsService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    @Qualifier("goodsRepository")
    private GoodsRepository goodsRepository;
    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

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
        Iterable<Goods> all = goodsRepository.findAll();
        List<Goods> copy = new ArrayList<>();
        all.forEach(o -> copy.add(o));
        return copy;
    }


    @Override
    public List<Goods> findPage(PageReq<GoodsQueryPO> pageReq) {
        GoodsQueryPO queryPO = pageReq.getQueryPO();
        if (Objects.isNull(queryPO)) {
        }

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //模糊查询

        boolQueryBuilder.filter(QueryBuilders.termQuery("name", queryPO.getName()));
        PageRequest pageRequest = PageRequest.of(pageReq.getPage() - 1, pageReq.getSize());
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(pageRequest).build();
        SearchHits<Goods> search = elasticsearchRestTemplate.search(searchQuery, Goods.class);
        return search.stream().map(goodsSearchHit -> {
            return goodsSearchHit.getContent();
        }).collect(Collectors.toList());
    }

}
