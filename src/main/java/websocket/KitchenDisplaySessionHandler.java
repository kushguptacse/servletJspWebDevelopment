package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.Session;

import org.json.JSONObject;

import data.MenuDaoFactory;
import domain.Order;

public final class KitchenDisplaySessionHandler {

	private static KitchenDisplaySessionHandler INSTANCE;

	private final List<Session> sessions = new ArrayList<>();

	public void addSession(Session session) {
		sessions.add(session);
		sendAllOrders(session);
	}

	public static KitchenDisplaySessionHandler getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new KitchenDisplaySessionHandler();
		}
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

	private void sendMessage(JSONObject jsonMessage, Session session) {
		try {
			session.getBasicRemote().sendText(jsonMessage.toString());
		} catch (IOException ex) {
			removeSession(session);
		}
	}

	public void sendAllOrders(Session session) {
		MenuDaoFactory.getMenuDao().getAllOrders().stream()
				.filter(order -> !"ready for collection".equals(order.getStatus()))
				.forEach(order -> sendMessage(getJsonFromObject(order), session));
	}

	public void addNewOrder(Order order) {
		sendMessage(getJsonFromObject(order));
	}

	public void UpdateNewOrder(Order order) {
		JSONObject jsonMessage = new JSONObject();
		jsonMessage.append("id", order.getId().toString());
		jsonMessage.append("action", "remove");
		sendMessage(jsonMessage);
		if (!"ready for collection".equals(order.getStatus())) {
			addNewOrder(order);
		}
	}

	private JSONObject getJsonFromObject(Order order) {
		JSONObject jsonMessage = new JSONObject();
		jsonMessage.append("id", order.getId().toString());
		jsonMessage.append("status", order.getStatus());
		jsonMessage.append("content", order.toString());
		jsonMessage.append("action", "add");
		jsonMessage.append("update", new Date().toString());
		return jsonMessage;
	}
}
