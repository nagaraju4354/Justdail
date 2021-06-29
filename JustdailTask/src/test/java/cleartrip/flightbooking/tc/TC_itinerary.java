package cleartrip.flightbooking.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cleartrip.flightbooking.po.Itinerarypage;
import cleartrip.flightbooking.po.Verifyloadaingpage;

public class TC_itinerary extends TC_verifypagloading
{
	@Test
	public void itenearyactions() throws InterruptedException{
		
		WebDriver driver=Verify_Pageloading_Clickbookbtn();
		Itinerarypage Itineryactions=PageFactory.initElements(driver,Itinerarypage.class);
		Itineryactions.itinearypage_standardfare_TravelinsAurance_actions();
		Itineryactions.itinearypage_ChooseAddons();
		Itineryactions.itinearypage_Addcontactdetails();
		Itineryactions.itinearypage_Addtravelerdetails(2,1);
		
		
	}
	

}
