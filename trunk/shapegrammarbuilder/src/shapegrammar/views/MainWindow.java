package shapegrammar.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

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
        
    	private JButton grassButton;
    	private JButton sandButton;
    	private JButton soilButton;
    	private JButton treeButton;
    	private JButton waterButton;
    	
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
                
                grassButton 	= new JButton("Grass");
        		sandButton		= new JButton("Sand");
        		soilButton		= new JButton("Soil");
        		treeButton		= new JButton("Tree");
        		waterButton		= new JButton("Water");
        		
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
                this.add(infoPanel, BorderLayout.NORTH);
                infoPanel.add(infoLabel);
                this.add(drawingPanel, BorderLayout.CENTER);
                this.add(controlsPanel, BorderLayout.SOUTH);
                
                controlsPanel.add(grassButton);
    			controlsPanel.add(sandButton);
    			controlsPanel.add(soilButton);
    			controlsPanel.add(treeButton);
    			controlsPanel.add(waterButton);
    			
    			controlsPanel.remove(grassButtonN);
    			controlsPanel.remove(grassButtonE);
    			controlsPanel.remove(grassButtonS);
    			controlsPanel.remove(grassButtonW);
    			
    			controlsPanel.remove(sandButtonN);
    			controlsPanel.remove(sandButtonE);
    			controlsPanel.remove(sandButtonS);
    			controlsPanel.remove(sandButtonW);
    			
    			controlsPanel.remove(soilButtonN);
    			controlsPanel.remove(soilButtonE);
    			controlsPanel.remove(soilButtonS);
    			controlsPanel.remove(soilButtonW);
    			
    			controlsPanel.remove(treeButtonN);
    			controlsPanel.remove(treeButtonE);
    			controlsPanel.remove(treeButtonS);
    			controlsPanel.remove(treeButtonW);
    			
    			controlsPanel.remove(waterButtonN);
    			controlsPanel.remove(waterButtonE);
    			controlsPanel.remove(waterButtonS);
    			controlsPanel.remove(waterButtonW);
    			
    			
        }
        
    	private void initListeners() {
    		grassButton.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				grassButtonAction();
    			}
    		});
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
    		sandButton.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				sandButtonAction();
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
    		soilButton.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				soilButtonAction();
    			
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
    		treeButton.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				treeButtonAction();
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
    		waterButton.addActionListener( new ActionListener() {
    			public void actionPerformed(java.awt.event.ActionEvent e) {
    				waterButtonAction();
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

    	protected void waterButtonWAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void waterButtonSAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void waterButtonEAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void waterButtonNAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void waterButtonAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void treeButtonWAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void treeButtonSAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void treeButtonEAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void treeButtonNAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void treeButtonAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void soilButtonWAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void soilButtonSAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void soilButtonEAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void soilButtonNAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void soilButtonAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void sandButtonWAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void sandButtonSAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void sandButtonEAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void sandButtonNAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void sandButtonAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void grassButtonWAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void grassButtonSAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void grassButtonEAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void grassButtonNAction() {
    		// TODO Auto-generated method stub
    		
    	}

    	protected void grassButtonAction() {
    		// TODO Auto-generated method stub
    	}
    }
