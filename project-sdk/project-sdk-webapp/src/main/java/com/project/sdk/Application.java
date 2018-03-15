package com.project.sdk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Class Name: 类名称
 * Description: 类功能说明
 * Sample（可选）: 该类的典型使用方法和用例
 * Author: zhangzhen
 * Date: 2017/6/21
 */
@SpringBootApplication
@ServletComponentScan
@ImportResource({"classpath:dubbo/provider/*.xml","classpath:dubbo/*.xml"})
@MapperScan("com.project.sdk.mapper")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
