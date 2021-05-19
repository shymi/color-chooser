package com.yordan.colorchooser.rgb.conrtoller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class RGBController {
	@MessageMapping("/rgb")
	@SendTo("/topic/rgb")
	public String updateRGBValue(@Payload String rgbColor) {
		return rgbColor;
	}

	@MessageMapping("/rgb-initial")
	@SendTo("/topic/rgb")
	public String sendCurrentValue() {
		return "{\"red\": 50, \"green\": 50, \"blue\": 50}";
	}
}
