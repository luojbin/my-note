package entity;

import java.io.Serializable;

public class Course implements Serializable {

	//对象的属性
	private Integer courseId;
	private String name;
	private Integer days;
	
	//Bean属性:
	//1.去掉get/set剩下的单词,首字母小写
	//2.通过get/set方法所分析出来的属性
	public Integer getId() {
		return courseId;
	}
	public void setId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
}







