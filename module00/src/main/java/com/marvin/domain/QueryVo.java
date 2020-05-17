
/*
 * @author: marvin
 * @software: IntelliJ IDEA
 * @file: QueryVo.java
 * @time: 2020-05-16 16:19
 */

package com.marvin.domain;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
