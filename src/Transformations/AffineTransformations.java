package Transformations;
import java.awt.geom.Point2D;

// klase yra final, kad niekas negal�t� jos paveld�t
public final class AffineTransformations {

// privatus Constructorius
	private AffineTransformations() {
		// empty because we do not wan let have an instance of the class
	}

	// a - kokio ta�ko at�vilgiu darysime posuk�
	// b - koki ta�k� sukane
	// angDeg - kokiu kampu nurodome laipsniais

//---------------------------------------------------------------------
	// daro posuk� ta�ko a at�vilgiu prie� laikrod�io rodykl�
	
	// a - kokio ta�ko at�vilgiu darysime posuk�
	// b - koki ta�k� sukane
	// angDeg - kokiu kampu nurodome laipsniais

	public static void affineTransformPos(Point2D a, Point2D b, double angDeg, double scale) {

		double rad = Math.toRadians(angDeg);

		double functionX = scale * ((Math.cos(rad) * (b.getX() - a.getX())) + 
							(Math.sin(rad) * (a.getY() - b.getY())))
							+ a.getX();

		double functionY = scale * (Math.sin(rad) * (b.getX() - a.getX()) + 
							Math.cos(rad) * (b.getY() - a.getY())) + 
							a.getY();

		b.setLocation(functionX, functionY);
	
	}
	
//---------------------------------------------------------------------
	// daro posuk� ta�ko a at�vilgiu pagal laikrod�io rodykl�
	
	// a - kokio ta�ko at�vilgiu darysime posuk�
	// b - koki ta�k� sukane
	// angDeg - kokiu kampu nurodome laipsniais

	public static void affineTransformNeg(Point2D a, Point2D b, double angDeg, double scale) {

		double rad = Math.toRadians(angDeg);

		double functionX =  scale * (Math.cos(rad) * (b.getX() - a.getX()) + 
							Math.sin(rad) * (b.getY() - a.getY())) + a.getX();

		double functionY =  scale * (Math.sin(rad) * (a.getX() - b.getX()) +
							Math.cos(rad) * (b.getY() - a.getY())) + a.getY();

		b.setLocation(functionX, functionY);

	}
}	
//------------------------------------------------------------------------
