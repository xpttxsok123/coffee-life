package com.coffee.life.log.center.consumer;

import com.coffee.life.log.center.service.LogService;
import com.coffee.life.log.constans.LogQueue;
import com.coffee.life.log.entity.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 从mq队列消费日志数据
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 */
@Component
@RabbitListener(queues = LogQueue.LOG_QUEUE) // 监听队列
public class LogConsumer {

	private static final Logger logger = LoggerFactory.getLogger(LogConsumer.class);

	@Autowired
	private LogService logService;

	/**
	 * 处理消息
	 * 
	 * @param log
	 */
	@RabbitHandler
	public void logHandler(Log log) {
		try {
			logService.save(log);
		} catch (Exception e) {
			logger.error("保存日志失败，日志：{}，异常：{}", log, e);
		}

	}
}
