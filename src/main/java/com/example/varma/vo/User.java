package com.example.varma.vo;

public class User {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String city;

	public User() {
	}

	public User(String name, int age, String gender, String city) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public String getGender() {
		return gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city + "]";
	}


}
