package com.shashank.bookstore.test;

import java.util.Scanner;

import com.shashank.bookstore.dao.CustomerDao;
import com.shashank.bookstore.dao.impl.CustomerDaoImpl;
import com.shashank.bookstore.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		Customer customer=null;
		CustomerDao customerDao = new CustomerDaoImpl();
		boolean flag;
		System.out.println("<<<<----------------***--------------->>>>Customer Model Testing<<<<----------------***--------------->>>>");
		
		do
		{
			System.out.println("1. Register Customer (Save)");
			System.out.println("2. Edit Profile Customer (update)");
			System.out.println("3. Delete Customer profile (delete)");
			System.out.println("4. View All Customer (getAll)");
			System.out.println("5. View Customer By Id (getById)");
			System.out.println("6. View Customer By Email Id (getByEmailId)");
			System.out.println("7. Exit");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter Your Following Details");
					customer = new Customer();
					System.out.println("First Name ");
					sc.nextLine();
					customer.setCustFName(sc.nextLine());
					System.out.println("Last Name ");
					customer.setCustLName(sc.nextLine());
					System.out.println("Email Id ");
					customer.setCustEmailId(sc.nextLine());
					System.out.println("Mobile No ");
					customer.setCustMobileNo(sc.nextLine());
					System.out.println("Password ");
					customer.setCustPassword(sc.nextLine());
					System.out.println("Address ");
					customer.setCustAddress(sc.nextLine());
					
					flag = customerDao.save(customer);
					if(flag)
						System.out.println("Registration is Successfull.");
					else
						System.out.println("Registration is Failed Try again.");
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
						System.out.println("Thank you ... :)");
					break;
				default:
					System.out.println("Invalid Input ");
					break;
			}
		}while(choice !=7);
	}

}
