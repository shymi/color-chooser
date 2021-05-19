package com.yordan.colorchooser.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity representing a single color type
 */
@Entity
@Table(name = "COLOR_TYPE")
public class ColorType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
