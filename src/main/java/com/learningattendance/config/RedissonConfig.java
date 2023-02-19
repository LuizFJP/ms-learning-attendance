package com.learningattendance.config;
import org.springframework.context.annotation.Configuration;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

@Configuration
public class RedissonConfig {
  
  @Bean
  public RedissonClient redissonClient() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://localhost:6379");
    return Redisson.create(config);
  }
}
