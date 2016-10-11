package hello;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

public class MyAdditionalListeners extends SpringBootServletInitializer {
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println(Diagnostic.getStackTraceString(MyContextListener.class.getSimpleName()));

		WebApplicationContext rootAppContext = createRootApplicationContext(servletContext);
		if (rootAppContext != null) {
			servletContext.addListener(new MyContextListener());
		} else {
			this.logger.info("• • • • • • No ContextLoaderListener registered, as "
					+ "createRootApplicationContext() did not " + "return an application context");
		}
	}
}
