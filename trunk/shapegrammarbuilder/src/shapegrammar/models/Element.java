package shapegrammar.models;

import java.awt.Dimension;
import java.io.File;

public class Element {
	
	private File textureFile;
	private Dimension dimension;
	
	public Element(String textureFilename, Dimension dimension) {
		this.setTextureFile(new File(textureFilename));
		this.setDimension(dimension);
	}

	private void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setTextureFile(File textureFile) {
		this.textureFile = textureFile;
	}

	public File getTextureFile() {
		return textureFile;
	}
}
