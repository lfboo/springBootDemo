package com.example.controller;

import com.example.common.dto.ActivityDTO;
import com.example.propertityEditor.MyDateEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvfeibiao
 * @date 下午10:04
 */
@Controller
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Date.class, new MyDateEditor("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("/")
    public String  index(){
        LOGGER.error("[index]");
        return "index";
    }

    @RequestMapping("/process")
    @ResponseBody
    public Object process(ActivityDTO activityDTO) {
        return activityDTO;
    }

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap) {
        LOGGER.error("hello logback...");
        modelMap.put("name", "lvfeibiao");
        return "hello";
    }
}
