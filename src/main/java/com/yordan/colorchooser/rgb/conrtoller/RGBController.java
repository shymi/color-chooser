package com.yordan.colorchooser.rgb.conrtoller;

import com.yordan.colorchooser.rgb.dto.RGBDTO;
import com.yordan.colorchooser.rgb.service.RGBService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

/**
 * Controller for rgb operations
 */
@Controller
public class RGBController {
	private final RGBService rgbService;

	public RGBController(RGBService rgbService) {
		this.rgbService = rgbService;
	}

	@MessageMapping("/rgb")
	@SendTo("/topic/rgb")
	public RGBDTO updateRGBValue(@Payload RGBDTO rgbColor) {
		rgbService.updateRGBValue(rgbColor);
		return rgbService.getCurrentRGBValue();
	}

	@MessageMapping("/rgb-initial")
	@SendTo("/topic/rgb")
	public RGBDTO getCurrentRGBValue() {
		return rgbService.getCurrentRGBValue();
	}
}
