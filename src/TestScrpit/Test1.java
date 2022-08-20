package TestScrpit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.FromDocument;

import Generic.BaseData;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class Test1 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException 
	{
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		FirefoxOptions p = new FirefoxOptions();
		p.addArguments("--disable-notifications");
		WebDriver driver = new FirefoxDriver(p);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.justdial.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	
		driver.findElement(By.xpath("//a[@title = 'Air Tickets']")).click();
		driver.findElement(By.xpath("//span[.='Return Journey']/preceding-sibling::span[1]")).click();
		String depart1 = BaseData.fetchData("Sheet1", 0, 0);
		String dest1 = BaseData.fetchData("Sheet1", 0, 1);
		
		WebElement ele1 = driver.findElement(By.xpath("//input[@placeholder='Type Departure City']"));
		
		driver.manage().deleteAllCookies();
		ele1.click();
		ele1.sendKeys(depart1);
		List<WebElement> list = driver.findElements(By.xpath(".//*[@class='jsx-4256918406 flgtagst']"));
		Thread.sleep(2000);
		for (WebElement e : list)
		{
			System.out.println("hello");
			if(e.getText().equals("Bangalore, IN - Kempegowda International Airport (BLR)"))
			{
				System.out.println("dcf");
				e.click();
				break;
			}
		}
		WebElement ele2 = driver.findElement(By.xpath("//input[@placeholder='Type Destination City']"));
		ele2.click();
		ele2.sendKeys(dest1);
		List<WebElement> list1 = driver.findElements(By.xpath(".//*[@class='jsx-4256918406 flgtagst']"));
		Thread.sleep(2000);
		for (WebElement e : list1)
		{
			System.out.println("hello");
			if(e.getText().contains(dest1))
			{
				e.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='SEARCH']")).click();
	}
}
