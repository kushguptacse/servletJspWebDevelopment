package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

import data.MenuDao;
import data.MenuDaoFactory;

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
	
	@OnMessage
	public void handleMessage(String message,Session session) {
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		JSONObject request = new JSONObject(message);
		Long id = Long.valueOf(request.getLong("id"));
		String status = request.getString("status");
		menuDao.updateOrderStatus(id, status);
		//web socket code 
		KitchenDisplaySessionHandler.getInstance().UpdateNewOrder(menuDao.getOrder(id));
	}	

}
