package com.litingfa.mapper;

import com.litingfa.model.BaseDict;

import java.util.List;

/**
 * PACKAGE_NAME com.litingfa.mapper
 * Created by ltfedware on 2017/11/1.
 */

public interface DictMapper {

    List<BaseDict> getByTypeCode(String s);
}
