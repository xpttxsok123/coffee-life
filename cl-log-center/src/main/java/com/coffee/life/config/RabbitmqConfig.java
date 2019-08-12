
package com.coffee.life.config;

import com.coffee.life.log.api.constans.LogQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq配置
 */

@Configuration
public class RabbitmqConfig {



    /* 声明队列
     *
     * @return
     */

    @Bean
    public Queue logQueue() {
        Queue queue = new Queue(LogQueue.LOG_QUEUE);

        return queue;
    }
}

