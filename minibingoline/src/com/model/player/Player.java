package com.model.player;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import com.controller.viewcontrol.ShowNumberControl;

public abstract class Player {
	protected String name;
	protected Map<Integer,Number> mapNumber; 
	protected ShowNumberControl viewControl;

	public Player(String name) {
		this.name = name;
		this.mapNumber=new HashMap<>();
	}
	
	public void drawNumber(Graphics g) {
		
	}
	
	
	
	public String getName() {
		return name;
	}

	public String toString() {
		return this.name;
	}
}
