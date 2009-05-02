package shapegrammar.models;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;

import shapegrammar.exceptions.CursorBeyondMapException;

public class Map {

	private Field[][] fields;
	private Dimension sizeInFields;
	private Field cursorField;

	public Map(Dimension sizeInFields, Point start) {
		setSizeInFields(sizeInFields);
		fields = new Field[sizeInFields.width][sizeInFields.height];
		initFields();
		initNeighbours();
		this.setCursorField(fields[start.x][start.y]);
	}

	public void setFields(Field[][] fields) {
		this.fields = fields;
	}

	public Field[][] getFields() {
		return fields;
	}
	
	private void initFields() {
		
		for (int row = 0; row < getSizeInFields().height; row++)
			for (int column = 0; column < getSizeInFields().width; column++) {
				Element newElement = ElementFactory.createNullElement();
				Point newPosition = new Point(column*newElement.getDimension().width,
						row*newElement.getDimension().height);
				
				fields[column][row] = new Field(newElement, newPosition);
			}
	}
	
	private void initNeighbours() {
		for (int row = 0; row < getSizeInFields().height; row++)
			for (int column = 0; column < getSizeInFields().width; column++)
				fields[column][row].setNeighbours(computeNeighbours(column, row));
	}
	
	private HashMap<String, Field> computeNeighbours(int column, int row) {
		HashMap<String, Field> result = new HashMap<String, Field>();
		
		result.put("N", (row > 0)? fields[column][row-1] : null);
		result.put("E", (column < getSizeInFields().width-1)? fields[column+1][row] : null);
		result.put("S", (row < getSizeInFields().height-1)? fields[column][row+1] : null);
		result.put("W", (column > 0)? fields[column-1][row] : null);
		
		return result;
	}

	public void setSizeInFields(Dimension sizeInFields) {
		this.sizeInFields = sizeInFields;
	}

	public Dimension getSizeInFields() {
		return sizeInFields;
	}

	public void setCursorField(Field cursorField) {
		this.cursorField = cursorField;
	}

	public Field getCursorField() {
		return cursorField;
	}
	
	public void moveCursorUpAndSet(Element e)
					throws CursorBeyondMapException {
		if (cursorField.getNeighbours().get("N") == null)
			throw new CursorBeyondMapException(cursorField.getPosition());
		
		cursorField = cursorField.getNeighbours().get("N");
		cursorField.setElement(e);
	}
	
	public void moveCursorRightAndSet(Element e)
					throws CursorBeyondMapException {
		if (cursorField.getNeighbours().get("E") == null)
			throw new CursorBeyondMapException(cursorField.getPosition());
		
		cursorField = cursorField.getNeighbours().get("E");
		cursorField.setElement(e);
	}

	public void moveCursorDownAndSet(Element e) 
					throws CursorBeyondMapException {
		if (cursorField.getNeighbours().get("S") == null)
			throw new CursorBeyondMapException(cursorField.getPosition());
		
		cursorField = cursorField.getNeighbours().get("S");
		cursorField.setElement(e);
	}
	
	public void moveCursorLeftAndSet(Element e) 
					throws CursorBeyondMapException {
		if (cursorField.getNeighbours().get("W") == null)
			throw new CursorBeyondMapException(cursorField.getPosition());
		cursorField = cursorField.getNeighbours().get("W");
		cursorField.setElement(e);
	}
}
