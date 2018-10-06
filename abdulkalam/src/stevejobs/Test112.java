package stevejobs;

import java.util.Scanner;

public class Test112
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter CC type");
		String cc=sc.nextLine();
		switch(cc)
		{
		case "Visa":
			System.out.println("Valid card");                   
			break;
		case "Master":
			System.out.println("valid card");
			break;
		case "American express":
			System.out.println("valid card");
			break;
		default:
			System.out.println("Wrong card");
			break;
		}
		
		

	}

}







