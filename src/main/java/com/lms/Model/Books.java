package com.lms.Model;

public class Books {
	private String bookName;
	private boolean isAvali=true;
	private String borrowedBy;
	private boolean borrowOnline=false;
	private String path;
	
	public void setAvali(boolean b) {
		isAvali=b;
	}
	public boolean getAvali() {
		return isAvali;
	}
	public void setBorrowedby(String email) {
		borrowedBy=email;
	}
	public String getBorrowedby() {
		return borrowedBy;
	}
	public void setBorrowOnline()
	{
		borrowOnline=true;
	}
	public boolean getBorrowOnline()
	{
		return borrowOnline;
	}
	public void setPath(String s)
	{
		path=s;
	}
	public String getPath()
	{
		return path;
	}
	public void setbookName(String bookName)
	{
		this.bookName=bookName;
	}
	public String getbookName()
	{
		return bookName;
	}
}
