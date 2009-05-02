package shapegrammar.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

import shapegrammar.configs.Config;
import shapegrammar.exceptions.CursorBeyondMapException;
import shapegrammar.models.ElementFactory;
import shapegrammar.models.Map;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	Config config = Config.getInstance();

	// --- components ---
	private JPanel drawingPanel;
	private JPanel controlsPanel;
	private JPanel infoPanel;
	
	private JLabel infoLabel;
	
	public MainWindow() {
		initSysUI();
		initMainWindow();
		initComponents();
		addComponentsToDrawingPane();
		initListeners();
		setVisible(true);
		
		// zabawa :P
		
		Map map = new Map(new Dimension(24,16), config.defaultStart);
		Printer printer = new Printer(drawingPanel.getGraphics(), map);
		
		map.getFields()[config.defaultStart.x][config.defaultStart.y]
		                .setElement(ElementFactory.createSoilElement());
		
		try {
			for (int i = 0; i < 23; i++)
				map.moveCursorRightAndSet(ElementFactory.createGrassElement());
			map.moveCursorDownAndSet(ElementFactory.createGrassElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorLeftAndSet(ElementFactory.createGrassElement());
			map.moveCursorDownAndSet(ElementFactory.createTreeElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorRightAndSet(ElementFactory.createTreeElement());
			map.moveCursorDownAndSet(ElementFactory.createTreeElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorLeftAndSet(ElementFactory.createTreeElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorRightAndSet(ElementFactory.createSandElement());
			map.moveCursorDownAndSet(ElementFactory.createSandElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorLeftAndSet(ElementFactory.createSandElement());
			map.moveCursorDownAndSet(ElementFactory.createWaterElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorRightAndSet(ElementFactory.createWaterElement());
			map.moveCursorDownAndSet(ElementFactory.createWaterElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorLeftAndSet(ElementFactory.createWaterElement());
			map.moveCursorDownAndSet(ElementFactory.createSoilElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorRightAndSet(ElementFactory.createSoilElement());
			map.moveCursorDownAndSet(ElementFactory.createSoilElement());
			for (int i = 0; i < 23; i++)
				map.moveCursorLeftAndSet(ElementFactory.createSoilElement());
		}
		catch (CursorBeyondMapException e) {
			JOptionPane.showMessageDialog(this, 
					"Sorry, cursor would go beyond the map.\n" +
					"Current cursor's position: " +
					+ e.getCursorPosition().x + ", " +
					+ e.getCursorPosition().y, 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		
		printer.printAll();
		
		// i po zabawie
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
	
	// ----------------------------------------------------
	
	private void initSysUI() {
	    try {
		    // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }
	}
	
	private void initMainWindow() {
		setTitle(config.defaultApplicationTitle);
		setSize(config.defaultWindowDimension);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
	}
	
	private void initComponents() {
		drawingPanel = new JPanel();
		drawingPanel.setBackground(config.defaultMapColor);
		
		controlsPanel = new JPanel();
		controlsPanel.setBorder(new TitledBorder("Controls"));
		controlsPanel.setLayout(new GridLayout(1,2));
		
		infoLabel = new JLabel("Info:");
		infoPanel = new JPanel();
	}
	
	private void addComponentsToDrawingPane() {
		this.add(infoPanel, BorderLayout.NORTH);
		infoPanel.add(infoLabel);
		this.add(drawingPanel, BorderLayout.CENTER);
		this.add(controlsPanel, BorderLayout.SOUTH);
	}
	
	private void initListeners() {
		
	}
}
