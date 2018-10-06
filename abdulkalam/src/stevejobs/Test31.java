package stevejobs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test31
{
	public static void main(String[] args) throws IOException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,
				                            TimeUnit.SECONDS);
		//get screen shot as a png file
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\batch240\\ss.png");
		FileUtils.copyFile(src,dest);
		//close site
		driver.close();
		
		

	}

}
