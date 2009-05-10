package shapegrammar.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import shapegrammar.configs.Config;

public class Wire {
	private Graphics canvasReference;
	private Point marker;
	private Point startPoint;
	private Direction direction;
	
	private int lineStepX;
	private int lineStepY;
	
	public Wire(Graphics canvasReference, Point startPoint,
			Direction direction) {

		this.canvasReference = canvasReference;
		this.startPoint = startPoint;
		this.direction = direction;
		this.marker = startPoint;
		
		if (this.direction == Direction.EAST) {
			lineStepX = 35;
			lineStepY = 0;
		}
		else if (this.direction == Direction.SOUTH) {
			lineStepX = 0;
			lineStepY = 35;
		}
		else if (this.direction == Direction.WEST) {
			lineStepX = -35;
			lineStepY = 0;
		}
		else if (this.direction == Direction.NORTH) {
			lineStepX = 0;
			lineStepY = -35;
		}
	}
	
	public Point draw() {
		Color oldColor = canvasReference.getColor();
		
		canvasReference.setColor(Config.getInstance().defaultBrushColor);
		canvasReference.drawLine(startPoint.x, startPoint.y, 
				startPoint.x+lineStepX, startPoint.y+lineStepY);
		
		marker = new Point(startPoint.x+lineStepX, startPoint.y+lineStepY);
		
		canvasReference.setColor(Config.getInstance().defaultMarkerColor);
		canvasReference.fillRect(marker.x, marker.y, 2, 2);
		
		canvasReference.setColor(oldColor);
		return marker;
	}
}
