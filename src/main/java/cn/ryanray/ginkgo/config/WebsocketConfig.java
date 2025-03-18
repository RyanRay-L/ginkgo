package cn.ryanray.ginkgo.config;

import cn.ryanray.ginkgo.websocket.handler.MyWebsocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Author: 雷磊
 * @Date: 2025/3/18 10:22
 */
@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new MyWebsocketHandler(), "/ws")
			.setAllowedOrigins("*");	// 允许所有访问源。
	}

}
