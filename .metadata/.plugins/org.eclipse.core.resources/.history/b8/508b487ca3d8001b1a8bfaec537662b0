package cleartrip.flightbooking.tc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cleartrip.flightbooking.po.Bookticketpage;
import cleartrip.flightbooking.utl.BrowserSetup;

public class TC_Flightbooking {
	
	String Browser="chrome";
	String Url="https://www.cleartrip.com/flights";
	
	
	@Test
	public WebDriver book_ticket() throws InterruptedException {
		WebDriver driver=BrowserSetup.getDriver(Browser);
		driver.get(Url);
		
		
		Bookticketpage booktckt=PageFactory.initElements(driver,Bookticketpage.class);
		booktckt.Booktickectroundtrip("Mumbai","Delhi",2,2,"2","1");
		
		return driver;
		
		
		
	}

}
