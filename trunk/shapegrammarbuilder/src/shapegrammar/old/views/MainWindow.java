package shapegrammar.old.views;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

import shapegrammar.old.configs.Config;
import shapegrammar.old.models.Direction;
import shapegrammar.old.models.Gate;
import shapegrammar.old.models.MarkerPosition;
import shapegrammar.old.models.Wire;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
        
        private Point startPoint = Config.getInstance().defautStartPoint;
        private Gate lastGate;
        
        // --- components ---
        private JPanel drawingPanel;
        private JPanel controlsPanel;
        
        private JButton andGateButton;
        private JButton nandGateButton;
        private JButton orGateButton;
        private JButton norGateButton;
        private JButton wireButton;
        
        private JButton gotoLastGateButton;
        
        public MainWindow() {
                initSysUI();
                initMainWindow();
                initComponents();
                addComponents();
                initListeners();
                setVisible(true);
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
                setTitle(Config.getInstance().defaultApplicationTitle);
                setSize(Config.getInstance().defaultWindowDimension);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setResizable(false);
                setLayout(new BorderLayout());
        }
        
        private void initComponents() {
                drawingPanel = new JPanel();
                drawingPanel.setBackground(Config.getInstance().defaultMapColor);
                
                controlsPanel = new JPanel();
                controlsPanel.setBorder(new TitledBorder("Controls"));
                
                andGateButton = new JButton("AND");
                nandGateButton = new JButton("NAND");
                orGateButton = new JButton("OR");
                norGateButton = new JButton("NOR");
                wireButton = new JButton("Wire");
                
                gotoLastGateButton = new JButton("Go to last gate's free slot");
        }
        
        private void addComponents() {
                this.add(drawingPanel, BorderLayout.CENTER);
                this.add(controlsPanel, BorderLayout.SOUTH);
                
                controlsPanel.add(andGateButton);
                controlsPanel.add(nandGateButton);
                controlsPanel.add(orGateButton);
                controlsPanel.add(norGateButton);
                controlsPanel.add(wireButton);
                
                controlsPanel.add(gotoLastGateButton);
        }
        
    	private void initListeners() {
    		andGateButton.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				gateButtonAction("AND");
    			}
    		});
    		nandGateButton.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				gateButtonAction("NAND");	
    			}
    		});
    		orGateButton.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				gateButtonAction("OR");
    			}
    		});
    		norGateButton.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				gateButtonAction("NOR");
    			}
    		});
    		wireButton.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				wireButtonAction();
    			}
    		});
    		gotoLastGateButton.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				gotoLastGateButtonAction();
    			}
    		});
    	}
    	
    	protected void gotoLastGateButtonAction() {
    		startPoint = lastGate.getFreeMarkerPosition();
		}

		private Direction askForDirection() {
    		String directionStr 
			= JOptionPane.showInputDialog("Direction (N,E,S,W):");
		
    		Direction direction;
    		
			if (directionStr.equals("N"))
				direction = Direction.NORTH;
			else if (directionStr.equals("E"))
				direction = Direction.EAST;
			else if (directionStr.equals("S"))
				direction = Direction.SOUTH;
			else if (directionStr.equals("W"))
				direction = Direction.WEST;
			else {
				JOptionPane.showMessageDialog(this, "Bad argument, sorry!", "Error",
						JOptionPane.ERROR_MESSAGE);
				return null;
			}
			return direction;
    	}
    	
    	private MarkerPosition askForMarkerPosition() {
			String markerPositionStr 
			= JOptionPane.showInputDialog("Marker (L,R):");
		
			MarkerPosition markerPosition;
			
			if (markerPositionStr.equals("L"))
				markerPosition = MarkerPosition.LEFT;
			else if (markerPositionStr.equals("R"))
				markerPosition = MarkerPosition.RIGHT;
			else {
				JOptionPane.showMessageDialog(this, "Bad argument, sorry!", "Error",
						JOptionPane.ERROR_MESSAGE);
				return null;
			}
			
			return markerPosition;
    	}

		protected void gateButtonAction(String gateName) {
			Direction direction = askForDirection();
			if (direction == null) return;
			
			MarkerPosition markerPosition = askForMarkerPosition();
			if (markerPosition == null) return;
			
			Gate gate = new Gate(
					drawingPanel.getGraphics(),
					startPoint,
					direction,
					markerPosition,
					gateName
			);
			startPoint = gate.draw();
			lastGate = gate;
		}
		
		protected void wireButtonAction() {
			Direction direction = askForDirection();
			if (direction == null) return;
			
			Wire wire = new Wire(
					drawingPanel.getGraphics(),
					startPoint,
					direction
			);
			
			startPoint = wire.draw();
		}
}