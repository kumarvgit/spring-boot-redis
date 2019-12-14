package org.self.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.UUID;

@Configuration
@ComponentScan("org.self.springbootredis")
public class RedisConfig {

    @Bean

    JedisConnectionFactory jedisConnectionFactory() {

        return new JedisConnectionFactory();

    }

    @Bean

    public RedisTemplate<UUID, Object> redisTemplate() {

        final RedisTemplate<UUID, Object> template = new RedisTemplate<UUID, Object>();

        template.setConnectionFactory(jedisConnectionFactory());

        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));

        return template;

    }
}
