package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Sample6 
{
	//Data members
	public ChromeDriver driver;
	//Constructor method
	public Sample6()
	{
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	public void launch(String u)
	{
		driver.get(u);
	}
	public void close()
	{
		driver.close();
	}
}



