package stevejobs;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test58
{
	public static void main(String[] args)
	{
		OperaOptions o=new OperaOptions();
		o.setBinary(
		  "C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
		System.setProperty("webdriver.opera.driver",
			"E:\\batch240\\operadriver_win64\\operadriver.exe");
		DesiredCapabilities dc=DesiredCapabilities.opera();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		//OperaDriver driver=new OperaDriver(o,dc);

	}

}
