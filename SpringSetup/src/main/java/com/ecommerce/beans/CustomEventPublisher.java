package com.ecommerce.beans;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware{
	private ApplicationEventPublisher someRandomPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.someRandomPublisher = applicationEventPublisher;
		
	}
	
	public void publish()
	{
		CustomEvent ce = new CustomEvent(this);
		someRandomPublisher.publishEvent(ce);
	}

}
