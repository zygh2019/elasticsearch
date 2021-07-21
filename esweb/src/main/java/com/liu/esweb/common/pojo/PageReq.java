package com.liu.esweb.common.pojo;

import lombok.Data;

/**
 * @author 分页公共
 */
@Data
public class PageReq<T> {
    public int page = 1;

    public int size = 10;

    private T queryPO;

}



