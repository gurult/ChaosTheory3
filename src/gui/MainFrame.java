package gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	// fields
	
	//Constructor
	
	public MainFrame(){
		
		// MainFrame setings
		
		super("Chaoso Teorija 3");
		setSize(250,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
