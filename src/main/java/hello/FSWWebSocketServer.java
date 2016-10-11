package hello;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class FSWWebSocketServer extends Endpoint {

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		MessageHandler.Whole<String> x = y -> {
			System.out.println(y);
		};
		session.addMessageHandler(x);
		try {
			session.getBasicRemote().sendText("Oi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// serviceDefiniton.onConnection(session, tracker);
	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		// serviceDefiniton.onClose(session, closeReason);
	}
}
