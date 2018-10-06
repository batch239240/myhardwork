package stevejobs;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver",
				     "E:\\batch240\\geckodriver.exe");          
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.gmail.com");
	}
}









