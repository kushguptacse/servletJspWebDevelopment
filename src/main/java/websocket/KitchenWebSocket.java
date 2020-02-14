package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/kitchenManagement")
public class KitchenWebSocket {

	@OnOpen
	public void open(Session session) {
		KitchenDisplaySessionHandler.getInstance().addSession(session);
	}

	@OnClose
	public void close(Session session) {
		KitchenDisplaySessionHandler.getInstance().removeSession(session);
	}

	@OnError
	public void error(Throwable error) {
		throw new RuntimeException(error);
	}

}
