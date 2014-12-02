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

	private List<MyLine> firstList = new ArrayList<MyLine>();
	private List<MyLine> scondList = new ArrayList<MyLine>();
	private List<MyLine> thirdList;

	private int counter = 0;
	private int wind = 0;
	private boolean kaire = true;
	private boolean desne = false;

	// /------------------------
	public TreeDrawingPanel() {

		// inicilizuojame savo pirmaji taðka


		setLayout(new BorderLayout());
		add(nextIterationButton, BorderLayout.SOUTH);

		nextIterationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				
					if ((kaire) && wind < 5) {
						// System.out.println("suveikia");
						wind++;
					} else {
						desne = true;
						kaire = false;
					}

					if ((desne) && wind > -5) {
						wind--;
					} else {
						kaire = true;
						desne = false;

					}
					System.out.println(wind);
					System.out.println("counter" + counter);
					test(wind);
					repaint();
				}
			
			
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (scondList != null) {
			for (int i = 0; i < scondList.size(); i++) {
				g2.draw(new Line2D.Double(scondList.get(i).a, scondList.get(i).b));
			}
		System.out.println("antro saraso dydis" + scondList.size());
		scondList.clear();
		firstList.clear();
		}
	}

	public void setBps(BranchParams[] branchParams) {
		this.bp = branchParams;
		bp[0].printInfo();

		// repaint();
	}

	// darbas su pirmu medziu

	private void w1(Point2D a, int wind) {
		AffineTransformations.affineTransformPos(temp, a, bp[0].angle - wind, bp[0].scale);
	}

	private void w2(Point2D a, int wind) {
		AffineTransformations.affineTransformPos(temp, a, bp[1].angle - wind, bp[1].scale);
	}

	private void w3(Point2D a, int wind) {
		AffineTransformations.affineTransformPos(temp, a, bp[2].angle - wind, bp[2].scale);
	}

	private void w4(Point2D a, int wind) {
		AffineTransformations.affineTransformPos(temp, a, bp[3].angle - wind, bp[3].scale);
	}

	// ---------------------------------------------------------

	// ---------------------------------------------------------

	private void ww1(MyLine a, int wind) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w1(tempLine.a, wind);
		w1(tempLine.b, wind);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));
	}

	private void ww2(MyLine a, int wind) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w2(tempLine.a, wind);
		w2(tempLine.b, wind);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));
	}

	private void ww3(MyLine a, int wind) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w3(tempLine.a, wind);
		w3(tempLine.b, wind);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));
	}

	private void ww4(MyLine a, int wind) {

		MyLine tempLine = new MyLine(a.a, a.b);

		w4(tempLine.a, wind);
		w4(tempLine.b, wind);

		scondList.add(new MyLine(tempLine.a, tempLine.b));
		thirdList.add(new MyLine(tempLine.a, tempLine.b));

	}

	private void test(int wind) {
		//scondList = new ArrayList<MyLine>();
		scondList.add(new MyLine(250, 350, 250, 250));
		firstList.add(new MyLine(250, 350, 250, 250));
		
		for (int i = 0; i < 4; i++) {
			if (!firstList.isEmpty()) {
				thirdList = new ArrayList<MyLine>();
				while (!firstList.isEmpty()) {
					if (counter % 2 == 0)
						temp.setLocation(firstList.get(0).b);
					else {
						temp.setLocation(firstList.get(0).a);
					}
					// prideti vieja
					ww1(firstList.get(0), wind);
					ww2(firstList.get(0), wind);
					ww3(firstList.get(0), wind);
					ww4(firstList.get(0), wind);
					firstList.remove(0);

				}

				firstList = thirdList;
				thirdList = null;

			}
			counter++;

		}
		counter =0;
	}

}