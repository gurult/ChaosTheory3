package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.BranchParams;


@SuppressWarnings("serial")
public class TreeDrawingPanel extends JPanel {
	private JButton nextIterationButton = new JButton("Sekanti iteracija");
	
	private BranchParams[] bp;
	
	public TreeDrawingPanel() {
		setLayout(new BorderLayout());
		add(nextIterationButton, BorderLayout.SOUTH);
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
