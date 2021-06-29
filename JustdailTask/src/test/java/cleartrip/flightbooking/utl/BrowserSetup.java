package cleartrip.flightbooking.utl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSetup {
	
	public static WebDriver getDriver(String type)
	{
		WebDriver driver = null;
		
		if(type.equalsIgnoreCase("chrome"))
			
		{
			String chrome_path="\\Eclipse\\Workspace\\JustdailTask\\Drivers\\chrome\\91\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver",chrome_path); 
			driver=new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(type.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	

}
