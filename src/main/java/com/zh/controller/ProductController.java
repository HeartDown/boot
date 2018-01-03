package com.zh.controller;

import com.zh.dao.ProductRepository;
import com.zh.dao.UserRepository;
import com.zh.model.Product;
import com.zh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangheng on 2017/12/11.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id){
        Product findOne = this.productRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/product/getList")
    public List hello(){
        List allList = this.productRepository.findAll();
        return allList;
    }

    @PostMapping("/getByParme")
    public Product findByParme(@RequestBody Map<String,Object> reqMap){
        List products = this.productRepository.findAll();
        return null;
    }
}
