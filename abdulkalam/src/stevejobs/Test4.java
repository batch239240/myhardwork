package stevejobs;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test4 
{
	public static void main(String[] args)
	{
		OperaOptions o=new OperaOptions();
		o.setBinary(
		  "C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
		System.setProperty("webdriver.opera.driver",
			"E:\\batch240\\operadriver_win64\\operadriver.exe");
		OperaDriver driver=new OperaDriver(o);
		driver.get("http://www.google.co.in");

	}

}





