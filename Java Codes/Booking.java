import java.io.*;
import java.util.*;
public class Booking implements Serializable
{
	String BookingId;
	static String PickupCity;
	static String DestinationCity;
	static ArrayList<Booking> bookings = new ArrayList();
    static File f = new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\bookings.dat"); // to be changed
    static ObjectOutputStream out = null;
    static Scanner sc = new Scanner(System.in);
	

	public Booking(String bookingId, String pickupCity, String destinationCity) {
		super();
		BookingId = bookingId;
		PickupCity = pickupCity;
		DestinationCity = destinationCity;
	}
	
	static void AddBooking() {
		System.out.println();
		System.out.println("LOADING....");
		Cab_booking.wait(2000);
		System.out.println();
		System.out.print("Enter Booking ID: ");
		String bId=sc.next();
		System.out.print("Enter Pickup location: ");
    	String loc=sc.next();
    	System.out.print("Enter Destination: ");
    	String dest=sc.next();

    	for(Booking book:bookings)
    	{
    		if(book.BookingId==bId)
    			System.out.println("Booking already done with ID " + bId);
    	}
    	
    	Booking Newbook = new Booking(bId,loc,dest);
        bookings.add(Newbook);
	}
	
	 public static void ShowBooking()
	 {
		 System.out.println("Pick up City          - "+PickupCity);
		 System.out.println("Destination city      - "+DestinationCity);
		 
	 }
	public static void driverdetails()
	{   
		int m=0,n=0;
		for(int i=0;i<NewDriver.Drivers.size();i++)
		{
		if(NewDriver.Drivers.get(i).RegisteredNumber.contains(SearchCab.cabreg))
		{
			m=i;
			n=1;
			break;
			
	    }
		
		else
		{
			n=0;
		}
		}
		
		if(n==1)
		{  
			System.out.println();
			System.out.println( "      DETAILS OF THE DRIVER OF CAB "+SearchCab.cabreg+" - ");
			System.out.println("------------------------------------------");
			System.out.println("ID           - "+NewDriver.Drivers.get(m).ID);
			System.out.println("Name         - "+NewDriver.Drivers.get(m).Name);
			System.out.println("Gender       - "+NewDriver.Drivers.get(m).Gender);
			System.out.println("Phone Number - "+NewDriver.Drivers.get(m).PhoneNumber);
			
		}
	}
	
	static void writeData() {
        try {
            out = new ObjectOutputStream(new FileOutputStream(f));
            for (Booking i : bookings) out.writeObject(i);
            
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	
	@Override
	public String toString() {
		return "Booking [BookingId=" + BookingId + ", PickupCity=" + PickupCity + ", DestinationCity=" + DestinationCity
				+ "]";
	}

}
