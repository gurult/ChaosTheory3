package drawingPrimitivas;
import java.awt.geom.Point2D;


public class MyLine {
	
	public Point2D a;
	public Point2D b;
	
	public MyLine (double x, double y , double x1, double y1) {
		this.a = new Point2D.Double(x, y);
		this.b  =new Point2D.Double(x1, y1);
		
	}
	
	public MyLine (Point2D a, Point2D b) {
		this.a  = new Point2D.Double(a.getX(), a.getY());
		this.b  = new Point2D.Double(b.getX(), b.getY());
		
	}
	

}
