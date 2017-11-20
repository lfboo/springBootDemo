package com.example.controller;

import com.example.service.DemoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvfeibiao
 * @date 2017/7/24
 */
@Controller
@RequestMapping("/demo")
public class DemoController  implements InitializingBean {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/index")
    @ResponseBody
    public Object index() {
        Map<String, Object> result = new HashMap<>();
        String res = demoService.getMsg("lvfeibiao");
        result.put("result", res);

        return result;
    }

    public DemoController() {
        System.out.println("init construct...");
    }

    @PostConstruct
    private void init() {
        System.out.println("init postconstruct...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterProperties...");
    }
}
