package stevejobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test106 
{
	public static void main(String[] args) throws Exception
	{
		//Take a word
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Create/Open html file
		ExtentReports er=new ExtentReports("googleres.html",
				                                        false);
		ExtentTest et=er.startTest("Google site title testing");
		//Launch site
		System.setProperty("webdriver.chrome.driver",
						"E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in"); 
		Thread.sleep(5000);
		//Search word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//Test title for all results pages 
		int flag=0;
		while(2>1) //infinite loop
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				flag=1;
				break; //stop loop due to test failed
			}
			else
			{
				try
				{
				  //goto next page
				  driver.findElement(By.xpath(
						  "//*[text()='Next']")).click();
				  Thread.sleep(3000);
				}
				catch(Exception ex)
				{
					break; //stop loop due to last page
				}
			} //else closing
		} //while loop ending
		if(flag==0)
		{
			et.log(LogStatus.PASS,"Google title test passed");
		}
		else
		{
			//get screen shot
			SimpleDateFormat sf=new SimpleDateFormat(
					                      "dd-MM-yy-hh-mm-ss");
			Date d=new Date();
			String ssname=sf.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(ssname+".png");
			FileUtils.copyFile(src,dest);
			et.log(LogStatus.FAIL,"Google title test failed"+
			               et.addScreenCapture(ssname+".png"));
		}
		//close site
		driver.close();
		//Save results
		er.endTest(et);
		er.flush();
		
		
		
		
		
	}
}
