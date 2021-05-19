package com.yordan.colorchooser.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Entity representing a single color value
 */
@Entity
@Table(name = "COLOR")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	@NotBlank(message = "Label should not be blank")
	private String label;

	@Column(name = "COLOR_VALUE")
	@NotNull(message = "Label should not be blank")
	private Integer colorValue;

	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private ColorType type;

	public long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getColorValue() {
		return colorValue;
	}

	public void setColorValue(Integer value) {
		this.colorValue = value;
	}

	public ColorType getType() {
		return type;
	}

	public void setType(ColorType type) {
		this.type = type;
	}
}
