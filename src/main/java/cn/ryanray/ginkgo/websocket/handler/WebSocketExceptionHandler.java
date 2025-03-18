package cn.ryanray.ginkgo.websocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * @Author: 雷磊
 * @Date: 2025/3/18 10:54
 */
@Component
public class WebSocketExceptionHandler extends AbstractWebSocketHandler {

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.err.println("WebSocket error: " + exception.getMessage());
	}
}
