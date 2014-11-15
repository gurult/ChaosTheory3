package utils;

public class BranchParams {
	
	public int angle;
	public double scale;
	
	public BranchParams(int angle, double scale) {
		this.angle = angle;
		this.scale = scale;
	}
	
	public void printInfo() {
		System.out.println("Posukio kampas " + angle);
		System.out.println("Maþinimo kofecienatas " + scale);
	}
}
