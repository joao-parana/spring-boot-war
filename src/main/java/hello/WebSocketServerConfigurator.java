package hello;

import javax.websocket.server.ServerEndpointConfig;

public class WebSocketServerConfigurator extends ServerEndpointConfig.Configurator {

	private Object server;

	public WebSocketServerConfigurator(Object server) {
		super();
		this.server = server;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {

		T instance = null;

		if (endpointClass.equals(Object.class)) {
			instance = (T) server;
		}

		return instance;
	}
}