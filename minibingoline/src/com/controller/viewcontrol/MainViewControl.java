package com.controller.viewcontrol;

import java.awt.Dimension;

public class MainViewControl {
	private Dimension size;

	public MainViewControl(int w, int h) {
		this.size=new Dimension(w, h);
	}

	public Dimension getSize() {
		return this.size;
	}

	public int getWidth() {
		return this.size.width;
	}

	public int getHeight() {
		return this.size.height;
	}
}
