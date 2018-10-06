package stevejobs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test29
{
	public static void main(String[] args) 
	{
		SimpleDateFormat f=new SimpleDateFormat("dd/MMM/yyyy");  
	    Date d=new Date();  
	    String y=f.format(d); //today date
	    System.out.println(y);

	}

}
