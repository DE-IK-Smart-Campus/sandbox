package hu.deik;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.deik.service.HelloWorldService;

@WebService(serviceName = "helloWorldWS")
public class HelloWorldWS extends SpringBeanAutowiringSupport {

	@Autowired
	private HelloWorldService service;

	@WebMethod
	public String sayHello() {
		return service.sayHello();
	}

	@WebMethod(exclude = true)
	public HelloWorldService getService() {
		return service;
	}

	@WebMethod(exclude = true)
	public void setService(HelloWorldService service) {
		this.service = service;
	}

}
