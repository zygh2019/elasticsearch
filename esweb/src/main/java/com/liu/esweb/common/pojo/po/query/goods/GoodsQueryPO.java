package com.liu.esweb.common.pojo.po.query.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author shengbinliu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "GoodsQueryPO")
@Accessors(chain = true)
public class GoodsQueryPO {
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "介绍")
    private String introduce;
    @ApiModelProperty(value = "价格")
    private Double price;
    @ApiModelProperty(value = "数量")
    private Integer count;




}
