package cleartrip.flightbooking.tc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cleartrip.Testdata.Testdata;
import cleartrip.flightbooking.po.Bookticketpage;
import cleartrip.flightbooking.utl.BrowserSetup;

public class TC_Flightbooking {
	

	@Test
	public WebDriver book_ticket() throws InterruptedException {
		WebDriver driver=BrowserSetup.getDriver(Testdata.browsername);
		driver.get(Testdata.url);
		
		
		Bookticketpage booktckt=PageFactory.initElements(driver,Bookticketpage.class);
		booktckt.Booktickectroundtrip(Testdata.from,Testdata.to,Testdata.add_days_depature,Testdata.add_days_return,Testdata.Adult,Testdata.childern);
		
		return driver;
		
		
		
	}

}
