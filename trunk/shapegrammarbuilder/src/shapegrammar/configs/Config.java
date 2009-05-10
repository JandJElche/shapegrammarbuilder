package shapegrammar.configs;

import java.awt.*;

public class Config {

	public String defaultApplicationTitle = "Logical Gates Shape Grammar";
	public Dimension defaultWindowDimension = new Dimension(800, 700); 
	public Dimension defaultElementDimension = new Dimension(64, 32);
	public Color defaultMapColor = Color.WHITE;
	public Color defaultBrushColor = Color.BLACK;
	public Color defaultMarkerColor = Color.RED;
	public Point defautStartPoint = new Point(100,100);
	
	// ----------------------------------------------------
	
	private static Config instance = new Config();
	
	protected Config() {	
	}

	public static Config getInstance() {
		return instance;
	}
}
