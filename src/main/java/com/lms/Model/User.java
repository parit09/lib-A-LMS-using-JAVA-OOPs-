package com.lms.Model;

public abstract class User {
	private String name;
	private String passward;
	private String email;
	private String phoneNo;
	private boolean isDel=false;
	private boolean isAdmin=false;
	public User() {

		// TODO Auto-generated constructor stub
	}
	public User(String name)
	{
		this.name=name;
	}
	public User(String name,String email,String phoneNo,String passward)

	{
		this.email=email;
		this.passward=passward;
		this.name=name;
		this.phoneNo=phoneNo;
		isDel=false;
	}
	
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPhoneNo()
	{
		return phoneNo;
	}
	public String getPassward()
	{
		return passward;
	}
	public boolean getDel()
	{
		return isDel;
	}
	public void setDel()
	{
		isDel=true;
	}
	public boolean getisAdmin()
	{
		return isAdmin;
	}
	public void setisAdmin()
	{
		isAdmin=true;
	}
	
}
