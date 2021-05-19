package com.yordan.colorchooser.rgb.service;

import com.yordan.colorchooser.common.entity.Color;

import com.yordan.colorchooser.rgb.dao.RGBDAO;
import com.yordan.colorchooser.rgb.dto.RGBDTO;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for RGB color operations
 */
@Service
public class RGBService {
	private final RGBDAO rgbDAO;

	public RGBService(RGBDAO rgbDAO) {
		this.rgbDAO = rgbDAO;
	}

	public void updateRGBValue(RGBDTO rgbValue) {
		List<Color> rgbDBValue = rgbDAO.getCurrentRGBValue();

		for (Color color : rgbDBValue) {
			switch(color.getLabel()) {
				case "R":
					color.setColorValue(rgbValue.getRed());
					rgbDAO.save(color);
					break;
				case "G":
					color.setColorValue(rgbValue.getGreen());
					rgbDAO.save(color);
					break;
				case "B":
					color.setColorValue(rgbValue.getBlue());
					rgbDAO.save(color);
					break;
			}
		}
	}

	public RGBDTO getCurrentRGBValue() {
		List<Color> rgbDBValue = rgbDAO.getCurrentRGBValue();

		RGBDTO result = new RGBDTO();

		for (Color color : rgbDBValue) {
			switch(color.getLabel()) {
				case "R":
					result.setRed(color.getColorValue());
					break;
				case "G":
					result.setGreen(color.getColorValue());
					break;
				case "B":
					result.setBlue(color.getColorValue());
					break;
			}
		}

		return result;
	}
}
