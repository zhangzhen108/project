package com.project.web;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * Class Name: 类名称
 * Description: 类功能说明
 * Sample（可选）: 该类的典型使用方法和用例
 * Author: zhangzhen
 * Date: 2017/6/21
 */
@Import(FdfsClientConfig.class)
@SpringBootApplication
@ImportResource({"classpath:dubbo/customer/*.xml","classpath:dubbo/*.xml"})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
