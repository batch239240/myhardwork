package stevejobs;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
public class Test44
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String x=sc.nextLine();
		//Open our interested browser
		if(x.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
			          "E:\\batch240\\chromedriver.exe");    
			driver=new ChromeDriver();
		}
		else if(x.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
				     "E:\\batch240\\geckodriver.exe");          
			driver=new FirefoxDriver();
		}
		else if(x.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"E:\\batch240\\iedriverserver.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			OperaOptions o=new OperaOptions();
			o.setBinary(
			  "C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
			System.setProperty("webdriver.opera.driver",
				"E:\\batch240\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver(o);
		}
		//Launch site
		driver.get(
			  "https://semantic-ui.com/modules/dropdown.html"); 
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                    TimeUnit.SECONDS);
		//Open multi-select drop-down(mandatory)
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath(
			"(//*[contains(@class,'selection multiple')])[1]"));
		a.click(e).build().perform();
		Thread.sleep(5000); 
		//Get all items and display
		List<WebElement> il=driver.findElements(By.xpath(
				 "//*[@class='menu transition visible']/div"));
		for(int i=0;i<il.size();i++)
		{
			System.out.println(il.get(i).getText());
		}
		Thread.sleep(5000);
		//Select multiple items(1st item and 18th item)
		driver.findElement(By.xpath(
			  "//*[@class='menu transition visible']/div[1]"))
		      .click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
			  "//*[@class='menu transition visible']/div[18]"))
				.click();
		Thread.sleep(5000);
		//De-select 1st item
		driver.findElement(By.xpath(
				"//*[contains(@class,'active visible') or contains(@class,'upward active visible')]/a[1]/i")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}






