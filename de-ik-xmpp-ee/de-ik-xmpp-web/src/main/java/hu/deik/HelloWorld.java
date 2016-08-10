package hu.deik;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import hu.deik.core.entity.User;
import hu.deik.service.HelloWorldServiceImpl;
import hu.deik.service.UserService;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private HelloWorldServiceImpl service;

	@Autowired
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorld() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext springContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User saveUser = userService.saveUser(User.builder().username("test").build());
			response.getWriter().append(String.valueOf(saveUser.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append(service.sayHello());
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
