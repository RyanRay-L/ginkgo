package cn.ryanray.ginkgo.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Author: 雷磊
 * @Date: 2025/3/18 10:24
 */
public class MyWebsocketHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 处理收到的消息
		String clientMessage = message.getPayload();
		System.out.println("Received message: " + clientMessage);

		// 发送响应消息
		String response = "Echo: " + clientMessage;
		session.sendMessage(new TextMessage(response));
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 连接建立时触发
		System.out.println("New connection established: " + session.getId());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 连接关闭时触发
		System.out.println("Connection closed: " + session.getId());
	}

}
