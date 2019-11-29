package com.bjsxt;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者 
 * @author Administrator
 *
 */
@Component 
public class UserSender {
	
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	//exchange 交换器名称
	@Value("${mq.config.exchange}")
	private String excheange;
	
	/*
	 * 发送消息的方法
	 */
	public void send(String msg){
		//创建队列发送消息
		//参数1，交换器名称
		//参数2，路由键
		//参数3，消息
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"user.log.debug","user.log.debug．．．．．．" +msg);
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"user.log.info","user.log.info．．．．．．" +msg);
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"user.log.warn","user.log.debug．．．．．．" +msg);
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"user.log.error","user.log.error．．．．．．" +msg);
		
		
		
	}
}
