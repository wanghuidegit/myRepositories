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
public class ProductSender {
	
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
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"product.log.debug","product.log.debug．．．．．．" +msg);
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"product.log.info","product.log.info．．．．．．" +msg);
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"product.log.warn","product.log.debug．．．．．．" +msg);
		this.rabbitAmqpTemplate.convertAndSend(this.excheange,"product.log.error","product.log.error．．．．．．" +msg);
		
		
		
	}
}
