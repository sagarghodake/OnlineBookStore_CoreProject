package com.shashank.bookstore.test;

import java.util.List;
import java.util.Scanner;

import com.shashank.bookstore.dao.CartDao;
import com.shashank.bookstore.dao.impl.CartDaoImpl;
import com.shashank.bookstore.pojo.Cart;

public class CartTest 
{
	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		Cart cart=null;
		CartDao cartDao = new CartDaoImpl();
		boolean flag;
		String custEmailId;
		
		List<Cart> cartlist;
		
		System.out.println("<<<<----------------***--------------->>>>Cart Model Testing<<<<----------------***--------------->>>>");
		
		do
		{
			System.out.println("1. add to Cart");
			System.out.println("2. Show Cart to Customr ");
			System.out.println("3. Show All Cart to Admin");
			System.out.println("4. Clear Cart of Customer");
			System.out.println("5. Delete item from Cart");
			System.out.println("6. Exit");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					cart = new Cart();
					System.out.println("Enter Email Id :- ");
					cart.setCustEmailId(sc.next());
					System.out.println("Enter book Id to add in cart ");
					cart.setBookId(sc.nextInt());
					System.out.println("Cart Quantity");
					cart.setCartQuantity(sc.nextInt());
					
					flag = cartDao.addToCart(cart);
										
					if(flag)
						System.out.println("Itam is add in cart Scuccefully...");
					else
						System.out.println("Item is not added into cart.");
					
					break;
				case 2:
					System.out.println("Enter Email Id to See Cart Details");
					custEmailId = sc.next();
					cartlist = cartDao.showCart(custEmailId);
					
					if(cartlist!=null && !cartlist.isEmpty()) {
						cartlist.forEach((Cart c)->{
							System.out.println(c);
							System.out.println("__________________________________________________________________________________________");
						});
					}else
						System.out.println("Your Cart is Empty....:(");
					
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
						System.out.println("Thank you ... :)");
					break;
				default:
					System.out.println("Invalid Input ");
					break;
			}
		}while(choice !=6);
	}
}
