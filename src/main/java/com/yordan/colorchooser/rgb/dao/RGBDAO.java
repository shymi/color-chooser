package com.yordan.colorchooser.rgb.dao;

import com.yordan.colorchooser.common.entity.Color;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for working with color
 */
@Repository
public interface RGBDAO extends CrudRepository<Color, Long> {
	@Query(value = "SELECT c FROM Color c JOIN ColorType ct ON c.type = ct WHERE ct.name = 'RGB'")
	List<Color> getCurrentRGBValue();
}
