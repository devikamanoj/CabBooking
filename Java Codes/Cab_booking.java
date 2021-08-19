import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Cab_booking
{   
       static Scanner in=new Scanner(System.in);
       static ObjectOutputStream out = null;
   
	   public static void starting()                                                           
	{    int choice;
	     System.out.println("\n");
	     System.out.println("****************************************");
	     System.out.println("  WELCOME TO ONLINE CAB BOOKING SYSTEM");
	     System.out.println("****************************************");
	     System.out.println("\n1. Admin");
	     System.out.println("2. Customer");
	     System.out.println();
	     System.out.println("Are you admin or a customer? ");
	     System.out.println("Enter Your Choice - ");
	     choice=in.nextInt();
	     if(choice==1)
	     {
	    	adminlogin(); 
	     }
	     else if(choice==2)
	     {       int choice1,trying;
	    	 do {
	    	     System.out.println("\n");
	    	     System.out.println("=============");
	    	     System.out.println("  CUSTOMER");
	    	     System.out.println("=============");
	    	     System.out.println("1.Sign Up");
	    	     System.out.println("2.Log In ");
	    	     System.out.println();
	    	     System.out.println("Enter Your Choice - ");
	    	     choice1=in.nextInt();
	    	     if(choice1==1)
	    	     {
	    		   newcustomer();
	    	     }
	    	     else if(choice1==2)
	    	     {     
	    	    	 customerfunctions();
	    	     }
	    	     else
	    	     {
	    	    	     System.out.println("Oops..This is an invalid choice");
	    	     }
	    	     System.out.println();
	    	     System.out.println("Press 1 Continue As A Customer And Sign up/Log In Again");
	    	     trying=in.nextInt();
	    	 }while(trying==1);
	    	 
	    	 if(trying!=1)
	    	 {
	    		 System.out.println("\nExiting From The System.....\nThank You\nHave A Good Day :)");
	    	 }
	     }
	     else
	     {
	    	     System.out.println("Oops..This is an invalid choice");
	    	     System.out.println("\nExiting From The System.....\nThank You\nHave A Good Day :)");
	     }
	     
	}
	
	   
	   
	public static void adminlogin()                                                            
	{   int wish1,flag1=1;
    do {
    	String admin_uid="admin1234";
		String admin_pass="admin1234";
		String a_uid,a_pass;
		System.out.println();
		System.out.println();
		System.out.println("--You need a Username and Password to login as an Admin--");
		System.out.println();
		System.out.println("Enter Username - ");
		a_uid=in.next();
		System.out.println("Enter Password - ");
		a_pass=in.next();
		System.out.println("\nLOADING....");
		wait(2000);
		if(admin_uid.equals(a_uid)&&admin_pass.equals(a_pass))
		{  System.out.println("Login Successfull !!");
		   System.out.println();
		   adminworking(); 
		}
		else 
		{
			flag1=0;
			System.out.println("Invalid Username or Password!!");
		}
		
		System.out.println("Do You Wish To Continue As An Admin ? If Yes Press 1");
		wish1=in.nextInt();
	   }while(wish1==1);
       if(wish1!=1)
 	   System.out.println("THANK YOU :) ");
		
		
	}
	
	
	public static void adminworking()                                                           
	{   int choice3;
	    System.out.println();
	    System.out.println();
	    System.out.println("=========");
	    System.out.println(" ADMIN");
	    System.out.println("=========");
		System.out.println("1.Manage Cabs");
		System.out.println("2.Manage Drivers");
		System.out.println("3.Display Customers List");
		System.out.println();
		System.out.println("Enter Your Choice - ");
		choice3=in.nextInt();
		if(choice3==1)
		{
			cabstarting();
			ContinueCheckingCab();
			while(Cab.choice2==1)
			{
				cabstarting();
				ContinueCheckingCab();
			}
			while(Cab.choice2>1)
			{
				System.out.println("");
				break;
			}
			 Cab.writeData();
		}
		
		else if(choice3==2)
		{
			 EnterDriverDetails();
			 NewDriver.writeData();
		}
		else if(choice3==3)
		{
			System.out.println(NewCustomer.customerlist);
		}
		else
			System.out.println("Invalid choice");
	}
	
	
	
	public static void EnterDriverDetails()                                               
	{   System.out.println();
		System.out.println("-------------------");
		System.out.println("    DRIVER  ");
		System.out.println("-------------------");
		System.out.println();
		System.out.println("1. View Drivers Available");
		System.out.println("2. Add A New Driver");
		System.out.println("3. Modify Details Of A Driver");
		System.out.println();
		System.out.println("Enter choice: ");
		int choice = in.nextInt();
	      switch (choice)
	      {
	      	case 1:
	      	{
	      		System.out.println(NewDriver.Drivers);
	      		ContinueCheckingDriver();
	      		while(NewDriver.choiced==1)
				{
	      			EnterDriverDetails();
					ContinueCheckingDriver();
				}
				while(NewDriver.choiced!=1)
				{
					System.out.println("");
					break;
				}
	            break;
	      	}
	      	case 2:
	      	{
	      		NewDriver.AddDetails();
	      		
	      		break;
	      	}
	      	case 3:
	      	{
	      		NewDriver.modifydata();
	      		
	      		break;
	      	}	
	      	default:
	      	{
	      		System.out.println("Oops..Invalid choice");
	      		break;
	      	}
	      }
	}
	
	
	public  static void newcustomer()
	{
		NewCustomer.AddDetails();
	    NewCustomer.writeData();
	    System.out.println("\nSIGNING UP SUCCESSFULL !\nPLEASE LOG IN AGAIN TO PROCEED FURTHER ");
	    System.out.println();
	    customerfunctions();   
	}

	
	public static void cabstarting()
	{
			System.out.println("\n");
			System.out.println("--------------");
			System.out.println("     CAB");
			System.out.println("--------------");
			System.out.println("1. View Details Of Cabs Available");
			System.out.println("2. Search For Details Of The Driver Of A Cab");
			System.out.println("3. Add A New Cab");
			System.out.println("4. Modify Details Of A Cab");
			System.out.println();
			System.out.println("Enter Your choice: ");
			int choice = in.nextInt();
		    switch (choice)
		    {
		      	case 1:
		      	{
		      		System.out.println(Cab.Cars);
		      		break;
		      	}
		      	case 2:
		      	{   
		      		cabanddriver();
		      		break;
		      	}
		      	case 3:
		      	{
		      		Cab.newCab();
		      		break;
		      	}
		      	case 4:
		      	{
		      		Cab.updateCab();
		      	    break;
		      	}	
		      
		      	default:
		      	{
		      		System.out.println("Oops..Invalid Choice");
		      	}
		    }

		}
	
	
	public static void ContinueCheckingCab()
	{
		System.out.println();
		System.out.println("Do you want to Continue With 'Manage Cabs'? ");
		 System.out.println("1. Yes");
		 System.out.println("2. No");
		 Cab.choice2 = in.nextInt();	
	}
	
	
	public static void ContinueCheckingDriver()
	{
		System.out.println();
		System.out.println("Do you want to Continue With 'Manage Drivers'? ");
		 System.out.println("1. Yes");
		 System.out.println("2. No");
		 NewDriver.choiced = in.nextInt();
	}
	
	public static void cabanddriver()
	{
	Cab.driver();	
	}
	
	
	public static void customerfunctions()
	{
		int wishlogin;
		RegisteredCustomer.checking();
		if(RegisteredCustomer.flag==1)
		{
    	do {    
    		
    		int choice2;
    		System.out.println("==============");
    		System.out.println("    OPTIONS");
    		System.out.println("==============");
    	 	System.out.println("1.Book A Cab");
    	 	System.out.println("2.Modify Your Details");
    		System.out.println("3.Show Your Details");
    		System.out.println();
    	 	System.out.println("Enter Your Choice - ");
    	 	choice2=in.nextInt();
    	 	if(choice2==1)
    	 	{
    	     bookingcab();
    	 	}
    	 	else if(choice2==2)
    	 	{
    	   	RegisteredCustomer.editdetails();
    	 	}
    	 	else if(choice2==3)
    	 	{
    	 	  RegisteredCustomer.showdetails();//done
    	 	}
    	 	else
    	 	System.out.println("Ooops....Invalid Choice !");
    	 	
    	 	System.out.println("Do you wish to continue with other options in Log In Tab? If yes,press 1 to continue");
    	 	wishlogin=in.nextInt();
    	}while(wishlogin==1);
    	
    	}
		
		 else
			 System.out.println("Oops..Invalid credentials");
	}
	
	
	public static void bookingcab()
	{
		  int choicecab,flagbooking=0;
		  SearchCab.selectcab();
		  SearchCab.showselectedcab();
		  Booking.AddBooking();
	      Booking.writeData();
	      System.out.println();
	      System.out.println("PROCESSING BOOKING ...");
	      wait(2500);
	      System.out.println();
	      System.out.println("   DETAILS REGARDING YOUR BOOKING");
	      System.out.println("======================================");
	      SearchCab.showselectedcab();
	      System.out.println();
	      Booking.ShowBooking();
	      
	      System.out.println();
	      System.out.println();
	      System.out.println("LOADING ...");
	      wait(2500);
	      System.out.println();
	      System.out.println("1. Modify Booking Details");
	      System.out.println("2. Cancel Booking");
	      System.out.println("3. Proceed To Payment");
	      System.out.println();
	      System.out.println("Enter Your Choice - ");
	      choicecab=in.nextInt();
	      if(choicecab==1)
	      {
	    	  modifybooking();
	      }
	      else if(choicecab==2)
	      {
	    	  ManageBooking.CancelBooking();
	    	  System.out.println();
	    	  System.out.println("LOADING ...");
		      wait(2500);
		      System.out.println("Canceling Booking Succesfull");
		      System.out.println();
		      System.out.println("Thank You");
			  System.out.println();
			  System.out.println("HAVE A GOOD DAY !!!");
		      
	    	  
	      }
	      else if(choicecab==3)
	      { Booking.driverdetails();
	        System.out.println();
	        System.out.println("BOOKING SUCCESFULL!!\n\nYOUR CAB WILL REACH AT THE PICK UP LOCATION WITHIN FEW MINUTES :)");
	        System.out.println();
	        System.out.println("..............");
	        wait(2500);
	        System.out.println();
	        System.out.println("REACHED DESTINATION SUCCESSFULLY !!\nHOPE YOU HAD A GREAT RIDE :)");
	        System.out.println();
	        System.out.println("PROCEEDING TO PAYMENT ...");
		    wait(2500);
	    	Payment.ShowPaymentDetails();
	    	bill();
	  		Payment.Pay();  
	      }
	      
	      else
	    	  System.out.println("Oops..Invalid Choice");
	}
	
	
	public static void modifybooking()
	{
		   int choicemod;
			ManageBooking.EditBooking();
			System.out.println();
			System.out.println();
			System.out.println("   DETAILS REGARDING YOUR BOOKING AFTER MODIFICATION ");
		    System.out.println("=======================================================");
		    SearchCab.showselectedcab();
		    System.out.println();
		    ManageBooking.ShowBooking();
		    System.out.println();
		    System.out.println();
		    System.out.println("LOADING ...");
		    wait(2500);
		    System.out.println();
		    System.out.println("1. Cancel Booking");
		    System.out.println("2. Proceed To Payment");
		    System.out.println();
		    System.out.println("Enter Your Choice - ");
		    choicemod=in.nextInt();
		    if(choicemod==1)
		    {
		    	  ManageBooking.CancelBooking();
		    	  System.out.println();
		    	  System.out.println("LOADING ...");
			      wait(2500);
			      System.out.println("Canceling Bokking Succesfull");
			      System.out.println();
			      System.out.println("Thank You");
				  System.out.println();
				  System.out.println("HAVE A GOOD DAY !!!");
		    }
		    
		    else if(choicemod==2)
		    {
		    	Booking.driverdetails();
		        System.out.println();
		        System.out.println("BOOKING SUCCESFULL!!\nYOUR CAB WILL REACH AT THE PICK UP LOCATION WITHIN FEW MINUTES :)");
		        System.out.println();
		        System.out.println("..............");
		        wait(2500);
		        System.out.println();
		        System.out.println("REACHED DESTINATION SUCCESSFULLY !!\nHOPE YOU HAD A GREAT RIDE :)");
		        System.out.println();
		        System.out.println("PROCEEDING TO PAYMENT ...");
			    wait(2500);
		    	Payment.ShowPaymentDetails();
		    	bill();
		  		Payment.Pay();  
		      }
		    else 
		    	System.out.println("Oops..Invalid Choice");	
	}
	
	
	
	public static void bill()
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("========================================================================================");
		System.out.println("                                         BILL  ");
		System.out.println("========================================================================================");
		System.out.println();
		System.out.println();
		System.out.println("Details Of Charges Taken");
		System.out.println();
		System.out.println("For 4 Seaters - ");
		System.out.println("       Initial Charge for 5km = Rs 20");
		System.out.println("       Per Km Charge After Distance Exceeds 5km = Rs 30");
		System.out.println();
		System.out.println("For 6 Seaters - ");
		System.out.println("       Initial Charge for 5km = Rs 25");
		System.out.println("       Per Km Charge After Distance Exceeds 5km = Rs 45");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("The Distance You Travelled  : "+Payment.distance+" Km");
		System.out.println("Your Total Price  :  Rs "+ Payment.Charges);
		System.out.println();
		System.out.println();
		System.out.println("========================================================================================");
		
	}
	
	
	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	
	public static void main(String[] args) 
{
	    File f = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\Customer.dat"); //to be changed
	   	try {
	           ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));
	           NewCustomer.customerlist.clear();
	           while (true)
	           {
	               NewCustomer.customerlist.add((NewCustomer) read.readObject());
	           }
	        }
	   	
	   	catch (FileNotFoundException e) 
	   	   {
	           System.out.println("File Not Found");
	       } 
	   	catch (IOException e) 
	   	  {   
	   	
	      } 
	   	catch (ClassNotFoundException e) 
	   	  {
	           e.printStackTrace();
	      }                                                                      
	   	
	   	File fdriver = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\Drivers.dat"); // to be changed
		try
		{
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(fdriver));
            NewDriver.Drivers.clear();
            while (true) {
                NewDriver.Drivers.add((NewDriver) read.readObject());
            }
		}
		catch (FileNotFoundException e)
		{
           
        } 
		catch (IOException e)
		{
			
        } 
		catch (ClassNotFoundException e) 
		{
            e.printStackTrace();
        }                                                                       
	 	
		File fcab1 = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\Cabdetails.dat");    //to be changed
		try
		{
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(fcab1));
            Cab.Cars.clear();
            while (true) {
                Cab.Cars.add((Cab) read.readObject());
            }
		}
		catch (FileNotFoundException e)
		{
           
        } 
		catch (IOException e)
		{
			
        } 
		catch (ClassNotFoundException e) 
		{
            e.printStackTrace();
        }                                                                   
		
		
		File fbook = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\bookings.dat");  // to be changed
		try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(fbook));
            Booking.bookings.clear();
            while (true) {
            	 Booking.bookings.add((Booking) read.readObject());
            }
		}
		
		catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }                                                                  
	   	starting();
	       
}
}

