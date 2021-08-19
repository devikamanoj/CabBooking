import java.util.*;
import java.io.*;

public class SearchCab
{
	static Scanner in=new Scanner(System.in);
	   String cabmodel;
	   static String cabreg;
	   static int seat;
	   
	   
	   public static void selectcab()
	   {  System.out.println();
	      System.out.println(" -----  WELCOME TO ONLINE BOOKING PLATFORM  ------");
	      System.out.println();
	      System.out.println();
		  System.out.println("How many seats should the cab have - ?");
		  seat=in.nextInt();
		  System.out.println();
		  System.out.println("  DETAILS OF CAB WITH "+seat+" SEATS");
		  System.out.println("--------------------------------------");
		  int flagcab=0;
		  for(int i=0;i<Cab.Cars.size();i++)
			{
			if(Cab.Cars.get(i).noOfSeats==seat)
			{
				System.out.println();
				System.out.println("CAB "+(i+1));
			    System.out.println("Registration Number   - "+Cab.Cars.get(i).regNo);
				System.out.println("Model                 - "+Cab.Cars.get(i).model);
				System.out.println("Colour                - "+Cab.Cars.get(i).color);
				System.out.println("Number Of Seats       - "+Cab.Cars.get(i).noOfSeats);
				System.out.println("AC Status             - "+Cab.Cars.get(i).acStatus);
				
		    }
			else
			{
				flagcab=1;
			}
			}
		  if(flagcab==1) 
		  {
			  System.out.println("Oops...No Cabs Available With "+seat+"Seats");
		  }
		  System.out.println();
		  System.out.println("Enter The Registration Number Of The Cab You Want To Book - ");
		  cabreg=in.next();

		   System.out.println();
		   System.out.println("Selection Of Cab Successfull !");
		 }
	   
	   public static void showselectedcab()
	   {  
		   System.out.println();
		   System.out.println("  THE CAB YOU SELECTED IS - ");
		   System.out.println("------------------------------");
		   System.out.println();
		   for(int i=0;i<Cab.Cars.size();i++)
			{
			if(Cab.Cars.get(i).regNo.contains(cabreg))
			{
				System.out.println("CAB "+(i+1));
			    System.out.println("Registration Number   - "+Cab.Cars.get(i).regNo);
				System.out.println("Model                 - "+Cab.Cars.get(i).model);
				System.out.println("Colour                - "+Cab.Cars.get(i).color);
				System.out.println("Number Of Seats       - "+Cab.Cars.get(i).noOfSeats);
				System.out.println("AC Status             - "+Cab.Cars.get(i).acStatus);
				break;
				
		    }
		
			}
	   }
}
