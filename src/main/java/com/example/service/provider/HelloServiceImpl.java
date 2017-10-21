package com.example.service.provider;

import com.example.api.HelloService;
import com.xxx.rpc.server.RpcService;

/**
 * @author lvfeibiao
 * @date 2017/7/24
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello," + name;
    }
}
