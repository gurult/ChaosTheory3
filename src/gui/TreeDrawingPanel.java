package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import drawingPrimitivas.MyLine;
import utils.BranchParams;
import Transformations.AffineTransformations;

@SuppressWarnings("serial")
public class TreeDrawingPanel extends JPanel {

	private JButton nextIterationButton = new JButton("Sekanti iteracija");
	private BranchParams[] bp;
	private Point2D temp = new Point2D.Double();

	private int counter = 0;

	private List<MyLine> firstList = new ArrayList<MyLine>();
	private List<MyLine> scondList = new ArrayList<MyLine>();
	private List<MyLine> thirdList;

	// /------------------------
	public TreeDrawingPanel() {

		// inicilizuojame savo pirmaji taðka

		firstList.add(new MyLine(250, 350, 250, 250));
		scondList.add(new MyLine(250, 350, 250, 250));
		setLayout(new BorderLayout());
		add(nextIterationButton, BorderLayout.SOUTH);

		nextIterationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				test();
				repaint();
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (!firstList.isEmpty())
			g2.draw(new Line2D.Double(firstList.get(0).a, firstList.get(0).b));
		// testas

		for (int i = 0; i < scondList.size(); i++) {
			g2.draw(new Line2D.Double(scondList.get(i).a, scondList.get(i).b));

		}
	}

	public void setBps(BranchParams[] branchParams) {
		this.bp = branchParams;
	}

	// darbas su pirma saka

	private void w1(Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[0].angle, bp[0].scale);
	}

	private void w2(Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[1].angle, bp[1].scale);
	}

	private void w3(Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[2].angle, bp[2].scale);
	}

	private void w4(Point2D a) {
		AffineTransformations.affineTransformPos(temp, a, bp[3].angle, bp[3].scale);
	}

	private void ww1(MyLine a) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w1(tempLine.a);
		w1(tempLine.b);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));
	}

	private void ww2(MyLine a) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w2(tempLine.a);
		w2(tempLine.b);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));
	}

	private void ww3(MyLine a) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w3(tempLine.a);
		w3(tempLine.b);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));
	}

	private void ww4(MyLine a) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w4(tempLine.a);
		w4(tempLine.b);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));

	}

	// ---- utilities
	private void decraseAngle() {
		bp[0].angle = bp[0].angle + 5;
		bp[1].angle = bp[0].angle + 5;
		bp[2].angle = bp[0].angle + 5;
		bp[3].angle = bp[0].angle + 5;
	}

	private void test() {

		if (counter < 8) {
			if (counter == 3) {
				decraseAngle();
			}
			if (!firstList.isEmpty()) {
				thirdList = new ArrayList<MyLine>();
				while (!firstList.isEmpty()) {
					if (counter % 2 == 0)
						temp.setLocation(firstList.get(0).b);
					else {
						temp.setLocation(firstList.get(0).a);
					}
					ww1(firstList.get(0));
					ww2(firstList.get(0));
					ww3(firstList.get(0));
					ww4(firstList.get(0));
					firstList.remove(0);

				}

				System.out.println("firstList.size() " + firstList.size());
				System.out.println("thirdList.size() " + thirdList.size());

				firstList = thirdList;
				thirdList = null;
				System.out.println("scondList.size() " + scondList.size());
				System.out.println("firstList.size() " + firstList.size());
			} else {
				System.out.println("tuscias");
			}
			counter++;
		}
	}
}
