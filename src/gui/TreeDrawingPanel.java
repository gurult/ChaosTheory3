package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.JButton;
import javax.swing.JPanel;

import Transformations.AffineTransformations;
import utils.BranchParams;


@SuppressWarnings("serial")
public class TreeDrawingPanel extends JPanel {
	
	private JButton nextIterationButton = new JButton("Sekanti iteracija");
	
	private BranchParams[] bp;
	private Point2D temp = new Point2D.Double();
	
	public TreeDrawingPanel() {
		setLayout(new BorderLayout());
		add(nextIterationButton, BorderLayout.SOUTH);
	}
	 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		
		// testas
		test(g2);
	}
	
	public void setBps(BranchParams[] branchParams) {
		this.bp = branchParams;
	}
	
	
	// darbas su pirma saka 
	
	private void w1 (Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[0].angle, bp[0].scale);
	}
	
	private void w2 (Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[1].angle, bp[1].scale);
	}
	
	private void w3 (Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[2].angle, bp[2].scale);
	}
	
	private void w4 (Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[3].angle, bp[3].scale);
	}
	
	private void test (Graphics2D g) {
		
		
		Point2D a = new Point2D.Double(250,350);
		Point2D b = new Point2D.Double(250,250);
		System.out.println("atstumas 1 : " + a.distance(b));
		g.draw(new Line2D.Double(a,b));
		
		Point2D temp = new Point2D.Double();
		temp.setLocation(b);
		
		AffineTransformations.affineTransformPos(temp, a, 135, 0.75);
		AffineTransformations.affineTransformPos(temp, b, 135, 0.75);
		System.out.println("atstumas 2 :" + a.distance(b));
		g.draw(new Line2D.Double(a,b));
		
		temp.setLocation(a);
		
		AffineTransformations.affineTransformPos(temp, a, 135, .75);
		AffineTransformations.affineTransformPos(temp, b, 135, .75);
		System.out.println("atstumas 3 :" + a.distance(b));
		g.draw(new Line2D.Double(a,b));
		
		temp.setLocation(b);
		
		AffineTransformations.affineTransformPos(temp, a, 135, .75);
		AffineTransformations.affineTransformPos(temp, b, 135, .75);
		System.out.println("atstumas 4 :" + a.distance(b));
		g.draw(new Line2D.Double(a,b));
		
		temp.setLocation(a);
		
		AffineTransformations.affineTransformPos(temp, a, 135, .75);
		AffineTransformations.affineTransformPos(temp, b, 135, .75);
		System.out.println("atstumas 4 :" + a.distance(b));
		g.draw(new Line2D.Double(a,b));
	}
}
