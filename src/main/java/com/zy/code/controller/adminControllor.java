package com.zy.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminControllor extends BaseControllor {

    @GetMapping(value = "/saveUser")
    public String saveUser(){
        return "success";
    }

}
