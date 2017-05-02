package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvfeibiao
 * @date 下午10:04
 */
@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    @ResponseBody
    public Object index(){
        Map<String,Object> res = new HashMap<>();
        res.put("name", "demo1");
        return res;
    }

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap) {
        LOGGER.error("hello logback...");
        modelMap.put("name", "lvfeibiao");
        return "index";
    }

}
