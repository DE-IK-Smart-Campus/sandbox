package hu.deik.service;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String sayHello() {
		return "Hello!";
	}
}
