package stevejobs;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test79
{
	public static void main(String[] args) throws Exception
	{
		//Provide device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity",
					"com.android.calculator2.Calculator");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch app in device
		AndroidDriver driver;
		while(2>1) //infinite loop
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break; //terminate from loop
			}
			catch(Exception e)
			{	
			}
		}
		//Get performance details
		List<String> pl=driver.getSupportedPerformanceDataTypes();
		for(int i=0;i<pl.size();i++)
		{
			System.out.print(pl.get(i)+"\t");
		}
		System.out.println();
		//getPerformanceData()
		System.out.println("CPU information:");
		List<List<Object>> ci=
				driver.getPerformanceData("com.android.calculator2",
									"cpuinfo",10000);
		for(int i=0;i<ci.size();i++)
		{
			for(int j=0;j<ci.get(i).size();j++)
			{
				try
				{
				  System.out.print(ci.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.print(0);
				}
			}
			System.out.println();
		}
		System.out.println("memory information:");
		List<List<Object>> mi=driver.getPerformanceData(
							"com.android.calculator2",
								"memoryinfo",10000);
				for(int i=0;i<mi.size();i++)
				{
					for(int j=0;j<mi.get(i).size();j++)
					{
						try
						{
							System.out.print(mi.get(i).get(j).toString()+"\t");
						}
						catch(Exception ex)
						{
							System.out.print(0);
						}
					}
					System.out.println("");
				}
				System.out.println("battery information:");
				List<List<Object>> bi=driver.getPerformanceData(
										"com.android.calculator2",
										"batteryinfo",10000);
				for(int i=0;i<bi.size();i++)
				{
					for(int j=0;j<bi.get(i).size();j++)
					{
						try
						{
							System.out.print(bi.get(i).get(j).toString()+"\t");
						}
						catch(Exception ex)
						{
							System.out.print(0);
						}
					}
					System.out.println("");
				}
				System.out.println("network information:");
				List<List<Object>> ni=driver.getPerformanceData(
										"com.android.calculator2",
										"networkinfo",10000);
				for(int i=0;i<ni.size();i++)
				{
					for(int j=0;j<ni.get(i).size();j++)
					{
						try
						{
							System.out.print(ni.get(i).get(j).toString()+"\t");
						}
						catch(Exception ex)
						{
							System.out.print(0);
						}
					}
					System.out.println("");
				} 
				//close app
				driver.closeApp();
				//stop appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
