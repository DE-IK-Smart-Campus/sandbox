package hu.deik.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.spring.integration.test.annotation.SpringConfiguration;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import hu.deik.service.HelloWorldService;
import hu.deik.service.HelloWorldServiceImpl;

@RunWith(Arquillian.class)
@SpringConfiguration("spring-service.xml")
public class HelloWorldServiceTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClasses(HelloWorldService.class, HelloWorldServiceImpl.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Autowired
	private HelloWorldService helloWorldService;

	@Test
	public void testIfServiceInjected() {
		Assert.assertNotNull(helloWorldService);
	}

	@Test
	public void testServiceSayHello() {
		Assert.assertEquals("Hello!", helloWorldService.sayHello());
	}

}
