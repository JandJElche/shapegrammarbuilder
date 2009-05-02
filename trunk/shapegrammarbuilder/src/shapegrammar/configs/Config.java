package shapegrammar.configs;

import java.awt.*;

public class Config {

	public String defaultApplicationTitle = "Shape Grammar Builder";
	public Dimension defaultWindowDimension = new Dimension(800, 600); 
	public Dimension defaultElementDimension = new Dimension(32, 32);
	public Color defaultMapColor = Color.BLACK;
	public Color defaultCursorBorderColor = Color.RED;
	
	public String grassTextureFilename = "src/resources/grass.png";
	public String soilTextureFilename  = "src/resources/soil.png";
	public String nullTextureFilename  = "src/resources/null.png";
	
	public Point defaultStart = new Point(0,0); 
	
	// ----------------------------------------------------
	
	private static Config instance = new Config();
	
	protected Config() {	
	}

	public static Config getInstance() {
		return instance;
	}
}
