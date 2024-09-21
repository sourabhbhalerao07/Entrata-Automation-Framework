package AbstractComponents;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {
	
	WebDriver driver;
	
	public Utilities(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void selectDropdownValues(WebElement ele, int index)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void waitForElementToBeVisible(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
    public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void moveOnProducts(WebElement ele)
	{
		Actions a = new Actions(driver);
	}
	
	public String getTitle()
	{
		 Set<String> windows =driver.getWindowHandles();     //[parentid,childid,subchildid]
	       
	       Iterator<String>it = windows.iterator();
	       
	       String parentid =  it.next();     //[parentid]
	       
	       String childid = it.next();       //[childid]
	       
	       driver.switchTo().window(childid);
	       
	       String actualTitle = driver.getTitle();
	       
	       return actualTitle;
	       
	}
	
	
	

}
