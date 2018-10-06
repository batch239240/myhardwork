package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test108 
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Userid");
		String u=sc.nextLine();
		System.out.println("Enter Userid criteria");
		String uc=sc.nextLine();
		String p="";
		String pc="";
		if(uc.equals("valid"))
		{
			System.out.println("Enter password");
			p=sc.nextLine();
			System.out.println("Enter password criteria");
			pc=sc.nextLine();
		}
		//Create html results file
		ExtentReports er=new ExtentReports("gmailres.html",
                                                   false);
		ExtentTest et=er.startTest("Gmail login testing");
		//Launch site
		System.setProperty("webdriver.chrome.driver",
			       "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com"); 
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys(u);
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                        .click();
		Thread.sleep(5000);
		//Validations
		try
		{
			//Userid testing
			if(u.length()==0 && driver.findElement(By.xpath(
				"//*[contains(text(),'Enter an email')]"))
				.isDisplayed())
			{
				et.log(LogStatus.PASS,"Blank uid test passed");
			}
			else if(uc.equals("invalid") && 
					driver.findElement(By.xpath(
			 "(//*[contains(text(),'find your Google Account')])[2]"
							)).isDisplayed())
			{
				et.log(LogStatus.PASS,"Invalid uid test passed");
			}
			else if(uc.equals("valid") && driver.findElement(
				       By.name("password")).isDisplayed())
			{
				et.log(LogStatus.PASS,"Valid uid test passed");
				//Password testing
				driver.findElement(By.name("password")).sendKeys(p);
				driver.findElement(By.xpath("//*[text()='Next']"))
            										.click();
				Thread.sleep(5000);
				if(p.length()==0 && driver.findElement(By.xpath(
				  "//*[text()='Enter a password']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank pwd test passed");
				}
				else if(pc.equals("invalid") && driver.findElement(
            	By.xpath("//*[contains(text(),'Wrong password')]"))
            		.isDisplayed())
				{
				  et.log(LogStatus.PASS,"Invalid pwd test passed");
				}
				else if(pc.equals("valid") && driver.findElement(
				  By.xpath("//*[text()='Compose']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Valid pwd test passed");
				}
				else
				{
					//get screen shot
					SimpleDateFormat sf=new SimpleDateFormat(
					                      "dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String ssname=sf.format(d);
					File src=driver.getScreenshotAs(
						                     OutputType.FILE);
					File dest=new File(ssname+".png");
					FileUtils.copyFile(src,dest);
					et.log(LogStatus.FAIL,
						"Pwd test failed"+
			             et.addScreenCapture(ssname+".png"));
				}	
			} //else if closing
			else
			{
				//get screen shot
				SimpleDateFormat sf=new SimpleDateFormat(
				                      "dd-MM-yy-hh-mm-ss");
				Date d=new Date();
				String ssname=sf.format(d);
				File src=driver.getScreenshotAs(
					                     OutputType.FILE);
				File dest=new File(ssname+".png");
				FileUtils.copyFile(src,dest);
				et.log(LogStatus.FAIL,"Uid test failed"+
		             et.addScreenCapture(ssname+".png"));
			}
		}
		catch(Exception ex)
		{
			//get screen shot
			SimpleDateFormat sf=new SimpleDateFormat(
					                     "dd-MM-yy-hh-mm-ss");
			Date d=new Date();
			String ssname=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.ERROR,"Gmail login test interrupted"+
			               et.addScreenCapture(ssname+".png"));
		}
		//Close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
	}
}
