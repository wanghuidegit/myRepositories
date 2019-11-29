package com.bjsxt;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Administrator
 *
 */
@Component
public class Sender {
	
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	/*
	 * 发送消息的方法
	 */
	public void send(String msg){
		//创建队列发送消息
		//参数1，队列的名称
		//参数2，消息
		this.rabbitAmqpTemplate.convertAndSend("hello-queue", msg);
		
	
		
	}
	
	
	
}
