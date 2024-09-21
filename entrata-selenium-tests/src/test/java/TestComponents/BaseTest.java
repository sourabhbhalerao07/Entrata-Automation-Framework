package TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.EntrataHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public EntrataHomePage entrataHomePage;
	
	public WebDriver initializeDriver() throws IOException 
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		if(browserName.contains("headless"))
		{
			options.addArguments("headless");
		}
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().setSize(new Dimension(1440, 900));
			
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			
		}
		
		else if (browserName.equalsIgnoreCase("edge")) 
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public EntrataHomePage launchApplication() throws IOException
	{
		 driver = initializeDriver();
		 entrataHomePage = new EntrataHomePage(driver);
		 entrataHomePage.goTo();
        return entrataHomePage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}
