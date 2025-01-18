package com.lms.Services;
import java.util.Scanner;

import com.lms.Database.Database;
import com.lms.Model.Books;
import com.lms.Model.BorrowOnline;
public class Management {
	static Books book=new Books();
	static Database db=new Database();
	static BorrowOnline bo=new BorrowOnline();
	Scanner sc=new Scanner(System.in);
	public void borrowBook(String bName,String email)
	{
		Books bn=new Books();
		bn=db.findBooks(bName);
			if(bn.getAvali()) {
				if(bn.getBorrowOnline())
				{
					System.out.println("This book cant be borrowed Physically.\n Press \n1.To borrow as PDF \n2.exit");
					int n=sc.nextInt();
					switch(n)
					{
						case 1:bo.borrowOnline(bn.getPath());
						System.out.println("Book Borrowed Successfully");
								break;
						case 2:break;
					}
					
					
				}
				else {
					bn.setAvali(false);
					bn.setBorrowedby(email);
					System.out.println("Book Borrowed Successfully");
					}
				}
			else {
				System.out.println("Book Is Already Borrowed");
				
			}
		}
	public void returnBook(String bName,String email)
	{
		book.setAvali(true);
		book.setBorrowedby("");
	}
	
		
}
