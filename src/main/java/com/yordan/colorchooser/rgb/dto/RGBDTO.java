package com.yordan.colorchooser.rgb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * DTO used for rgb communication via websocket
 */
public class RGBDTO {
	@JsonProperty
	@NotNull
	@Min(0)
	@Max(255)
	Integer red;

	@JsonProperty
	@NotNull
	@Min(0)
	@Max(255)
	Integer green;

	@JsonProperty
	@NotNull
	@Min(0)
	@Max(255)
	Integer blue;

	public RGBDTO() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}

	public Integer getRed() {
		return red;
	}

	public void setRed(Integer red) {
		this.red = red;
	}

	public Integer getGreen() {
		return green;
	}

	public void setGreen(Integer green) {
		this.green = green;
	}

	public Integer getBlue() {
		return blue;
	}

	public void setBlue(Integer blue) {
		this.blue = blue;
	}
}
