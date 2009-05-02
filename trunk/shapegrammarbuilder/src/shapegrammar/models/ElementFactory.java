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
	
	public static Element createSandElement() {
		return new Element(Config.getInstance().sandTextureFilename,
				Config.getInstance().defaultElementDimension);
	}

	public static Element createTreeElement() {
		return new Element(Config.getInstance().treeTextureFilename,
				Config.getInstance().defaultElementDimension);
	}
	
	public static Element createWaterElement() {
		return new Element(Config.getInstance().waterTextureFilename,
				Config.getInstance().defaultElementDimension);
	}
}
