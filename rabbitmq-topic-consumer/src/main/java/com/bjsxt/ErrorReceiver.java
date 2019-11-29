package com.bjsxt;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.http.client.domain.ExchangeType;

/**
 * 消息接受者
 * @author Administrator
 *@RabbitListener bindings:绑定队列
 *					
 *					
 *@QueueBinding value:绑定队列名称
 *				exchange:配置交换器
 *
 *@Queue value：配置队列名称
 *		 autoDelete:是否是可删除的临时队列
 */ 
@Component
@RabbitListener(
		 	bindings=@QueueBinding(
		 		value=@Queue(value="${mq.config.queue.error}",autoDelete="true"),	
		 		exchange=@Exchange(value="${mq.config.exchange}",type=ExchangeTypes.TOPIC),
		 		key="*.log.error"
		 	)
		)
public class ErrorReceiver {
	
	/**
	 * 接收消息的方法，采用消息队列监听机制
	 * @param msg
	 */
	@RabbitHandler
	public void process(String msg){
		System.out.println("...Error..........receiver: " + msg);
	}
}
