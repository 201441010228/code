package com.zy.code.controller;

import com.zy.code.entity.User;
import com.zy.code.utils.ProcessResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexControllor extends BaseControllor{


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ProcessResult index(){
        ProcessResult processResult = new ProcessResult();
        processResult.getData().put("name","乌尔沙");
        setReturnProcessResult(processResult);
        return processResult;
    }


}
