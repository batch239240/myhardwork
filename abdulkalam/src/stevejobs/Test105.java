package stevejobs;
import java.io.File;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test105
{
	public static void main(String[] args) throws Exception
	{
		//Take a word
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver",
						"E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in"); 
		Thread.sleep(5000);
		//Search word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//Test title
		int flag=0;
		while(2>1) //infinite loop
		{
			String t=driver.getTitle();
			if(!t.contains(x))
			{
				flag=1;
				//get screen shot
				Date d=new Date();
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File(d.toString()+".png");
				FileUtils.copyFile(src,dest);
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
			System.out.println("Google title test passed");
		}
		else
		{
			System.out.println("Google title test failed");
		}
		//close site
		driver.close();
	}
}






