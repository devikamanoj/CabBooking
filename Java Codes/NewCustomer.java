import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NewCustomer implements Serializable 
{ 
String Username;
String Password;
String Name;
String Phonenumber;
static ArrayList<NewCustomer> customerlist = new ArrayList();
static File f = new File("Customer.dat");
static ObjectOutputStream out = null;
static Scanner sc = new Scanner(System.in);

NewCustomer(String Username,String Password,String Name,String Phonenumber)
{
	super();
	this.Username=Username;
	this.Password=Password;
	this.Name=Name;
	this.Phonenumber=Phonenumber;
}
public  String getuse()
{
	return Username;
}

public String getpass()
{
	return Password;
}

public static void AddDetails()
{
	System.out.print("Enter username: ");
	String use=sc.next();
	System.out.print("Enter password: ");
	String pass=sc.next();
	System.out.print("Enter Name: ");
	String name=sc.next();
	System.out.print("Enter Phonenumber: ");
	String ph=sc.next();
	
	for(NewCustomer customer:customerlist)
	{
		if(customer.Username==use)
			System.out.println("Customer with Username " + use + " already exists. Name: " + customer.Name);
	}
    NewCustomer Newcust = new NewCustomer(use,pass,name,ph);
    customerlist.add(Newcust);
				
}


public static void writeData()
{
    try {
        out = new ObjectOutputStream(new FileOutputStream(f));
        for (NewCustomer i : customerlist)
        	out.writeObject(i);
        
        out.close();

        } 
    catch(FileNotFoundException e)
    {
        System.out.println("File Not Found");
    } 
    catch (IOException e)
    {
        e.printStackTrace();
    }

}

public String toString() 
{
	return"{Username: "+Username+" Name: "+Name+" Phonenumber: "+Phonenumber+"}\n";
}


}
