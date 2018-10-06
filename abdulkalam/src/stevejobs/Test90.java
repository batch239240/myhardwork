package stevejobs;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test90 
{
	public static void main(String[] args) throws Exception
	{
		//Give color name
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter red/green/balck/blue");
		String cname=sc.nextLine();
		int count=0;
		int percentage;
		Color ec=null;
		switch(cname)
		{
		case "black":
			ec=Color.BLACK;
			break;
		case "red":
			ec=Color.RED;
			break;
		case "blue":
			ec=Color.BLUE;
			break;
		case "green":
			ec=new Color(0,128,0);
			break;
		default:
			System.out.println("Wrong color");
			System.exit(0); //stop execution forcibly
		}
		//Details of ARD and app 
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage",
				  	"com.vodqareactnative");
		dc.setCapability("appActivity",
				"com.vodqareactnative.MainActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch app
		AndroidDriver driver;
		while(2>1) //infinite loop
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break; //terminate from loop
			}
			catch(Exception ex)
			{
			}
		}
		//Automation
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(
					By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']"))
			                                          .click();
			//Swipe for Wheel Picker option
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath(
							  "//*[@text='Wheel Picker']"))
					                              .click();
					break; //terminate from current loop
				}
				catch(Exception ex)
				{
					TouchAction ta=new TouchAction(driver);
					int w=driver.manage().window().getSize()
							                       .getWidth();
					int h=driver.manage().window().getSize()
							                      .getHeight();
					int x1=w/2;
					int y1=(int)(h*0.9); //near to bottom
					int x2=w/2;
					int y2=(int)(h*0.4);  //near to top
					ta.press(x1,y1).moveTo(x2,y2).release()
					                               .perform();
				}
			}
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(
					"//*[@class='android.widget.Spinner']")));
			driver.findElement(By.xpath(
			  "//*[@class='android.widget.Spinner']")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(
					"//*[@class='android.widget.ListView']")));
			driver.findElement(By.xpath(
					       "//*[@text='"+cname+"']")).click();
			WebElement e=driver.findElement(By.xpath(
					      "//*[@bounds='[0,160][720,260]']"));
			//Get the location of element on the app screen
			int x=e.getLocation().getX();
			int y=e.getLocation().getY();
			//Get width and height of the element
			int eleWidth=e.getSize().getWidth();
			int eleHeight=e.getSize().getHeight();
			//Get entire page screenshot
			File screenshot=driver.getScreenshotAs(
					                        OutputType.FILE);
			BufferedImage  fullImg=ImageIO.read(screenshot);
			//Crop the full screenshot to get element screenshot
			BufferedImage eleScreenshot=fullImg.getSubimage(
					                    x,y,eleWidth,eleHeight);
			//Check image color to validate
			for(int i=0;i<eleWidth;i++)
			{
				for(int j=0;j<eleHeight;j++)
				{
					Color ac=new Color(eleScreenshot.getRGB(i,j));
					if(ac.getRed()==ec.getRed() &&
						ac.getBlue()==ec.getBlue() &&
						ac.getGreen()==ec.getGreen())
					{
						count=count+1;
					}
				}
			}
			System.out.println(count);
			percentage=(count*100)/(eleWidth*eleHeight);
			if(percentage>=85)
			{
				System.out.println("Color test was passed");
			}
			else
			{
				System.out.println("Color test failed");
			}
			//Close app
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
