package utils;

public abstract class BranchParamsListener {
	private BranchParams[] bp;
	
	public abstract void runAnotherPartOfProgram();
	
	public void setBranchParams(BranchParams[] bp) {
		this.bp = bp;
	}
	
	public BranchParams[] getBp() {
		return bp;
	}
	
	public void print() {
		
		if(bp != null) {
			bp[0].printInfo();
			bp[1].printInfo();
			bp[2].printInfo();
			bp[3].printInfo();
		}
	}
}
