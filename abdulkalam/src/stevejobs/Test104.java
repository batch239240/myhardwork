package stevejobs;
import java.util.Scanner;
public class Test104
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		if(x%2==0)
		{
			System.out.println(x+" is even number");
		}
		else
		{
			System.out.println(x+" is odd number");             
		}	
	}
}




