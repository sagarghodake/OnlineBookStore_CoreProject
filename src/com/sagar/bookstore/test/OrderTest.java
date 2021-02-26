package com.shashank.bookstore.test;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Scanner;

import com.shashank.bookstore.dao.CartDao;
import com.shashank.bookstore.dao.OrderDao;
import com.shashank.bookstore.dao.impl.CartDaoImpl;
import com.shashank.bookstore.dao.impl.OrderDaoImpl;
import com.shashank.bookstore.pojo.Cart;
import com.shashank.bookstore.pojo.Order;

public class OrderTest
{
	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		Order order=null;
		OrderDao orderDao = new OrderDaoImpl();
		
		boolean flag;
		String custEmailId;
		double totalAmount;
		
		List<Order> orderlist;
		
		System.out.println("<<<<----------------***--------------->>>>Order Model Testing<<<<----------------***--------------->>>>");
		
		do
		{
			System.out.println("1. Place Order ");
			System.out.println("2. Cancel Order");
			System.out.println("3. get All Orders");
			System.out.println("4. get My Orders");
			System.out.println("5. Exit");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
						System.out.println("Enter your Email Id to place Order");
						custEmailId = sc.next();
						totalAmount = orderDao.getTotalAmount(custEmailId);
						System.out.println("Total Amount To Pay as "+totalAmount);
						System.out.println("Do you Want to Place order if yes press 1 or else 0  ");
						int isBook = sc.nextInt();
						if(isBook==1)
						{
							order = orderDao.placeOrder(custEmailId, totalAmount);
							if(order!=null)
							{
								System.out.println("Your Order is Successfully Placed.... :) ");
								System.out.println("--------------------------------------------------------------");
								System.out.println("\n\tOrder Details as Follows:-- ");
								System.out.println("\tOrder Id:-        "+order.getOrderId());
								System.out.println("\tOrder Date:-      "+order.getOrderDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
								System.out.println("\tCustomer Email :- "+order.getCustEmailId());
								System.out.println("\tOrder Item details");
								List<Cart> orderIteams = order.getOrderedCartItems();
								System.out.println("\t      Name       Price      Quantity");
								for (Cart cart : orderIteams) 
								{
									System.out.println("\t\t"+cart.getBook().getBookName()+"     "+cart.getBook().getBookPrice()+"  "+cart.getCartQuantity());
								}
								System.out.println("Total Price: "+order.getTotalAmount());
								System.out.println("Order Status :- "+order.getOrderStatus());
							}
							else
								System.out.println("Your order is not placed please Try again...:(");
						}
						else
						{
							System.out.println("Ok No Problem...");
						}
						
					
					break;
				case 2:
					
					break;
				case 3:
					break;
				case 4:
						System.out.println("Enter your Email Id ");
						custEmailId = sc.next();
						orderlist = orderDao.getMyOrders(custEmailId); 
						for (Order myorder : orderlist) 
						{
							System.out.println("__________________________________________________________________________");
							System.out.println("Oder Id:- "+myorder.getOrderId());
							System.out.println("Order Date:- "+myorder.getOrderDate());
							myorder.getOrderedCartItems().forEach(System.out::println);
							System.out.println("__________________________________________________________________________________");
						}
					break;
				case 5:
					System.out.println("Thank you ... :)");
					break;
				default:
					System.out.println("Invalid Input ");
					break;
			}
		}while(choice !=5);
	}
}
