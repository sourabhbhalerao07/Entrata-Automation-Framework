package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Utilities;


public class ScheduleDempPage extends Utilities {
	
	 WebDriver driver;
		
		public ScheduleDempPage(WebDriver driver)
		{
			super(driver);
			//Initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="FirstName")
		WebElement firstName;
		
		@FindBy(id="LastName")
		WebElement lastName;
		
		@FindBy(id="Email")
		WebElement email;
		
		@FindBy(id="Company")
		WebElement company;
		
		@FindBy(id="Phone")
		WebElement phone;
		
		@FindBy(id="Unit_Count__c")
		WebElement unitCount;
		
		@FindBy(id="Title")
		WebElement jobTitle;
		
		@FindBy(id="demoRequest")
		WebElement customerType;
		
		By text = By.xpath("//h1[contains(text(),'Property Management the Way It Should Be')]");
		
		
		
		public void fillDetails()
		{
			waitForElementToBeVisible(text);
			firstName.sendKeys("Sourabh");
			lastName.sendKeys("Bhalerao");
			email.sendKeys("sourabh123@gmail.com");
			company.sendKeys("abc");
			phone.sendKeys("1234567899");
			selectDropdownValues(unitCount,3);
			jobTitle.sendKeys("Assistant");
			selectDropdownValues(customerType,2);
		}
	
	

}
