package cn.tedu.vo;

import java.io.Serializable;

public class UserValue implements Serializable {
	private static final long serialVersionUID = 232L;
	
	private String name;
	private String password;
	private Integer age;
	private String address;
	
	public UserValue() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "UserValue [name=" + name + ", password=" + password + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
