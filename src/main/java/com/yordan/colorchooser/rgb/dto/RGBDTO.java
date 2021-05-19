package com.yordan.colorchooser.rgb.dto;

import com.yordan.colorchooser.common.entity.Color;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RGBDTO {
	@JsonProperty
	List<Color> rgb;
}
