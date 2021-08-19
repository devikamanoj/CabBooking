import java.util.*;
import java.io.*;
public class NewDriver implements Serializable 
{
	String Name;
	String PhoneNumber;
	String Address;
	String Gender;
	String RegisteredNumber;
	int ID;
	static int ch,c1,f1,choiced;

	static ArrayList<NewDriver>Drivers=new ArrayList(); 
	static File f=new File("D:\\Users\\devik\\eclipse-workspace\\CarBooking\\src\\Drivers.dat"); // to be changed 
	static ObjectOutputStream output = null;
	static Scanner in = new Scanner(System.in);
	
	NewDriver(String Name, String Phno, String Address,String Gender, String Regno, int id)
	{   
		this.Name=Name;
		this.PhoneNumber=Phno;
		this.Address=Address;
		this.Gender=Gender;
		this.RegisteredNumber=Regno;
		this.ID=id;
	}
	
	public  int getid()
	{
		return ID;
	}
	
	public static void AddDetails()
	{
        System.out.println();
		System.out.print("Name: ");
		String name = in.nextLine();
		System.out.print("Phone Number: ");
		String ph = in.nextLine();
		System.out.print("Address: ");
		String Add = in.nextLine();
		System.out.print("Gender: ");
		String Gen = in.nextLine();
		System.out.print("Register Number Of Your Cab : ");
		String Regno = in.nextLine();
		System.out.print("ID: ");
		int id = in.nextInt();		
		
		for(NewDriver driver:Drivers)
    	{
    		if(driver.ID==id)
    			System.out.println("Driver with ID " + id + " already exists. ID: " + driver.ID);
    	}
		
        NewDriver D = new NewDriver(name,ph,Add,Gen,Regno,id);
        Drivers.add(D); 
        System.out.println();
        System.out.println("ADDITION OF A NEW DRIVER SUCCESFULL!!");
        
	}
	
	static void modifydata()
	{
		System.out.println("Enter ID of the driver to be updated");
		int id = in.nextInt();
        f1=0;
		for(int i=0;i<NewDriver.Drivers.size();i++)
		{
		if(NewDriver.Drivers.get(i).getid()==id)
		{
			c1=i;
			f1=1;
			break;
	    }
		
		else
		{
			f1=0;
		}
		}
		if(f1==1)
	{	System.out.println("Driver with ID " + id + " Found.");
		System.out.println();
		System.out.println("--------------");
	    System.out.println("   MODIFY");
	    System.out.println("--------------");
	    System.out.println("1.Name\n2.Phonenumber\n3.Address\n4.Gender\n5.Register Number Of Cab\n6.ID");
		System.out.println("Which Among These Do You Want To Modify?");
		ch=in.nextInt();
		
		if(ch==1)
		{   
			System.out.print("Enter Modified Name: ");
			String nname = in.next();
			NewDriver nd=new NewDriver(nname,NewDriver.Drivers.get(c1).PhoneNumber,NewDriver.Drivers.get(c1).Address,NewDriver.Drivers.get(c1).Gender,NewDriver.Drivers.get(c1).RegisteredNumber,id);
			Drivers.set(c1,nd);
			NewDriver.writeData();
			System.out.println("MODIFICATION SUCESSFULL !");
		
		}
		else if(ch==2)
		{
			System.out.print("Enter Modified Phonenumber: ");
			String nnum = in.next();
			NewDriver np=new NewDriver(NewDriver.Drivers.get(c1).Name,nnum,NewDriver.Drivers.get(c1).Address,NewDriver.Drivers.get(c1).Gender,NewDriver.Drivers.get(c1).RegisteredNumber,id);
			Drivers.set(c1,np);
			NewDriver.writeData();
			System.out.println("MODIFICATION SUCESSFULL !");
		}
		else if(ch==3)
		{
			System.out.print("Enter Modified Address: ");
			String nadd = in.next();
			NewDriver na=new NewDriver(NewDriver.Drivers.get(c1).Name,NewDriver.Drivers.get(c1).PhoneNumber,nadd,NewDriver.Drivers.get(c1).Gender,NewDriver.Drivers.get(c1).RegisteredNumber,id);
			Drivers.set(c1,na);
			NewDriver.writeData();
			System.out.println("MODIFICATION SUCESSFULL !");
		}
		else if(ch==4)
		{
			System.out.print("Enter Modified Gender: ");
			String ngen = in.next();
			NewDriver ng=new NewDriver(NewDriver.Drivers.get(c1).Name,NewDriver.Drivers.get(c1).PhoneNumber,NewDriver.Drivers.get(c1).Address,ngen,NewDriver.Drivers.get(c1).RegisteredNumber,id);
			Drivers.set(c1,ng);
			NewDriver.writeData();
			System.out.println("MODIFICATION SUCESSFULL !");
		}
		else if(ch==5)
		{
			System.out.print("Enter Modified Register Number Of Your Cab: ");
			String nreg = in.next();
			NewDriver nr=new NewDriver(NewDriver.Drivers.get(c1).Name,NewDriver.Drivers.get(c1).PhoneNumber,NewDriver.Drivers.get(c1).Address,NewDriver.Drivers.get(c1).Gender,nreg,id);
			Drivers.set(c1,nr);
			NewDriver.writeData();
			System.out.println("MODIFICATION SUCESSFULL !");
		}
		else if(ch==6)
		{
			System.out.print("Enter New Id: ");
			int nid = in.nextInt();
			NewDriver ni=new NewDriver(NewDriver.Drivers.get(c1).Name,NewDriver.Drivers.get(c1).PhoneNumber,NewDriver.Drivers.get(c1).Address,NewDriver.Drivers.get(c1).Gender,NewDriver.Drivers.get(c1).RegisteredNumber,nid);
			Drivers.set(c1,ni);
			NewDriver.writeData();
			System.out.println("MODIFICATION SUCESSFULL !");
		}
		else
			System.out.println("Oops..Invalid choice!");
	}	
		else
			System.out.println("Driver with ID " + id + " Not Found.");
	}
	static void writeData()
	{
		try 
		{
			output=new ObjectOutputStream(new FileOutputStream(f));
			for(NewDriver i: Drivers)
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
	//Override
	public String toString() 
	{
		return "\n\n  NewDriver \n \n Name=" + Name + "\n PhoneNumber=" + PhoneNumber + " \n Address=" + Address + "\n Gender="
				+ Gender + "\n Register Number Of Cab=" + RegisteredNumber + "\n ID=" + ID ;
	}


}