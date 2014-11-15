package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import utils.BranchParamsListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	// fields
	private TreeSetingsPanel treePanel;
	private TreeDrawingPanel treeDrawingPanel;
	
	//Constructor
	
	public MainFrame(){
		
		// MainFrame setings
		
		super("Chaoso Teorija 3");
		setSize(250,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//layout mannager
		
		setLayout(new BorderLayout());
		
		//intint setengs pane;
		
		treePanel = new TreeSetingsPanel();
		add(treePanel, BorderLayout.CENTER);
		
		treeDrawingPanel = new TreeDrawingPanel();
		treeDrawingPanel.setVisible(false);
		treeDrawingPanel.setSize(500, 500);
		
		
		
		treePanel.setBpl(new BranchParamsListener(){
			
			public void runAnotherPartOfProgram() {
				treeDrawingPanel.setBps(this.getBp());
				this.print();
				initNewFrame();
			}
		});
	}
	
	private void initNewFrame() {
		
		//Padarome matoma JPanel
		treeDrawingPanel.setVisible(true);
		
		// inicilizuojame nauja JFrame
		
		JFrame pantingFrame = new JFrame("Medis");
		pantingFrame.setSize(500,500);
		pantingFrame.setVisible(true);
		pantingFrame.setLocationRelativeTo(null);
		pantingFrame.add(treeDrawingPanel);
		pantingFrame.setVisible(true);
		pantingFrame.setDefaultCloseOperation(pantingFrame.DISPOSE_ON_CLOSE);
		
	} 

}
