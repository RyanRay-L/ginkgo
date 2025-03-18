package cn.ryanray.ginkgo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketStompController {

	@MessageMapping("/send")
	@SendTo("/topic/messages")
	public MessageResponse handleMessage(MessageRequest request) {
		return new MessageResponse("Echo: " + request.getContent());
	}

	public static class MessageRequest {
		private String content;

		// Getter 和 Setter
		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class MessageResponse {
		private String content;

		public MessageResponse(String content) {
			this.content = content;
		}

		// Getter 和 Setter
		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}