package stevejobs;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test42
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html"); 
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                  TimeUnit.SECONDS);
		//Get all items
		List<WebElement> il=driver.findElements(By.xpath("(//*[@class='menu'])[18]/div"));
		System.out.println(il.size());
		for(int i=0;i<il.size();i++)
		{
			System.out.println(il.get(i).getAttribute("value"));
		}
		Thread.sleep(5000);

	}

}
