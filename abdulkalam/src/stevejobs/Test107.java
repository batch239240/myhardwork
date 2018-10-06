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

public class Test107
{
	public static void main(String[] args) throws Exception
	{
		//Get data
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String mno=sc.nextLine();
		System.out.println("Enter criteria");
		String mnoc=sc.nextLine();
		System.out.println("Enter password");
		String p=sc.nextLine();
		System.out.println("Enter password criteria");
		String pc=sc.nextLine();
		//Create html results file
		ExtentReports er=new ExtentReports("w2smsres.html",
                                                   false);
		ExtentTest et=er.startTest("W2SMS login testing");
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				       "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com"); 
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("mobileNo")).sendKeys(mno);
		driver.findElement(By.name("password")).sendKeys(p);
		driver.findElement(By.xpath(
			 "(//*[contains(text(),'Login')])[2]")).click();
		Thread.sleep(5000);
		//Validations
		try
		{
			if(mno.length()==0 && driver.findElement(By.xpath(
			        "//*[text()='Enter your mobile number']"))
				    .isDisplayed())
			{
				et.log(LogStatus.PASS,
						   "Blank mobile number test passed");
			}
			else if(mno.length()<10 && driver.findElement(
			   By.xpath("//*[text()='Enter valid mobile number']"))
				.isDisplayed())
			{
				et.log(LogStatus.PASS,
						"Wrong size mobile number test passed");
			}
			else if(mnoc.equals("invalid") && driver.findElement(
			 By.xpath("(//*[contains(text(),'not register')])[1]"))
			 .isDisplayed())
			{
				et.log(LogStatus.PASS,
						"Invalid mobile number test passed");
			}
			else if(p.length()==0 && driver.findElement(By.xpath(
			   "(//*[text()='Enter password'])[2]")).isDisplayed())
			{
			   et.log(LogStatus.PASS,"Blank password test passed");
			}
			else if(pc.equals("invalid") && driver.findElement(
			  By.xpath("(//*[contains(text(),'Try Again')])[1]"))
			  .isDisplayed())
			{
				et.log(LogStatus.PASS,
						         "Invalid password test passed");
			}
			else if(mnoc.equals("valid") && pc.equals("valid") && 
			  driver.findElement(By.xpath("//*[text()='SendSMS']"))
			  .isDisplayed())
			{
			  et.log(LogStatus.PASS,"Valid mno & pwd test passed");
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
						"w2sms login test failed"+
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
			et.log(LogStatus.ERROR,"w2sms test interrupted"+
			               et.addScreenCapture(ssname+".png"));
		}
		//close site
		driver.close();
		//Save and close results
		er.endTest(et);
		er.flush();
			
		
		
		
		
		
		
		

	}

}





