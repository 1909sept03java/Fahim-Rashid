package beans;

public class Department {

	public Department() {
		super();
	}
	public Department(int departmentId, String departmentName, int avgSalary) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.setAvgSalary(avgSalary);
	}
	
	private int departmentId;
	private String departmentName;
	private int avgSalary;
	
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", avgSalary="
				+ avgSalary + "]";
	}
	public int getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(int avgSalary) {
		this.avgSalary = avgSalary;
	}
}
