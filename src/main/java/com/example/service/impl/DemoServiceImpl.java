package com.example.service.impl;

import com.example.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author lvfeibiao
 * @date 2017/10/24
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getMsg(String name) {
        return name + " demo";
    }
}
