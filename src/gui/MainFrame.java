package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	// fields
	private TreeSetingsPanel treePanel;
	
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
	}
}
