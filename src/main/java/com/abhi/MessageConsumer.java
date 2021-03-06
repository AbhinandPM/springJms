package com.abhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	@JmsListener(destination = "test-queue")
	public void listener(Person person ) {
		logger.info("Message received {} ", person);
	}
}