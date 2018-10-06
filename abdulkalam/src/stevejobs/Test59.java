package stevejobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Test59 
{
	public static void main(String[] args)
	{
		ProfilesIni p=new ProfilesIni();				
		FirefoxProfile fp=p.getProfile("default");
		fp.setAcceptUntrustedCertificates(true); 
		fp.setAssumeUntrustedCertificateIssuer(false);
		System.setProperty("webdriver.gecko.driver",
			     "E:\\batch240\\geckodriver.exe");          
		FirefoxDriver driver=new FirefoxDriver();
		
		
		

	}

}
