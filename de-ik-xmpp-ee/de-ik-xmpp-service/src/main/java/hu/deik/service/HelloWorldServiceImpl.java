package hu.deik.service;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldService {
	public String sayHello() {
		return "Hello!";
	}
}
