package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocket
public class MyConfiguration implements WebSocketConfigurer {
	// @Bean
	public MyContextListener executorListener() {
		return null; // new MyContextListener();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		System.out.println("••• registerWebSocketHandlers Invocado •••");
		registry.addHandler(myHandler(), "/teste");
	}

	@Bean
	public WebSocketHandler myHandler() {
		return new MyHandler();
	}
}

class MyHandler extends TextWebSocketHandler {
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		System.out.println(message.getPayload().toString());
	}

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		WebSocketMessage<String> message = new TextMessage("Oi Mundo cruel");
		session.sendMessage(message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Close invocado " + status);
	}
}
