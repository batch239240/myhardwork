package stevejobs;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class W2smsmethods 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public String launch(String e, String d, String c) 
			                          throws Exception
	{
		if(e.equals("chrome"))
		{
		  System.setProperty("webdriver.chrome.driver",
					"E:\\batch240\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(e.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"E:\\batch240\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(e.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"E:\\batch240\\iedriverserver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(e.equals("opera"))
		{
			OperaOptions oo=new OperaOptions();
			oo.setBinary(
		  "C:\\Program Files\\Opera\\53.0.2907.68\\opera.exe");
			System.setProperty("webdriver.opera.driver",
		  "E:\\batch239\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver(oo);
		}
		else
		{
			return("Unknown browser");
		}
		driver.get(d);
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions
		 .visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		return("Done");
	}
	public String fill(String e, String d, String c) 
			                               throws Exception
	{
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).sendKeys(d);
		return("Done");
	}
	public String click(String e, String d, String c) 
			                              throws Exception
	{
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(e)));
		driver.findElement(By.xpath(e)).click();
		return("Done");
	}
	public String validateLogin(String e, String d, 
			                 String c) throws Exception
	{
		try
		{
		if(c.equals("all_valid") && 
				driver.findElement(By.xpath(
				"//*[text()='Send SMS']")).isDisplayed())
		{
			return("Passed");
		}
		else if(c.equals("mbno_blank") && 
				driver.findElement(By.xpath(
			 "//*[text()='Enter your mobile number']"))
				.isDisplayed())
		{
			return("Passed");
		}
		else if(c.equals("mbno_invalid")
				&& driver.findElement(By.xpath(
      "(//*[contains(text(),'number is not register')])[1]"))
				.isDisplayed())
		{
			return("Passed");
		}
		else if(c.equals("pwd_blank") && 
			driver.findElement(By.xpath(
			"(//*[text()='Enter password'])[1]"))
			.isDisplayed())
		{
			return("Passed");
		}
		else if(c.equals("pwd_invalid")
				&& driver.findElement(By.xpath(
			"(//*[contains(text(),'Try Again')])[1]"))
				.isDisplayed())
		{
			return("Passed");
		}
		else
		{
			String temp=this.screenshot();
			return("Test Failed & goto "+temp+".png");
		}
		}
		catch(Exception ex)
		{
			String temp=this.screenshot();
			return("Test interrupted & goto "+temp+".png");
		}	
	}
	public String closeSite(String e, String d, String c)
			                              throws Exception
	{
		driver.close();
		return("Done");		
	}
	public String screenshot() throws Exception
	{
		Date dt=new Date();
		SimpleDateFormat df=
			new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String ssname=df.format(dt);
		File src=((TakesScreenshot)driver)
				.getScreenshotAs(OutputType.FILE);
		File dest=new File(ssname+".png");
		FileUtils.copyFile(src,dest);
		return(ssname);
	}
}
