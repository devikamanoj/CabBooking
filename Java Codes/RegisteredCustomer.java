import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class RegisteredCustomer
{
	static String username;
	static String password;
	static int fl;
	static int flag;
	static String x,y;
	static Scanner in=new Scanner(System.in);
	static File f = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\Customer.dat"); //to be changed according to ur system's path
	
	public static void checking()
	{   System.out.println();
		System.out.print("ENTER USERNAME : ");
		username=in.next();
		System.out.print("ENTER PASSWORD : ");
		password=in.next();
		
		for(int i=0;i<NewCustomer.customerlist.size();i++)
		{
		if((NewCustomer.customerlist.get(i).getuse().contains(username))&&(NewCustomer.customerlist.get(i).getpass().contains(password)))
		{
		    fl=i;
		    flag=1;
		}
		else
		{  
		   flag=0;
		
	    }
		}
		
		 if(flag==1)
			{
			 System.out.println();
			 System.out.println("LOADING...");
			 System.out.println();
			  Cab_booking.wait(2000);
			  System.out.println("LOGIN SUCCESSFULL...");
			 System.out.print("\n");
			}
			
		
	}
	
	 public static void showdetails()
		{
			 if(flag==1)			
		     {
		     y=NewCustomer.customerlist.get(fl).Name;
			 System.out.println("NAME : "+y);
			 x=NewCustomer.customerlist.get(fl).Phonenumber;
		     System.out.println("PHONE NUMBER : "+x);
		     }
		}
	 public static void editdetails()
		{   int choice;
		    String newname,newph;
		    System.out.println("-----------------");
		    System.out.println("     MODIFY ");
		    System.out.println("-----------------");
			System.out.println("1.Name");
			System.out.println("2.Phone Number");
			System.out.println("Which Among This Do You Want To Modify ?(1/2) -");
			choice=in.nextInt();
			if(choice==1)
			{
				System.out.println("Enter Modified Name - ");
				newname=in.next();
				NewCustomer nc=new NewCustomer(username,password,newname,NewCustomer.customerlist.get(fl).Phonenumber);
			    NewCustomer.customerlist.set(fl,nc);
			    NewCustomer.writeData();
			    System.out.println("Updation Succesfull !!");
		    }
			
			else if(choice==2)
			{
				System.out.println("Enter Modified Phone Number - ");
				newph=in.next();
				NewCustomer nc1=new NewCustomer(username,password,NewCustomer.customerlist.get(fl).Name,newph);
				NewCustomer.customerlist.set(fl,nc1);
				NewCustomer.writeData();
				System.out.println("Updation Succesfull !!");
		   }
			else
				System.out.println("Oops...Invalid Choice");
			System.out.println();
			
			
			
	  }
	 
}
