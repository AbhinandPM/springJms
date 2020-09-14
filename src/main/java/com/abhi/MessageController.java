package com.abhi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.jms.Queue;

@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private Queue queue;
	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("message/{message}")
	public ResponseEntity<String> publish(@PathVariable("message") final String message) {
		Person person = new Person();
		person.setAge(20);
		person.setName(message);
		
		jmsTemplate.convertAndSend(queue, person);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}