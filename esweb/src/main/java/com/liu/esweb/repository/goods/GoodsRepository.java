package com.liu.esweb.repository.goods;

import com.liu.esweb.bean.goods.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author shengbinliu
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods, String> {
}
