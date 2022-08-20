package PomScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom1 
{
	@FindBy(xpath = "//a[@title = 'Air Tickets']")
	private WebElement airTicketsClick;
	
	@FindBy(xpath = "//span[.='Return Journey']/preceding-sibling::span[1]")
	private WebElement returnJourneyBtn;
	
	@FindBy(xpath = "//input[@placeholder='Type Departure City']")
	private WebElement departTxt;
	
	@FindBy(xpath = ".//*[@class='jsx-4256918406 flgtagst']")
	private List<WebElement> departOpt;
	
	@FindBy(xpath = "//input[@placeholder='Type Destination City']")
	private WebElement destTxt;
	
	@FindBy(xpath = ".//*[@class='jsx-4256918406 flgtagst']")
	private List<WebElement> destOpt;
	
	@FindBy(xpath = "//input[@value='SEARCH']")
	private WebElement searchClk;
	
	public  Pom1(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void airTickets()
	{
		airTicketsClick.click();
	}
	
	public void returnJourney()
	{
		returnJourneyBtn.click();
	}
	
	public WebElement departure()
	{
		return departTxt;
	}
	
	public List<WebElement> departOptions()
	{
		return departOpt;
	}
	
	public WebElement destination() 
	{
		return destTxt;
	}
	
	public List<WebElement> destOptions()
	{
		return destOpt;
	}
	
	public void search() 
	{
		searchClk.click();
	}
}
