package com.example.demo3.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "root");
        initParameters.put("loginPassword", "123456");

        initParameters.put("allow","localhost");

        //禁止访问使用方法： initParameters.put("kuangshen", "192.168.11.123");

        bean.setInitParameters(initParameters);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();

        initParameters.put("exclusions", "*.js, *.css, /druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }

}
