package com.kh.hw.member.model.vo;

public class Member {
//- id : String
//	- name : String
//	- password : String
//	- email : String
//	- gender : char
//	- age : int
	private String id;
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;
//	+ Member()
	public Member() {
	}
//	+ Member(id:String, name:String, password:String,
//	email:String, gender:char age:int)
	public Member(String id,String name, String password,String email, char gender,int age) {
				this.id=id;
				this.name=name;
				this.password=password;
				this.email=email;
				this.gender=gender;
				this.age=age;
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setName(String Name) {
		this.name=name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setGender(char gender) {
		this.gender=gender;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getId() {return id;}
	public String getName() {return name;}
	public String getPassword() {return password;}
	public char getGender() {return gender;}
	public int getAge() {return age;}
	public String getEmail() {
		return email;
	}
	public String info() {
		return id+name+password+gender+age;
	}
}
