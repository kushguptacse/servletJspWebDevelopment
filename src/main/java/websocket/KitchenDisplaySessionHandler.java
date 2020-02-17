package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.Session;

import org.json.JSONObject;

import domain.Order;
 
public final class KitchenDisplaySessionHandler {

	private static final KitchenDisplaySessionHandler INSTANCE = new KitchenDisplaySessionHandler();;

	private final List<Session> sessions = new ArrayList<>();

	public void addSession(Session session) {
		sessions.add(session);
	}

	public static KitchenDisplaySessionHandler getInstance() {
		return INSTANCE;
	}

	public void removeSession(Session session) {
		sessions.remove(session);
	}

	private void sendMessage(JSONObject jsonMessage) {
		sessions.forEach(session -> {
			try {
				session.getBasicRemote().sendText(jsonMessage.toString());
			} catch (IOException ex) {
				removeSession(session);
			}
		});
	}

	public void addNewOrder(Order order) {
		JSONObject jsonMessage = new JSONObject();
		jsonMessage.append("id", order.getId());
		jsonMessage.append("status", order.getStatus());
		jsonMessage.append("content", order.toString());
		jsonMessage.append("action", "add");
		jsonMessage.append("update", new Date().toString());
		sendMessage(jsonMessage);
	}

}
