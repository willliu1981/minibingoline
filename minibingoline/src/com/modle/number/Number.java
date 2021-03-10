package com.modle.number;

import java.awt.Point;

public class Number {
	private Integer number;
	private Point position;

	public Number(Integer number) {
		this.number = number;
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}

	public Integer getNumber() {
		return number;
	}

	public Point getPosition() {
		return position;
	}
	
	
}
