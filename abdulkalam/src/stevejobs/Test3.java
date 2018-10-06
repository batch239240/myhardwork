package stevejobs;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test3 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.ie.driver",
				"E:\\batch240\\iedriverserver.exe");
		InternetExplorerDriver driver=new 
				                       InternetExplorerDriver();
		driver.get("http://www.facebook.com");
		
	}

}








