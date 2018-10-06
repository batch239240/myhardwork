package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test23
{
	public static void main(String[] args) throws InterruptedException
	{
		//Delete all existing cookies
		System.setProperty("webdriver.chrome.driver",
							"E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		//Open site
		driver.get("http://www.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Validate cookies were loaded
		if(driver.manage().getCookies().size()!=0)
		{
			System.out.println("Cookies were loaded");
		}
		else
		{
			System.out.println("Cookies were not loaded");
		}
		//close site
		driver.close();
		
		
		
		

	}

}
