package stevejobs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Test121
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(temp->((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
		driver.manage().window().maximize();
		driver.close();
	}
}
