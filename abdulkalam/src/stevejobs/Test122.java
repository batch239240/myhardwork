package stevejobs;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test122
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				          "E:\\batch240\\chromedriver.exe");   
		ChromeDriver driver=new ChromeDriver();
		Method m[]=driver.getClass().getMethods();
		System.out.println(m.length);
		for(int i=0;i<m.length;i++)
		{
			System.out.println(m[i].getName());
		}
	}
}





