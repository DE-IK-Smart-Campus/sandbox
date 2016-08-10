package hu.deik;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.deik.service.HelloWorldServiceImpl;

@WebService(serviceName = "helloWorldWS")
public class HelloWorldWS extends SpringBeanAutowiringSupport {

	@Autowired
	private HelloWorldServiceImpl service;

	@WebMethod
	public String sayHello() {
		return service.sayHello();
	}

	@WebMethod(exclude = true)
	public HelloWorldServiceImpl getService() {
		return service;
	}

	@WebMethod(exclude = true)
	public void setService(HelloWorldServiceImpl service) {
		this.service = service;
	}

}
