package com.lms.Database;
import java.util.ArrayList;
import java.util.Scanner;

import com.lms.Model.Books;
import com.lms.Model.User;

public class Database {
	ArrayList<User> users;
	ArrayList<User> admins;
	ArrayList<Books> books;
	Scanner sc=new Scanner(System.in);
	static Books book=new Books();
	public Database(){
		users=new ArrayList<User>();
		admins=new ArrayList<User>();
		books=new ArrayList<Books>();
	}
	
	public ArrayList<Integer> login(String email,String passward)
	{
		int ind=-1;
		int n=0;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(User s:users)
		{
			if(s.getEmail().matches(email) && s.getPassward().matches(passward))
			{
				ind=users.indexOf(s);
				if(s.getisAdmin()) n=1;
				else n=2;
			}
		}
		for(User s:admins)
		{
			if(s.getEmail().matches(email) && s.getPassward().matches(passward))
			{
				ind=admins.indexOf(s);
				if(s.getisAdmin()) n=1;
				else n=2;
			}
		}
		arr.add(ind);
		arr.add(n);
		return arr;
	}
	
	public User getUser(int n,int adm)
	{
		if(adm==1)
			return admins.get(n); 
		else
			return users.get(n);
	}
	
	public boolean findUser(String email)
	{
		boolean found=false;
		if(users.size()==0) return found;
		else {
			for(User s:users)
			{
				if(s.getEmail().matches(email)) {
					found=true;
				}
					
			}
		}
		return found;
		
	}
	
	public void addUser(User s,int n)
	{
		if(n==1)
		{
			admins.add(s);
			s.setisAdmin();
		}
		else {
			users.add(s);
		}
	}
	
	public boolean delUser(String email)
	{
		boolean flag=false;
		for(User s:users)
		{
			if(s.getEmail().matches(email))
				if(s.getDel()==false)
				{
					flag=s.getDel();
					s.setDel();
				}
		}
		return flag;
	}
	
	public void addBooks(String bookName)
	{
		Books bk=new Books();
		System.out.println("Set Borrow property of the Book.\nPress \n1.Can only be borrowed online \n2.can be Borrowed Offline");
		int n=sc.nextInt();
		if(n==1)
		{
			String path;
			bk.setBorrowOnline();
			bk.setbookName(bookName);
			bk.setAvali(true);
			System.out.println("Enter Absolute Path of the Book |");
			path=sc.next();
			bk.setPath(path);
			books.add(bk);
		}
		else if(n==2) {
			bk.setbookName(bookName);
			bk.setAvali(true);
			books.add(bk);
		}
		else {
			System.out.println("Wrong Selection.");
		}
		
	}
	
	
	public boolean delBooks(String bookName)
	{
		boolean found=false;
		for(Books s:books)
		{
			if(s.getbookName().matches(bookName)) {
				books.remove(s);
				found=true;
			}
				
		}
		return found;
		
	}
	
	public boolean getBooks(String bookName)
	{
		boolean found=false;
		if(books.size()==0) return found;
		else {
			for(Books s:books)
			{
				if(s.getbookName().matches(bookName)) {
					found=true;
				}
					
			}
		}
		return found;
		
	}
	public Books findBooks(String bookName)
	{
		Books bn=new Books();
		for(Books s:books)
		{
			if(s.getbookName().matches(bookName)) {
				bn=s;
			}
					
		}
		return bn;
	}
}