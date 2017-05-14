package test;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.ServletRequestEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextListener;

import com.yan.servlet.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class RunTest {
	MockServletContext context;
	MockHttpServletRequest request;
	
	
	
	@Autowired
	private UserService loginAction;
	
	
	@Before
	public void before(){
	RequestContextListener listener = new RequestContextListener();
	 context = new MockServletContext();
	 request = new MockHttpServletRequest(context);
	listener.requestInitialized(new ServletRequestEvent(context, request));
	
	}
		@Test
		public void test() throws MalformedURLException{
			String str = request.getSession().getServletContext().getRealPath("/");
			String strUrl = request.getSession().getServletContext().getResource("/").getFile();
			String strPath = request.getRequestURI();
			System.out.println("获取绝对路径："+str);
			System.out.println(strUrl);
			System.out.println(strPath);
		}

}
