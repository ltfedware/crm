package com.litingfa.service.impl;

import com.litingfa.mapper.CustomerMapper;
import com.litingfa.mapper.DictMapper;
import com.litingfa.model.BaseDict;
import com.litingfa.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PACKAGE_NAME com.litingfa.service.impl
 * Created by ltfedware on 2017/11/1.
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<BaseDict> getByTypeCode(String s) {

        return dictMapper.getByTypeCode(s);
    }
}
