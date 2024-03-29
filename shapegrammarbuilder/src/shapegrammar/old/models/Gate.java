package shapegrammar.old.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import shapegrammar.old.configs.Config;

public class Gate {

	private Graphics canvasReference;
	private Point marker;
	private Point startPoint;
	private Direction direction;
	private MarkerPosition markerPosition;
	private String name;
	
	private int markerLeftStepX;
	private int markerLeftStepY;
	private int markerRightStepX;
	private int markerRightStepY;
	private int txtPlusX;
	private int txtPlusY;
	private int rectStartX;
	private int rectStartY;
	private int rectStepX;
	private int rectStepY;
	
	public Gate(Graphics canvasReference, Point startPoint,
			Direction direction, MarkerPosition markerPosition, String name) {
		this.canvasReference = canvasReference;
		this.startPoint = startPoint;
		this.direction = direction;
		this.markerPosition = markerPosition;
		this.marker = startPoint;
		this.name = name;
		
		if (direction == Direction.EAST) {
			markerLeftStepX = 35;
			markerLeftStepY = 0;
			markerRightStepX = 35;
			markerRightStepY = 34;
			txtPlusX = 6;
			txtPlusY = 17;
			rectStartX = startPoint.x;
			rectStartY = startPoint.y;
			rectStepX = 35;
			rectStepY = 35;
		}
		
		else if (direction == Direction.SOUTH) {
			markerLeftStepX = 34;
			markerLeftStepY = 35;
			markerRightStepX = 0;
			markerRightStepY = 35;
			txtPlusX = 6;
			txtPlusY = 17;
			rectStartX = startPoint.x;
			rectStartY = startPoint.y;
			rectStepX = 35;
			rectStepY = 35;
		}
		
		else if (direction == Direction.WEST) {
			markerLeftStepX = -36;
			markerLeftStepY = -1;
			markerRightStepX = -36;
			markerRightStepY = -35;
			txtPlusX = -30;
			txtPlusY = -16;
			rectStartX = startPoint.x;
			rectStartY = startPoint.y;
			rectStepX = -35;
			rectStepY = -35;
		}
		
		else if (direction == Direction.NORTH) {
			markerLeftStepX = 0;
			markerLeftStepY = -36;
			markerRightStepX = 34;
			markerRightStepY = -36;
			txtPlusX = 6;
			txtPlusY = -14;
			rectStartX = startPoint.x;
			rectStartY = startPoint.y;
			rectStepX = 35;
			rectStepY = -35;
		}
	}
	
	public Point draw() {
		
		if (markerPosition == MarkerPosition.LEFT)
			marker = new Point(startPoint.x+markerLeftStepX, 
					startPoint.y+markerLeftStepY);
		else if (markerPosition == MarkerPosition.RIGHT)
			marker = new Point(startPoint.x+markerRightStepX, 
					startPoint.y+markerRightStepY);
		
		Color oldColor = canvasReference.getColor();
		
		canvasReference.setColor(Config.getInstance().defaultBrushColor);
		
		drawLineRect(rectStartX, rectStartY, 
				rectStartX+rectStepX, rectStartY+rectStepY);
		
		canvasReference.drawString(name, startPoint.x+txtPlusX, 
				startPoint.y+txtPlusY);
		drawMarker();
		
		canvasReference.setColor(oldColor);
		return marker;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}
	
	private void drawLineRect(int x1, int y1, int x2, int y2) {
		canvasReference.drawLine(x1, y1, x2, y1);
		canvasReference.drawLine(x2, y1, x2, y2);
		canvasReference.drawLine(x2, y2, x1, y2);
		canvasReference.drawLine(x1, y2, x1, y1);
	}
	
	private void drawMarker() {
		Color oldColor = canvasReference.getColor();
		canvasReference.setColor(Config.getInstance().defaultMarkerColor);
		canvasReference.fillRect(marker.x, marker.y, 2, 2);
		canvasReference.setColor(oldColor);
	}

	public Point getFreeMarkerPosition() {
		Point result = new Point();
		if (markerPosition == MarkerPosition.LEFT) {
			result.x = startPoint.x + markerRightStepX;
			result.y = startPoint.y + markerRightStepY;
		}
		else if (markerPosition == MarkerPosition.RIGHT) {
			result.x = startPoint.x + markerLeftStepX;
			result.y = startPoint.y + markerLeftStepY;
		}
		return result;
	}
}
