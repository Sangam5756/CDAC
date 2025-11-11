package com.cms.entities;

public enum Marks {
	JAVA(50), DBT(40);

	private final int markValue;

	Marks(int markValue) {
		this.markValue = markValue;
	}

	public int getMarkValue() {
		return markValue;
	}

}
