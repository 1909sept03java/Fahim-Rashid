package beans;

public class CallableStatement {
	
	public CallabeStatement() {
		super();
	}
	
	public CallabeStatement(int departmentId, double newAvgSalary, boolean match) {
		super();
		this.departmentId = departmentId;
		this.newAvgSalary = newAvgSalary;
		this.match = match;
		
	}

	private int departmentId;
	private double newAvgSalary;
	private boolean match;
	
}
