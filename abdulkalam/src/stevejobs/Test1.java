package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test1
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", 
				          "E:\\batch240\\chromedriver.exe");    
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
	}
}









