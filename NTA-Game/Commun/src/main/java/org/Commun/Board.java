package org.Commun;

import java.util.ArrayList;
import java.util.Iterator;

public class Board {
	
	private int width;
	private int height;

	// private ArrayList<Sprite> list = new ArrayList<>();
	
	public Board(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	
	/* public void addSprite(Sprite p) {
		this.list.add(p);
	} 
	
	public Iterator<Sprite> spriteIterator() {
		return list.iterator();
	} */
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		
	}

}
