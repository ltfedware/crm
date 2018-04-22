package com.litingfa.mapper;

import com.litingfa.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * PACKAGE_NAME com.litingfa.mapper
 * Created by ltfedware on 2017/10/31.
 */
public interface CustomerMapper {
    List<Customer> getCustomer(Map<String, Object> dataMap);

    Long getCustomerCount(Map<String, Object> dataMap);

    Customer getById(Long id);

    void updateCustomer(Customer customer);

    void delete(Long id);
}
