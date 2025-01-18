package com.lms.lib;
import java.util.ArrayList;
import java.util.Scanner;

import com.lms.Database.Database;
import com.lms.Model.Admin;
import com.lms.Model.User;
import com.lms.Model.Users;
import com.lms.Services.Management;

public class App 
{
	static Database database;
	static Management mgt; 
	static Scanner sc=new Scanner(System.in);
    public static void main(String[]args)
	{
    	database=new Database();
    	mgt=new Management();
    	
    	int n=-1;
		while(n!=0) {
			System.out.println("Welcome! to Library Management System \nPress \n0.Exit	\n1.Login	\n2.Regester");
			n =sc.nextInt();
			switch(n)
			{	
			case 0:break;
			case 1:login();break;
			case 2:Register();break;	
			default: System.out.println("Error Wrong Selection");
			}
		}
	}
	private static void login()
	{
		System.out.println("Enter your email");
		String email=sc.next();
		System.out.println("Enter your Passward");
		String passward=sc.next();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr=database.login(email,passward);
		if(arr.size()==0) System.out.println("No Such User Found!");
		else {
			if(arr.get(0)!=-1)
			{
				User user=database.getUser(arr.get(0),arr.get(1));
				System.out.println("Welcome! "+ user.getName() + "\n");
			}
			else {
				System.out.println("No such user exists!\n");
			}
		}
		if(arr.get(1)==1)
		{
			int n=-1;
			while(n!=0) {
				System.out.println("\nPress \n0.Exit	\n1.Add Book	\n2.Remove Book \n3.Add User	\n4.Remove User ");
				n =sc.nextInt();
				switch(n)
				{	
				case 0:break;
				case 1:
					System.out.println("Enter the book name to be added");
					String s=sc.next();
					database.addBooks(s);break;
				case 2:
					System.out.println("Enter the book name to be deleted");
					String t=sc.next();
					boolean flag=database.delBooks(t);
					if(flag) System.out.println("Book Deleted");
					else System.out.println("No Such Book Found");
					break;	
				case 3:
					System.out.println("Enter the User name to be deleted");
					String eml=sc.next();
					boolean del=database.delUser(eml);
					if(del) System.out.println("User Deleted");
					else System.out.println("No Such User Found");
					break;
				case 4:
					Register();
				default: System.out.println("Error Wrong Selection");
				}
			}
			
			}
		else {
			int n=-1;
			while(n!=0) {
				System.out.println("\nPress \n0.Exit	\n1.Borrow Book	\n2.Return Book ");
				n =sc.nextInt();
				switch(n)
				{	
				case 0:break;
				case 1:
					System.out.println("Enter the book name to be Borrowed");
					User user=database.getUser(arr.get(0),arr.get(1));
					String Email=user.getEmail();
					String s=sc.next();
					mgt.borrowBook(s,Email);
					break;
				case 2:
					System.out.println("Enter the book name to be Returned");
					User user1=database.getUser(arr.get(0),arr.get(1));
					String Email1=user1.getEmail();
					String s1=sc.next();
					mgt.returnBook(s1,Email1);
					System.out.println("Book Returned Successfully");
					break;
				default: System.out.println("Error Wrong Selection");
				}
			}
		}
		
	}
	private static void Register()
	{
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter your email");
		String email=sc.next();
		System.out.println("Enter your phoneNo");
		String phoneNo=sc.next();
		System.out.println("Enter your Passward");
		String passward=sc.next();
		System.out.println("1.Admin		2.New User");
		int n=sc.nextInt();
		if(n==1)
		{
			User Admin=new Admin(name,email,phoneNo,passward);
			database.addUser(Admin,n);
		}
		else {
			User Users=new Users(name,email,phoneNo,passward) ;
			database.addUser(Users,n);
		}
		System.out.println("Account created successfully.\n");
	}
}

