package hello;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpointConfig;

import org.apache.log4j.Logger;

public class MyContextListener implements ServletContextListener {
	static Logger logger = Logger.getLogger(MyContextListener.class);

	public MyContextListener() {
		System.out.println(Diagnostic.getStackTraceString(MyContextListener.class.getSimpleName()));
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.info("**********************************************");
		logger.info("        Executando contextInitialized   ");
		logger.info("**********************************************\n");
		System.out.println(Diagnostic.getStackTraceString(MyContextListener.class.getSimpleName()));
		ServerContainer serverContainer = (ServerContainer) servletContextEvent.getServletContext()
				.getAttribute("javax.websocket.server.ServerContainer");

		logger.info("defaultMaxSessionIdleTimeout = " + serverContainer.getDefaultMaxSessionIdleTimeout()
				+ ", defaultMaxBinaryMessageBufferSize = " + serverContainer.getDefaultMaxBinaryMessageBufferSize());

		try {
			serverContainer.addEndpoint(ServerEndpointConfig.Builder.create(FSWWebSocketServer.class, "/teste")
					.configurator(new WebSocketServerConfigurator(new FSWWebSocketServer())).build());
		} catch (DeploymentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("**********************************************");
		logger.info("         Executando contextDestroyed   ");
		logger.info("**********************************************\n");
		System.out.println(Diagnostic.getStackTraceString(MyContextListener.class.getSimpleName()));
	}
}
