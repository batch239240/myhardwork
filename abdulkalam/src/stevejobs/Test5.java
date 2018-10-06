package stevejobs;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
public class Test5
{
	public static void main(String[] args)
	{
		WebDriver driver=null; //object declared
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String x=sc.nextLine();
		//Open our interested browser
		if(x.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
			          "E:\\batch240\\chromedriver.exe");    
			driver=new ChromeDriver(); //object defined
		}
		else if(x.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
				     "E:\\batch240\\geckodriver.exe");          
			driver=new FirefoxDriver(); //object defined
		}
		else if(x.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"E:\\batch240\\iedriverserver.exe");
			driver=new InternetExplorerDriver();//object defined
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary(
		   "C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
			System.setProperty("webdriver.opera.driver",
			"E:\\batch240\\operadriver_win64\\operadriver.exe");
			driver=new OperaDriver(o);
		}
		else
		{
			System.out.println("Invalid browser");
			System.exit(0); //0 means forcibly
		}
		//Launch site
		driver.get("http://www.google.co.in");
		driver.close();
	}
}





