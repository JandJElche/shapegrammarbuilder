package shapegrammar.models;

import shapegrammar.configs.Config;

public class ElementFactory {

	public static Element createNullElement() {
		return new Element(Config.getInstance().nullTextureFilename,
				Config.getInstance().defaultElementDimension);
	}
	
	public static Element createSoilElement() {
		return new Element(Config.getInstance().soilTextureFilename,
				Config.getInstance().defaultElementDimension);
	}
	
	public static Element createGrassElement() {
		return new Element(Config.getInstance().grassTextureFilename,
				Config.getInstance().defaultElementDimension);
	}

}
