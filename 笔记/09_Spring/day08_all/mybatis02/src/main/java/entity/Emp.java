package entity;

public class Emp {
	private int empNo;
	private String ename;
	private int age;
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", ename=" + ename + ", age=" + age + "]";
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
