package com.shashank.bookstore.test;

import java.util.List;
import java.util.Scanner;

import com.shashank.bookstore.dao.BookDao;
import com.shashank.bookstore.dao.impl.BookDaoImpl;
import com.shashank.bookstore.pojo.Book;

public class BookTest
{
	private static List<Book> blist;

	public static void main(String[] args) 
	{
		int choice;
		Scanner sc = new Scanner(System.in);
		
		BookDao bookDao = new BookDaoImpl();
		Book book = null;
		boolean flag;
		
		int bookId;
		
		System.out.println("<<<<----------------***--------------->>>>Book Model Testing<<<<----------------***--------------->>>>");
		do {
			System.out.println("1.Add Book");
			System.out.println("2.Update Book ");
			System.out.println("3.Delete Book");
			System.out.println("4.View All Book ");
			System.out.println("5.View Book By Id ");
			System.out.println("6.View Book By Name ");
			System.out.println("7.View Book By Author ");
			System.out.println("8.View Book By Publisher ");
			System.out.println("9.Exit ");
			System.out.println("Select Your Choice ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Add New Book Details ");
				book = new Book();//Empty book....
				System.out.println("Enter Name ");
				sc.nextLine();  // It use to handle the enter of choice.
				book.setBookName(sc.nextLine());

				System.out.println("Author :- ");
				book.setBookAuthor(sc.nextLine());
				
				System.out.println("Publisher :- ");
				book.setBookPublisher(sc.nextLine());
				
				System.out.println("Price");
				book.setBookPrice(sc.nextDouble()); 
				
				sc.nextLine(); // To handle the enter of double.
				System.out.println("Description :- ");
				book.setBookDescription(sc.nextLine());
				
				flag = bookDao.save(book);
				if(flag)
					System.out.println("Book is Save Successfully...");
				else
					System.out.println("Book is Not Save..");
				break;
			case 2:
				System.out.println("Enter the Id to Update the Book");
				bookId= sc.nextInt();
				book = bookDao.getById(bookId);
				if(book!=null)
				{
					System.out.println("Book is Found ");
					System.out.println("Book Old Details :- \n\t\t"+book);
					System.out.println("Enter Update Book Details ");
					Book updatedBook = new Book();
					updatedBook.setBookId(bookId);
					
					System.out.println("Enter Name ");
					sc.nextLine();  // It use to handle the enter of bookId.
					updatedBook.setBookName(sc.nextLine());

					System.out.println("Author :- ");
					updatedBook.setBookAuthor(sc.nextLine());
					
					System.out.println("Publisher :- ");
					updatedBook.setBookPublisher(sc.nextLine());
					
					System.out.println("Price");
					updatedBook.setBookPrice(sc.nextDouble()); 
					
					sc.nextLine(); // To handle the enter of double.
					System.out.println("Description :- ");
					updatedBook.setBookDescription(sc.nextLine());
					
					flag = bookDao.update(updatedBook);
					
					if(flag)
						System.out.println("Book is updated Successfully...");
					else
						System.out.println("Book is Not update...");
					
				}else
				{
					System.out.println("No Book Found for given id");
					System.out.println("Pleaes Enter Correct book Id");
				}
				
				break;
			case 3:
				System.out.println("Enter Book Id to Delete Book ");
				bookId = sc.nextInt();
				
				flag = bookDao.delete(bookId);
				
				if(flag)
					System.out.println("Book is Deleted Successfully...");
				else
					System.out.println("Book is Not delete...");
				
				break;
			case 4:
				System.out.println("-------------------------------------------------------------Book List-------------------------------------------------------------");
				
				blist = bookDao.getAll();
				blist.forEach(b->{
					System.out.println(b);
					System.out.println("________________________________________________________________________________________________________________________________");
				});
				
				break;
			case 5:
				System.out.println("Enter a Book Id to View Details");
				bookId = sc.nextInt();
				book = bookDao.getById(bookId);
				if(book!=null) 
				{
					System.out.println("Book is Found..");
					System.out.println("------------------------------Book---------------------------");	
					System.out.println(book);
				}else
					System.out.println("Book Not Found for Given id ");
				
				break;
			case 6:
				System.out.println("Implemetation is Pending.");
				break;
			case 7:
				System.out.println("Implemetation is Pending.");
				break;
			case 8:
				System.out.println("Implemetation is Pending.");
				break;
			case 9:
				System.out.println("Thank You... :) ");
				break;
			default:
				System.out.println("Invalid Choice......");
				System.out.println("Please Try again...");
				break;
			}
			
			
		}while(choice!=9);
	}
}
