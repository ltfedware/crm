package com.litingfa.controller;

import com.litingfa.model.BaseDict;
import com.litingfa.model.Customer;
import com.litingfa.service.CustomerService;
import com.litingfa.service.DictService;
import com.litingfa.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PACKAGE_NAME com.litingfa.controller
 * Created by ltfedware on 2017/10/31.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private DictService dictService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list")
    public String hello(
            @RequestParam(value = "custSource",required = false)String custSource,
            @RequestParam(value = "custName",required = false)String custName,
            @RequestParam(value = "currenpage",required = false,defaultValue = "1")Integer currenpage,
            @RequestParam(value = "custIndustry",required = false)String custIndustry,
            @RequestParam(value = "custLevel",required = false)String custLevel,Model model
    ){
        //查询出对应的条件
        //1、客户来源  dict_type_code=002
        List<BaseDict> fromType = dictService.getByTypeCode("002");
        //2、行业类别 dict_type_code='001'
        List<BaseDict> industryType = dictService.getByTypeCode("001");
        //3、级别 dict_type_code='006'
        List<BaseDict> levelType = dictService.getByTypeCode("006");


        //页面回显
        model.addAttribute("custSource",custSource);
        model.addAttribute("custName",custName);
        model.addAttribute("custIndustry",custIndustry);
        model.addAttribute("custLevel",custLevel);

        //查询customer(根据条件)
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("custName", custName);
        dataMap.put("custSource", custSource);
        dataMap.put("custIndustry", custIndustry);
        dataMap.put("custLevel", custLevel);
        dataMap.put("currenpage", currenpage);

        //分页查询 page
        Page<Customer> page = customerService.getCustomer(dataMap);

        //List<Customer> list = customerService.getCustomer(dataMap);
        /*for (Customer customer : list) {
            System.out.println(customer);

        }*/
        //model.addAttribute("page",list);
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("page",page);
        return "list";
    }

    /****
     * 根据用户ID查询用户信息
     * data:{"id":id},
     * /customer/edit.shtml
     * type:"get",
     * dataType:'json',---Customer
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public Customer edit(@RequestParam(value = "id")Long id){
       Customer customer = customerService.getById(id);
        return customer;
    }

    /***
     * 根据ID修改数据
     * /customer/update.shtml
     * post
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Customer customer){
            customerService.updateCustomer(customer);
        return "ok";

    }

    /***
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam(value="id")Long id){
        customerService.delete(id);
        return "ok";
    }
}
