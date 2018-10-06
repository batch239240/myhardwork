package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
public class Test67
{
	public static void main(String[] args) throws Exception
	{
		//Launch site(SWD)
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.youtube.com"); 
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                    By.name("search_query")));
		driver.manage().window().maximize();
		//Fill fields for search required video(SWD)
		driver.findElement(By.name("search_query"))
		                     .sendKeys("abdul kalam speeches");
		w.until(ExpectedConditions.elementToBeClickable(By
		 .xpath("(//*[@aria-label='Search'])[3]/child::*[1]")));
		driver.findElement(By.xpath(
				"(//*[@aria-label='Search'])[3]/child::*[1]"))
		                                             .click();
		w.until(ExpectedConditions.elementToBeClickable(By
		   .xpath("//*[contains(@title,'Abdul Kalam in European Parliament')]")));
		driver.findElement(By.xpath("//*[contains(@title,'Abdul Kalam in European Parliament')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("(//*[contains(text(),'Abdul Kalam in European Parliament')])[4]")));
		//Automate video elements(SikuliX)
		Screen s=new Screen();
		Thread.sleep(5000); //to get skip add in advertisement
		if(s.exists("skipadd.png")!=null)
		{
			s.click("skipadd.png");
		}
		//move mouse pointer to video body and click pause
		Thread.sleep(5000);
		Location l=new Location(300,300); 
		s.wheel(l,Button.LEFT,0);
		s.click("pause.png");
		Thread.sleep(5000);
		//move mouse pointer to video body and click play
		s.wheel(l,Button.LEFT,0);
		s.click("play.png");
		Thread.sleep(5000);
		//move mouse pointer to video body and move to volume
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("volume.png");
		//automate slider from right to left(decrease volume)
		Match e=s.find("bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location el1=new Location(x-50,y);
		s.dragDrop(e,el1);
		Thread.sleep(5000);
		//automate slider from left to right(increase volume)
		Location el2=new Location(x+50,y);
		s.dragDrop(e,el2);
		Thread.sleep(5000);
		//Close site
		driver.close();		
	}
}





