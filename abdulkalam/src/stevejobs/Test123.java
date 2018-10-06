package stevejobs;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class Test123
{
	public static void main(String[] args) throws Exception
	{
		URL u1=new URL("http://localhost:5556/wd/hub");
		DesiredCapabilities dc1=DesiredCapabilities.chrome();
 		WebDriver driver1=new RemoteWebDriver(u1,dc1);
 		driver1.navigate().to("http://www.google.co.in");
 		Thread.sleep(5000);
 		driver1.quit();
 		URL u2=new URL("http://192.168.1.2:5557/wd/hub");
 		DesiredCapabilities dc2=DesiredCapabilities.firefox();
 		WebDriver driver2=new RemoteWebDriver(u2,dc2);
 		driver2.navigate().to("http://www.google.co.in");
 		Thread.sleep(5000);
 		driver2.quit();
	}
}
