package shapegrammar.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import shapegrammar.configs.Config;

public class Field {
	
	private Element element;
	private Point position;
	private HashMap<String, Field> neighbours;
	
	private Color cursorBorderColor
		= Config.getInstance().defaultCursorBorderColor;
	
	public Field(Element element, Point position) {
		this.setElement(element);
		this.setPosition(position);
	}

	public void setNeighbours(HashMap<String, Field> neighbours) {
		this.neighbours = neighbours;
	}

	public HashMap<String, Field> getNeighbours() {
		return neighbours;
	}

	public void draw(Graphics canvas, Field cursorField) {
		BufferedImage textureImage = null;
		try {
			textureImage = ImageIO.read(getElement().getTextureFile());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		canvas.drawImage(textureImage, getPosition().x, getPosition().y, null);
		
		if (this == cursorField) {
			Color oldColor = canvas.getColor();
			canvas.setColor(this.cursorBorderColor);
			canvas.drawRect(getPosition().x, getPosition().y, 
					getElement().getDimension().width-1, getElement().getDimension().width-1);
			canvas.setColor(oldColor);
		}
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}
}
