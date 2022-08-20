package TestScrpit;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.bouncycastle.jcajce.provider.symmetric.ChaCha.BaseCC20P1305;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generic.BaseData;
import Generic.BaseTest;
import PomScript.Pom1;

@Test
public class Testcase1 extends BaseTest
{
	public void test1() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Pom1 pom1 = new Pom1(driver);
		pom1.airTickets();
		pom1.returnJourney();
		String depart1 = BaseData.fetchData("Sheet1", 0, 0);
		String dest1 = BaseData.fetchData("Sheet1", 0, 1);
		WebElement ele1 = pom1.departure();
		driver.manage().deleteAllCookies();
		ele1.click();
		ele1.sendKeys(depart1);
		List <WebElement> list1= pom1.destOptions();
		Thread.sleep(2000);
		for (WebElement e : list1)
		{
			if(e.getText().equals("Bangalore, IN - Kempegowda International Airport (BLR)"))
			{
				e.click();
				break;
			}
		}
		
		WebElement ele2 = pom1.destination();
		ele2.click();
		ele2.sendKeys(dest1);
		List <WebElement> list2 = pom1.departOptions();
		Thread.sleep(2000);
		for (WebElement e : list2)
		{
			if(e.getText().contains(dest1))
			{
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		pom1.search();
		Thread.sleep(4000);
	}
}

