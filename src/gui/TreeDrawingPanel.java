package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import utils.BranchParams;


@SuppressWarnings("serial")
public class TreeDrawingPanel extends JPanel {
	
	private BranchParams[] bp;
	
	public TreeDrawingPanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		
		g.drawLine(20, 20, 500, 500);
		
	}
	
	public void setBps(BranchParams[] branchParams) {
		this.bp = branchParams;
	}
}
