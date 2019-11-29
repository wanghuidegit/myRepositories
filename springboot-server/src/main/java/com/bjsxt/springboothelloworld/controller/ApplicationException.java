package com.bjsxt.springboothelloworld.controller;

public class ApplicationException extends RuntimeException {
	public ApplicationException(){
		
	}
	
	public ApplicationException(String msg){
		super(msg);
	}
	
	public ApplicationException(String msg,Throwable t){
		super(msg,t);
	}
	
}
