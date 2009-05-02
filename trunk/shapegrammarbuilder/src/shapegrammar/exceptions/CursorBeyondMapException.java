package shapegrammar.exceptions;

import java.awt.Point;

@SuppressWarnings("serial")
public class CursorBeyondMapException extends Exception {
	
	private Point cursorPosition;

	public CursorBeyondMapException(Point cursorPosition) {
		super();
		this.setCursorPosition(cursorPosition);
	}

	private void setCursorPosition(Point cursorPosition) {
		this.cursorPosition = cursorPosition;
	}

	public Point getCursorPosition() {
		return cursorPosition;
	}
	
	
}
