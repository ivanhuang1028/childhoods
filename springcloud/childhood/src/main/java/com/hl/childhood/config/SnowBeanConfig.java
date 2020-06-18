package com.hl.childhood.config;

import com.hl.childhood.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowBeanConfig {

    @Bean
    public SnowflakeIdWorker getIdWorker() {
        return new SnowflakeIdWorker(0, 0);
    }
}
