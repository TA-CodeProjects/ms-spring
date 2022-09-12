package com.jb.msserviceb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<String, Map<String, Double>> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, Map<String, Double>> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
