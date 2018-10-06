package stevejobs;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test64
{
	public static void main(String[] args) throws Exception
	{
		//Launch gmail site(SWD)
		System.setProperty("webdriver.chrome.driver", 
				"E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                       By.name("identifier")));
		driver.manage().window().maximize();
		//Do Login(SWD)
		driver.findElement(By.name("identifier"))
		                              .sendKeys("gopirowthu9");
		driver.findElement(By.xpath("//*[text()='Next']"))
		                               .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                         By.name("password")));
		driver.findElement(By.name("password")).sendKeys("xx");
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                             .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				           By.xpath("//*[text()='COMPOSE']")));
		//Click compose(SWD)
		driver.findElement(By.xpath("//*[text()='COMPOSE']"))
		                                              .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
                                               By.name("to")));
		//Fill fields(SWD)
		driver.findElement(By.name("to")).sendKeys(
				                        "apj@abdulkalam.com");
		driver.findElement(By.name("subjectbox")).sendKeys(
				                                   "wishes");
		driver.findElement(By.xpath(
				"(//*[@aria-label='Message Body'])[2]"))
		     .sendKeys("Hi sir,\nHow are you in heaven?\nBye");
		//Click on attachments link(SWD)
		driver.findElement(By.xpath(
		  "//*[@aria-label='Attach files']/descendant::*[3]"))
													.click();
		//Browse file path to upload(Java Robot)
		Thread.sleep(5000); //for pop-up window
		StringSelection s=new StringSelection(
		    "C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                                .setContents(s,null);
		Robot r=new Robot();
		if(System.getProperty("os.name").contains("Windows"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_META);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		else
		{
			System.out.println("Wrong platform");
			driver.close();
			System.exit(0); //0 means forcibly
		}
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//Send mail(SWD)
		w.until(ExpectedConditions.visibilityOfElementLocated(
		   By.xpath("//*[contains(@aria-label,'Press enter to view the attachment and delete')]")));
		driver.findElement(By.xpath("//*[text()='Send']"))
		                                             .click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[contains(text(),'Your message has been sent')]")));
		//Do logout(SWD)
		driver.findElement(By.xpath(
			  "//*[contains(@title,'Google Account')]/span"))
													.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                     By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		//Close site(SWD)
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                        By.name("password")));
		driver.close();
	}
}









