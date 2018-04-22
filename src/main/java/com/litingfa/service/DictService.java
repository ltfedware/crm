package com.litingfa.service;

import com.litingfa.model.BaseDict;

import java.util.List;

/**
 * PACKAGE_NAME com.litingfa.service.impl
 * Created by ltfedware on 2017/11/1.
 */
public interface DictService {
    /**
     * 根据typecode查询basedict
     * @param s
     * @return
     */
    List<BaseDict> getByTypeCode(String s);

}
