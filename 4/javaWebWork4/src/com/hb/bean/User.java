package com.hb.bean;

public class User {
	private int id;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private String address;
	public String getName() {
		return this.name;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getPwd()
	{
		return this.pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getPhone()
	{
		return this.phone;
	}public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return this.address;
	}
	
	@Override
	public String toString() {
	 return "User [id=" + id + ", name=" + name + ", password=" + pwd
	 + ", email=" + email + ", phone=" + phone + ", address="+address+"]";
	}
}
