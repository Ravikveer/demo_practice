package daily_sample.demo_practice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class example5 
{
	@SuppressWarnings("deprecation")
	@Test
	public void webtable() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:/eclips jar files/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.nyse.com/ipo-center/recent-ipo");
		Thread.sleep(2000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//button[@class='btn btn-default'])[2]"))).click();
		WebElement element = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
		List<WebElement> tablerow = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(tablerow.size());
		
		List<WebElement> tablehead = driver.findElements(By.xpath("(//thead/tr)[2]/th"));
		
		for(WebElement head:tablehead)
		{
			System.out.print(head.getText() + " ");
		}
		System.out.println();
		
		for(int i=1 ; i<= tablerow.size() ; i++)
		{
			  List<WebElement> tabledate = driver.findElements(By.xpath("//tbody/tr["+i+"]/td"));
			  for(int j =1 ; j<= tabledate.size() ; j++)
			  {
				  String data = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();
				  System.out.print(data+" ");
			  }
			
			System.out.println();
		}
		
		driver.close();
		
	}

}
