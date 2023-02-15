package com.learningattendance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class JedisConfig {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
    return new JedisConnectionFactory(config);
  }
}