package com.litingfa.service.impl;

import com.litingfa.mapper.CustomerMapper;
import com.litingfa.model.Customer;
import com.litingfa.service.CustomerService;
import com.litingfa.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * PACKAGE_NAME com.litingfa.service.impl
 * Created by ltfedware on 2017/11/1.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> getCustomer(Map<String, Object> dataMap) {
        //分页信息   当前页
        Integer currentpage = Integer.parseInt(dataMap.get("currenpage").toString());

        //每页显示10条
        Integer size = 10;

        //1、先查询总记录数
        Long count = customerMapper.getCustomerCount(dataMap);
        //第一个参数：总记录数
        //第二个参数：当前页
        //第三个：每页显示多少条
        Page<Customer> page = new Page<>(count,currentpage,size);
        //2、查询集合信息     select * from table limit #{start},#{size}
        int start = (currentpage-1)*size;
        dataMap.put("start",start);
        dataMap.put("size",size);
        List<Customer> customer = customerMapper.getCustomer(dataMap);

        page.setList(customer);
        return page;
    }

    @Override
    public Customer getById(Long id) {
        return customerMapper.getById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void delete(Long id) {
        customerMapper.delete(id);
    }
   /* @Override
    public List<Customer> getCustomer(Map<String, Object> dataMap) {
        return customerMapper.getCustomer(dataMap);
    }*/


}
