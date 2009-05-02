package shapegrammar.views;

import java.awt.Graphics;

import shapegrammar.models.Field;
import shapegrammar.models.Map;

public class Printer {

	private Graphics canvas;
	private Map map;

	public Printer(Graphics canvas, Map map) {
		this.canvas = canvas;
		this.map = map;
	}
	
	void printAll() {
		Field[][] mapFields = map.getFields();
		for (int row = 0; row < map.getSizeInFields().height; row++)
			for (int column = 0; column < map.getSizeInFields().width; column++)
				mapFields[column][row].draw(canvas, map.getCursorField());
	}
}
