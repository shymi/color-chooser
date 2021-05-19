package com.yordan.colorchooser.rgb.handler;

import com.yordan.colorchooser.rgb.dto.RGBDTO;
import com.yordan.colorchooser.rgb.service.RGBService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.stereotype.Component;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * WebSocket Handler
 */
@Component
public class RGBWebsocketHandler implements WebSocketHandler {
	private static final ObjectMapper JSON = new ObjectMapper();

	private final RGBService rgbService;

	public RGBWebsocketHandler(RGBService rgbService) {
		this.rgbService = rgbService;
	}

	@Override
	public Mono<Void> handle(WebSocketSession session) {
		Flux<WebSocketMessage> result =
				session.receive()
				.map(message -> {
					String colorResult = null;
					String msgString = message.getPayloadAsText();

					try {
						if (!msgString.isEmpty()) {
							RGBDTO rgbdto = JSON.readValue(msgString, RGBDTO.class);
							rgbService.updateRGBValue(rgbdto);
						}

						RGBDTO currentValue = rgbService.getCurrentRGBValue();
						colorResult = JSON.writeValueAsString(currentValue);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

					return session.textMessage(colorResult == null ? "" : colorResult);
				});

		return session.send(result);
	}
}
