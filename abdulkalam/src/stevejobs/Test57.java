package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test57
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.ie.driver",
				"E:\\batch240\\iedriverserver.exe");
		DesiredCapabilities dc=DesiredCapabilities.internetExplorer();       
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		InternetExplorerDriver driver=new InternetExplorerDriver(dc);

	}

}
