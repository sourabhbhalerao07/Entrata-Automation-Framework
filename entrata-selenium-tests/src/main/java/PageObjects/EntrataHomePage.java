package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Utilities;



public class EntrataHomePage extends Utilities{
	
	WebDriver driver;
	
	public EntrataHomePage(WebDriver driver)
	{
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Schedule Your Demo')]")
	WebElement scheduledemo;
	
	@FindBy(id="cookie-accept")
	WebElement acceptCookies;
	
	@FindBy(xpath="//a[@href='/products/accounting']/following-sibling::a")
	private List <WebElement> accountinglinks;
	
	@FindBy(xpath="(//a[@href='https://summit.entrata.com/'][contains(text(),'Summit')])[1]")
	WebElement summit;
	
	
	
	public ScheduleDempPage ScheduleDemo()
	{
		scheduledemo.click();
		ScheduleDempPage scheduleDempPage = new ScheduleDempPage(driver);
		return scheduleDempPage;
	}
	
	public void validateAccountingLinks() throws MalformedURLException, IOException
	{
		for (WebElement link : accountinglinks)

		{
            String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

			conn.setRequestMethod("HEAD");

			conn.connect();

			int respCode = conn.getResponseCode();

			System.out.println(respCode);
			
			if(respCode > 400)
			{
				System.out.println("The link with Text"+ link.getText()+" is broken"+ respCode);
			}
			
		}
	}
	
	public void clickOnSummit()
	{
		summit.click();
		
	}
	
	
	
	
	public void goTo()
	{
		driver.get("https://www.entrata.com/c");
		acceptCookies();
	}
	
	public void acceptCookies()
	{
		acceptCookies.click();
	}
	
	
	
	

}
