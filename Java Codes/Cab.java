import java.io.*;
import java.util.*;
public class Cab implements Serializable
{
	String model, color;
	int noOfSeats;
	boolean acStatus;
	String regNo;
	
	static int ch1,c2,f2;
	static int choice2;
	static ArrayList<Cab>Cars=new ArrayList(); 
	static File fcab=new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\Cabdetails.dat");  //to be changed
	static ObjectOutputStream output = null;
	static Scanner in = new Scanner(System.in);
	
	Cab(String model, String regNo, String color, int noOfSeats,boolean acStatus)
	{
		this.model = model;
		this.regNo = regNo;
		this.color = color;
		this.noOfSeats = noOfSeats;
		this.acStatus = acStatus;
	}
	public  String getRegNo()
	{
		return regNo;
	}
	public static void newCab() 
	{
		System.out.print("Enter the model: ");
		String model = in.next();
		System.out.print("Enter the registration number: ");
		String regNo = in.next();
		System.out.print("Enter the color: ");
		String color = in.next();
		System.out.print("Enter the number of seats: ");
		int noOfSeats = in.nextInt();
		System.out.print("Enter the AC status: ");
		Boolean acStatus = in.nextBoolean();
	
		Cab Cars1= new Cab(model, regNo, color,noOfSeats,acStatus);
	    Cars.add(Cars1); 
		System.out.println();
		System.out.println("Successfully Completed Addition Of A New Cab !");
	}
	static void updateCab()
	{
		System.out.println("Enter Registration number of the cab to be updated");
		String rn = in.next();
	    f2=0;
		for(int i=0;i<Cab.Cars.size();i++)
		{
			if(Cab.Cars.get(i).getRegNo().contains(rn))
			{
				c2=i;
				f2=1;
				break;
			}
		      
		else
			{
				f2=0;
			}
		}
		
		if(f2==1)
		{	
	    System.out.println();
		System.out.println("Cab with Registration Number " + rn+ " Found.");
		System.out.print("\n");
		System.out.println("_____________");
		System.out.println("   MODIFY");
		System.out.println("_____________");
		System.out.println("1.Model \n2.Register Number \n3.Colour \n4.Number of Seats  \n5.AC Status");
		System.out.println();
		System.out.println("Which Among This Do You Want To Modify?");
		ch1=in.nextInt();
		if(ch1==1)
		{
			String newmodel;
		    System.out.println("Enter Modified Model -");
		    newmodel=in.next();
		    Cab nm=new Cab(newmodel,Cab.Cars.get(c2).getRegNo(),Cab.Cars.get(c2).color,Cab.Cars.get(c2).noOfSeats,Cab.Cars.get(c2).acStatus);
		    Cab.Cars.set(c2,nm);
		    Cab.writeData();
		    System.out.println();
		    System.out.println("Modification Successfull !");
		}
		else if(ch1==2)
		{
			String newreg;
		    System.out.println("Enter Modified Register Number -");
		    newreg=in.next();
		    Cab nr=new Cab(Cab.Cars.get(c2).model,newreg,Cab.Cars.get(c2).color,Cab.Cars.get(c2).noOfSeats,Cab.Cars.get(c2).acStatus);
		    Cab.Cars.set(c2,nr);
		    Cab.writeData();
		    System.out.println();
		    System.out.println("Modification Successfull !");
		}
		else if(ch1==3)
		{
			String newcolor;
		    System.out.println("Enter Modified Colour -");
		    newcolor=in.next();
		    Cab ncl=new Cab(Cab.Cars.get(c2).model,Cab.Cars.get(c2).getRegNo(),newcolor,Cab.Cars.get(c2).noOfSeats,Cab.Cars.get(c2).acStatus);
		    Cab.Cars.set(c2,ncl);
		    Cab.writeData();
		    System.out.println();
		    System.out.println("Modification Successfull !");
			
		}
		else if(ch1==4)
		{
			int newseat;
		    System.out.println("Enter Modified Number Of Seats -");
		    newseat=in.nextInt();
		    Cab ns=new Cab(Cab.Cars.get(c2).model,Cab.Cars.get(c2).getRegNo(),Cab.Cars.get(c2).color,newseat,Cab.Cars.get(c2).acStatus);
		    Cab.Cars.set(c2,ns);
		    Cab.writeData();
		    System.out.println();
		    System.out.println("Modification Successfull !");
		
		}
		else if(ch1==5)
		{
			boolean newac;
		    System.out.println("Enter Modified Ac Status -");
		    newac=in.nextBoolean();
		    Cab na=new Cab(Cab.Cars.get(c2).model,Cab.Cars.get(c2).getRegNo(),Cab.Cars.get(c2).color,Cab.Cars.get(c2).noOfSeats,newac);
		    Cab.Cars.set(c2,na);
		    Cab.writeData();
		    System.out.println();
		    System.out.println("Modification Successfull !");
		}
		else
			System.out.println("Oops..Invalid Choice");
		
		}
		else if(f2==0)
			System.out.println("Oops..Cab with Registration Number " + rn + " Not Found.");
			
	}
	static void writeData()
	{
		try 
		{
			output=new ObjectOutputStream(new FileOutputStream(fcab));
			for(Cab i:Cars)
				output.writeObject(i);
				output.close();
		}
		catch (FileNotFoundException e)
		{
			
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	public String toString() 
	{
		return "\n\n  CAB \n \n Model = " + model + "\n Colour= " + color + " \n Number of Seats = " + noOfSeats+ "\n AC Status = "+ acStatus + "\n Registered Number= " +regNo ;
	}
	

	public static void ContinueChecking()
	{
		System.out.println();
		System.out.println("Do you want to Continue: ");
		 System.out.println("1. Yes");
		 System.out.println("2. No");
		 choice2 = in.nextInt();
		
	}
	
	public static void driver()
	{   
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
			String register;
		int m=0,n=0;
		System.out.println("Enter The Register Number Of The Cab -");
		register=in.next();
		
		for(int i=0;i<NewDriver.Drivers.size();i++)
		{
		if(NewDriver.Drivers.get(i).RegisteredNumber.contains(register))
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
		{   System.out.println();
			System.out.println("Cab with Registration Number " + register+ " Found.");
			System.out.println();
			System.out.println("Details Of The Driver Of Cab "+register+" - ");
			System.out.println("------------------------------------------");
			System.out.println("ID           - "+NewDriver.Drivers.get(m).ID);
			System.out.println("Name         - "+NewDriver.Drivers.get(m).Name);
			System.out.println("Gender       - "+NewDriver.Drivers.get(m).Gender);
			System.out.println("Phone Number - "+NewDriver.Drivers.get(m).PhoneNumber);
			
		}
		else
			System.out.println("Oops..Cab with Registration Number " + register+ " Not Found");
			
	}
}
