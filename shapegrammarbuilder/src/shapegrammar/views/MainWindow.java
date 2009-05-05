package shapegrammar.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
    	
    	private JButton grassButtonN;
    	private JButton grassButtonE;
    	private JButton grassButtonS;
    	private JButton grassButtonW;
    	
    	private JButton sandButtonN;
    	private JButton sandButtonE;
    	private JButton sandButtonS;
    	private JButton sandButtonW;
    	
    	private JButton soilButtonN;
    	private JButton soilButtonE;
    	private JButton soilButtonS;
    	private JButton soilButtonW;
    	
    	private JButton treeButtonN;
    	private JButton treeButtonE;
    	private JButton treeButtonS;
    	private JButton treeButtonW;

    	private JButton waterButtonN;
    	private JButton waterButtonE;
    	private JButton waterButtonS;
    	private JButton waterButtonW;
    	
    	private Map map;
        private Printer printer;
        
        public MainWindow() {
                initSysUI();
                initMainWindow();
                initComponents();
                addComponentsToDrawingPane();
                initListeners();
                //resetControlsPanel();
                setVisible(true);
                
                map = new Map(new Dimension(24,16), config.defaultStart);
                printer = new Printer(drawingPanel.getGraphics(), map);
                printer.printAll();
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
                controlsPanel.setLayout(new GridLayout(5,4));
        		
        		grassButtonN = new JButton("Grass - North");
        		grassButtonE = new JButton("Grass - East");
        		grassButtonS = new JButton("Grass - South");
        		grassButtonW = new JButton("Grass - West");
        		
        		sandButtonN = new JButton("Sand - North");
        		sandButtonE = new JButton("Sand - East");
        		sandButtonS = new JButton("Sand - South");
        		sandButtonW = new JButton("Sand - West");
        		
        		soilButtonN = new JButton("Soil - North");
        		soilButtonE = new JButton("Soil - East");
        		soilButtonS = new JButton("Soil - South");
        		soilButtonW = new JButton("Soil - West");
        		
        		treeButtonN = new JButton("Tree - North");
        		treeButtonE = new JButton("Tree - East");
        		treeButtonS = new JButton("Tree - South");
        		treeButtonW = new JButton("Tree - West");
        		
        		waterButtonN = new JButton("Water - North");
        		waterButtonE = new JButton("Water - East");
        		waterButtonS = new JButton("Water - South");
        		waterButtonW = new JButton("Water - West");
        }
        
        private void addComponentsToDrawingPane() {
                this.add(drawingPanel, BorderLayout.CENTER);
                this.add(controlsPanel, BorderLayout.SOUTH);
    			
    			controlsPanel.add(grassButtonN);
    			controlsPanel.add(grassButtonE);
    			controlsPanel.add(grassButtonS);
    			controlsPanel.add(grassButtonW);
    			
    			controlsPanel.add(sandButtonN);
    			controlsPanel.add(sandButtonE);
    			controlsPanel.add(sandButtonS);
    			controlsPanel.add(sandButtonW);
    			
    			controlsPanel.add(soilButtonN);
    			controlsPanel.add(soilButtonE);
    			controlsPanel.add(soilButtonS);
    			controlsPanel.add(soilButtonW);
    			
    			controlsPanel.add(waterButtonN);
    			controlsPanel.add(waterButtonE);
    			controlsPanel.add(waterButtonS);
    			controlsPanel.add(waterButtonW);
    			
    			controlsPanel.add(treeButtonN);
    			controlsPanel.add(treeButtonE);
    			controlsPanel.add(treeButtonS);
    			controlsPanel.add(treeButtonW);
        }
        
    	private void initListeners() {
    		grassButtonN.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				grassButtonNAction();
    			}
    		});
    		grassButtonE.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				grassButtonEAction();
    			}
    		});
    		grassButtonS.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				grassButtonSAction();
    			}
    		});
    		grassButtonW.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				grassButtonWAction();
    			}
    		});
    		sandButtonN.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				sandButtonNAction();
    			}
    		});
    		sandButtonE.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				sandButtonEAction();
    			}
    		});
    		sandButtonS.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				sandButtonSAction();
    			}
    		});
    		sandButtonW.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				sandButtonWAction();
    			}
    		});
    		soilButtonN.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				soilButtonNAction();
    			}
    		});
    		soilButtonE.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				soilButtonEAction();
    			}
    		});
    		soilButtonS.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				soilButtonSAction();
    			}
    		});
    		soilButtonW.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				soilButtonWAction();
    			}
    		});
    		treeButtonN.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				treeButtonNAction();
    			}
    		});
    		treeButtonE.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				treeButtonEAction();
    			}
    		});
    		treeButtonS.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				treeButtonSAction();
    			}
    		});
    		treeButtonW.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				treeButtonWAction();
    			}
    		});
    		waterButtonN.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				waterButtonNAction();
    			}
    		});
    		waterButtonE.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				waterButtonEAction();
    			}
    		});
    		waterButtonS.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				waterButtonSAction();
    			}
    		});
    		waterButtonW.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				waterButtonWAction();
    			}
    		});
    	}

    	protected void waterButtonSAction() {
    		try {
				map.moveCursorDownAndSet(ElementFactory.createWaterElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}
    	
    	protected void waterButtonWAction() {
    		try {
				map.moveCursorLeftAndSet(ElementFactory.createWaterElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void waterButtonEAction() {
    		try {
				map.moveCursorRightAndSet(ElementFactory.createWaterElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void waterButtonNAction() {
    		try {
				map.moveCursorUpAndSet(ElementFactory.createWaterElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void treeButtonAction() {
    		
    	}
    	
    	protected void treeButtonWAction() {
    		try {
				map.moveCursorLeftAndSet(ElementFactory.createTreeElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void treeButtonSAction() {
    		try {
				map.moveCursorDownAndSet(ElementFactory.createTreeElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void treeButtonEAction() {
    		try {
				map.moveCursorRightAndSet(ElementFactory.createTreeElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void treeButtonNAction() {
    		try {
				map.moveCursorUpAndSet(ElementFactory.createTreeElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void soilButtonAction() {
    		
    	}
    	
    	protected void soilButtonWAction() {
    		try {
				map.moveCursorLeftAndSet(ElementFactory.createSoilElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void soilButtonSAction() {
    		try {
				map.moveCursorDownAndSet(ElementFactory.createSoilElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void soilButtonEAction() {
    		try {
				map.moveCursorRightAndSet(ElementFactory.createSoilElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void soilButtonNAction() {
    		try {
				map.moveCursorUpAndSet(ElementFactory.createSoilElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void sandButtonAction() {
    		
    	}
    	
    	protected void sandButtonWAction() {
    		try {
				map.moveCursorLeftAndSet(ElementFactory.createSandElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void sandButtonSAction() {
    		try {
				map.moveCursorDownAndSet(ElementFactory.createSandElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void sandButtonEAction() {
    		try {
				map.moveCursorRightAndSet(ElementFactory.createSandElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void sandButtonNAction() {
    		try {
				map.moveCursorUpAndSet(ElementFactory.createSandElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void grassButtonAction() {
    		
    	}

    	protected void grassButtonWAction() {
    		try {
				map.moveCursorLeftAndSet(ElementFactory.createGrassElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void grassButtonSAction() {
    		try {
				map.moveCursorDownAndSet(ElementFactory.createGrassElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void grassButtonEAction() {
    		try {
				map.moveCursorRightAndSet(ElementFactory.createGrassElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}

    	protected void grassButtonNAction() {
    		try {
				map.moveCursorUpAndSet(ElementFactory.createGrassElement());
			}
    		catch (CursorBeyondMapException e) {
				e.printStackTrace();
			}
    		printer.printAll();
    	}
}