package com.ecommerce.beans;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{

	public CustomEvent(Object source) {
		super(source);		
	}

	@Override
	public String toString() {
		return "This is a custom Event";
	}
	
	

}
