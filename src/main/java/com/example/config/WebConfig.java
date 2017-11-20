package com.example.config;

import com.example.filter.DemoFilter;
import com.xxx.rpc.registry.zookeeper.ZooKeeperServiceRegistry;
import com.xxx.rpc.server.RpcServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

/**
 * @author lvfeibiao
 * @date 上午10:17
 */
@Configuration
public class WebConfig {

    @Value("${rpc.service_address}")
    private String serviceAddress;

    @Value("${rpc.registry_address}")
    private String registryAddress;

    @Bean
    public FilterRegistrationBean demoFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DemoFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
