import java.util.Scanner;
public class Payment 
{
	static Scanner in =new Scanner(System.in);
	static double Charges,distance;
	static int seat;
	Payment(Payment p)
	{
		this.Charges=p.Charges; 
	}
	Payment()
	{
		this.Charges=0;
	}
	Payment(double charges)
	{
		this.Charges=charges;
	}
	public static void ShowPaymentDetails()
	{   System.out.println();
		System.out.print("Enter the seater: ");
		seat = in.nextInt();
		System.out.print("Enter The Distance Travelled (in Km) : ");
		distance = in.nextDouble();
		switch (seat)
		{
		case 4:
			{
				if(distance<=5)
				{
					Charges=20;
				}
				else
				{
					double dist;
					dist =(distance-5);
					Charges=(dist*30)+20;
				}
				break;
			}
		case 6:
			{
				if(distance<=5)
				{
					Charges=25;
				}
				else
				{
					double dist;
					dist =(distance-5);
					Charges=(dist*45)+25;
				}
				break;
			}
		default:
		{
			System.out.println("Invalid Choice");
		}
		}
	
	}
	public static void Pay()
	{
		System.out.println();
		System.out.println();
		System.out.println("PROCEEDING WITH PAYMENT..... ");
		Cab_booking.wait(2000);
		System.out.println("Your Payment is Successful !!!");
		System.out.println();
		System.out.println("Thank You For Using Our Service :)");
		System.out.println();
		System.out.println("HAVE A GOOD DAY !!!");
	}
}