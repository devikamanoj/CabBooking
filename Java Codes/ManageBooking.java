import java.util.*;
import java.io.*;
public class ManageBooking implements Serializable
{
	static String PickupCity;
	static String DestinationCity;
	String BookingID;
	static ArrayList<ManageBooking> Booking = new ArrayList();
    static File f = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\bookings.dat");
    static ObjectOutputStream out = null;
	static Scanner in = new Scanner(System.in);
	static int choice;
	
	ManageBooking(String pickupCity, String destinationCity)
	{
		this.PickupCity = pickupCity;
		this.DestinationCity = destinationCity;
	
	}
	 static void CancelBooking()
	 {
		 for(ManageBooking booking:Booking)
	    	{
	    		System.out.print("Enter the id of the customer: ");
	    		String id1 =in.next();
				if(booking.BookingID==id1)
	    		{
	    			Booking.remove(booking);
	    			break;
	    		}
				break;
			}
	 }
	 static void EditBooking()
	 {
		 System.out.print("Enter Pickup location: ");
		 String loc=in.next();
	    	System.out.print("Enter Destination: ");
	    	String dest=in.next();
	    	
	    	ManageBooking ChangedBooking = new ManageBooking(loc,dest);
	        Booking.add(ChangedBooking);
	 }
	 static void writeData()
	 {
	        try
	        {
	            out = new ObjectOutputStream(new FileOutputStream(f));
	            for (ManageBooking i : Booking) out.writeObject(i);
	            
	            out.close();

	        } 
	        catch (FileNotFoundException e) 
	        {
	            System.out.println("File Not Found");
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	 }
	 public String toString()
	 {
			return "YOUR BOOKING \n\n Pickup City: " + PickupCity + "\n Destination City: " + DestinationCity ;
	}
	static void ShowBooking()
	 {
		 System.out.println("Pick up City: "+PickupCity);
		 System.out.println("Desttination city: "+DestinationCity);
		 
	 }
	public static void main(String[] args)
	{
		File f = new File("bookings.dat");
		try
		{
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(f));
            Booking.clear();
            while (true)
            {
                Booking.add((ManageBooking) read.readObject());
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
		
		System.out.println("Do you want to: \n 1. Cancel Booking \n 2. Edit Booking \n 3. Show Booking ");
		choice = in.nextInt();
		switch (choice)
		{
			case 1:
			{
				ManageBooking.CancelBooking();
				System.out.println("THANKYOU \n HAVE A NICE DAY");
				break;
			}
			case 2:
			{
				ManageBooking.EditBooking();
				ManageBooking.ShowBooking();
				System.out.println("\n THANKYOU \n HAVE A NICE DAY");
				break;
			}
			case 3:
			{
				ManageBooking.ShowBooking();
				break;
			}
			default:
			{
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
