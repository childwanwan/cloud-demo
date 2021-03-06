package com.wanpp.learning;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Copyright (C), 2020-2020, 思特奇
 * FileName: SecondServerApplication
 *
 * @Author: wanpp
 * @Date: 2020/1/11 19:44
 * Description:
 * Version: 1.0
 */

@SpringBootApplication
@EnableDiscoveryClient // 开启Eureka客户端
public class SecondServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecondServerApplication.class, args);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }
}
