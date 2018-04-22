package com.litingfa.service;

import com.litingfa.model.Customer;
import com.litingfa.util.Page;

import java.util.Map;

/**
 * PACKAGE_NAME com.litingfa.service
 * Created by ltfedware on 2017/11/1.
 */
public interface CustomerService {
    Page<Customer> getCustomer(Map<String, Object> dataMap);

    Customer getById(Long id);

    void updateCustomer(Customer customer);

    void delete(Long id);
}
