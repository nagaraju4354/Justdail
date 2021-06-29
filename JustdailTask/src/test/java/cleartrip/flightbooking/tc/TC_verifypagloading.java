package cleartrip.flightbooking.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cleartrip.flightbooking.po.Bookticketpage;
import cleartrip.flightbooking.po.Verifyloadaingpage;
import cleartrip.flightbooking.utl.BrowserSetup;


public class TC_verifypagloading extends TC_Flightbooking
{
	
	@Test
	public WebDriver Verify_Pageloading_Clickbookbtn() throws InterruptedException {
		
		WebDriver driver=book_ticket();
		Verifyloadaingpage vrfy_book=PageFactory.initElements(driver,Verifyloadaingpage.class);
		vrfy_book.verifypageload_clickbook();
		
		return driver;
		
		
		
		
	}
		
	
	

	}
