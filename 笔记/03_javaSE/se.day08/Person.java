package day08;

import java.io.Serializable;
/**
 * 实现序列化接口时候Java自动添加两个方法：
 * 一个是对象序列化方法（将对象变成byte）
 * 一个是对象反序列化方法（将byte拼接为对象）
 * 
 * 建议:(必须遵守) 实现序列化接口是添加序列化
 * 序列化 版本号，可以保证对象序列化、反序列化 
 * 的稳定。减少更改类对序列化的影响。
 */
public class Person implements Serializable {
	private static final long 
		serialVersionUID = -44741053724L;
	String name;
	String sex;
	int age;
	//friend 是瞬态属性，系列时候会被忽略
	//反序列化结果是 null
	transient Person friend;
 
	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}



	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age + ", friend=" + friend + "]";
	}
 
 
}



