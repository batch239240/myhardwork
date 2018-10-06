package stevejobs;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import com.sun.glass.events.KeyEvent;
public class Test65
{
	public static void main(String[] args) throws Exception
	{
		//Launch site(SWD)
		System.setProperty("webdriver.gecko.driver",
			     "E:\\batch240\\geckodriver.exe");          
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.seleniumhq.org/");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                      By.linkText("Download")));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Download")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				        By.xpath("(//*[text()='3.13.0'])[1]")));
		driver.findElement(By.xpath(
				          "(//*[text()='3.13.0'])[1]")).click();
		//Automate file download pop-window(Java Robot) 
		Thread.sleep(5000);
		Robot r=new Robot();
		for(int i=1;i<=2;i++)
		{
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(5000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//Open downloads window
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_J);
		r.keyRelease(KeyEvent.VK_J);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		//wait for complete download(SikuliX)
		while(2>1)
		{
			Screen s=new Screen();
			if(s.exists("close.png")!=null)
			{
				continue;
			}
			else
			{
				break;
			}
		}
		//close site
		driver.close();
	}
}





