package cleartrip.flightbooking.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Itinerarypage {
	
WebDriver driver;
	
	public Itinerarypage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how = How.XPATH,using = "//h3[text()=\"Standard fare\"]/parent::div/parent::div/..")
	WebElement Standardfare_rbt;
	
	@FindBy(how = How.XPATH,using = "//h3[text()=\"Protect your trip with travel insurance\"]/parent::div/../../div/child::div/child::div/button[text()=\"Add\"]")
	WebElement Add_travelinsurance_btn;
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"Continue\"]/.")
	WebElement Continue_btn;
	
	//////////// Choose Add Ons///////////////////////////////////////
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Choose add-ons\"]")
	WebElement Choosaddon_section;
	
	@FindBy(how = How.XPATH,using = "//div[text()=\"Choose the seat you want\"]/parent::div/../div/button[text()=\"Select seats\"]")
	WebElement Selectseats_btn;
	
	@FindBy(how = How.XPATH,using = "//div[text()=\"B\"]/../following-sibling::div/div[text()=\"13\"]/parent::div/div]")
	WebElement Chooseseats;
	
	@FindBy(how = How.XPATH,using = "//Button[text()=\"Done\"]")
	WebElement Done_btn;
	
	@FindBy(how = How.XPATH,using = "//Button[text()=\"View menu\"]")
	WebElement Viewmenu_btn;
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"Done\"]")
	WebElement MealsDone_btn;
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"View baggage options\"]")
	WebElement Viewbagage_btn;
	
	
	
	
	/////////////////////////////////Add contact details///////////////////
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Add contact details\"]")
	WebElement Addcontactdetails_section;
	
	@FindBy(how = How.XPATH,using = "//input[@placeholder=\"Mobile number\"]")
	WebElement Mobilenumber_txtbox;
	
	@FindBy(how = How.XPATH,using = "//input[@placeholder=\"Email address\"]")
	WebElement Email_txtbox;
	
	/////////////////////////Add traveler details/////////////////////
	
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Add traveller details\"]")
	WebElement Addtraverler_section;
	
	@FindBy(how = How.XPATH,using = "//Button[text()=\"Continue to payment\"]")
	WebElement Continuepayment_btn;
	
	////////////////////////////////////Paymentpage confirmation////////////////////
	@FindBy(how = How.XPATH,using = "//h1[text()=\"Pay to complete your booking\"]")
	WebElement Paymentpageconfirm_text;
	
	
	
	public void itinearypage_standardfare_TravelinsAurance_actions() throws InterruptedException


	{
		
		Standardfare_rbt.click();
		
		//Act.moveToElement(Standardfare_rbt).click().perform();
		Thread.sleep(3000);
		Add_travelinsurance_btn.click();
		//Thread.sleep(15000);
		Actions Act = new Actions(driver);
			
		//Act.moveToElement(Add_travelinsurance_btn).click().perform();
		Thread.sleep(5000);
		Act.sendKeys(Keys.PAGE_DOWN);
		Act.perform();
		Thread.sleep(5000);
		Act.sendKeys(Keys.PAGE_DOWN);
		Act.perform();
		Thread.sleep(5000);
		//Act.moveToElement(Continue_btn).click().perform();
		Continue_btn.click();
		
	}
	
	
	public void itinearypage_ChooseAddons() throws InterruptedException
	{
		//Choosaddon_section.click();
		Thread.sleep(5000);
		Actions Act = new Actions(driver);
		Act.moveToElement(Selectseats_btn).click().perform();
		Selectseats_btn.click();
		Done_btn.click();
		Viewmenu_btn.click(); // Present this button is not responding when clicking
		driver.findElement(By.xpath("//span[text()=\"Jain Hot Meal\"]/../child::div/child::div/descendant::p/../following-sibling::div[2]/descendant::*")).click();
	}

	
	public void itinearypage_Addcontactdetails() {
		Addcontactdetails_section.click();
		Mobilenumber_txtbox.sendKeys("9581819798");
		Email_txtbox.sendKeys("nagaraju.251n@gmail.com");
		Continue_btn.click();
		
	}
	
	public void itinearypage_Addtravelerdetails(int totaladults,int totalchild) {
		
		for (int i=1;i<=totaladults;i++)
			
		{
			String adultindex=String.valueOf(i);
			driver.findElement(By.xpath("//h4[text()='Adult"+"'"+ adultindex+"'"+"]/../div/div/div/input[@placeholder='First name']")).sendKeys(null);
			driver.findElement(By.xpath("//h4[text()='Adult"+"'"+ adultindex+"'"+"]/../div/div/div/input[@placeholder='Last name']")).sendKeys(null);
			driver.findElement(By.xpath("//h4[text()='Adult"+"'"+ adultindex+"'"+"]/../div/div/div/child::div/button/div[text()='Gender']")).click();
			//driver.findElement(By.xpath("//h4[text()=\"Adult 1\"]/../div/div/div/child::")
			driver.findElement(By.xpath("//h4[text()='Adult"+"'"+ adultindex+"'"+"]/../div/div/div/child::div//ul/li[text()='Male']")).click();
			
		}
		
		
				
				
		driver.findElement(By.xpath("//h4[text()='Child 1']/../div/div/div/input[@placeholder='First name']")).sendKeys(null);
		driver.findElement(By.xpath("//h4[text()='Child 1']/../div/div/div/input[@placeholder='Last name']")).sendKeys(null);
		driver.findElement(By.xpath("//h4[text()='Child 1']/../div/div/div/child::div/button/div[text()='Gender']")).click();
		//driver.findElement(By.xpath("//h4[text()=\"Child 1\"]/../div/div/div/child::")
		driver.findElement(By.xpath("//h4[text()='Child 1']/../div/div/div/child::div//ul/li[text()='Male']")).click();
		driver.findElement(By.xpath("//h4[text()='Child 1']/../div/div/div/input[@placeholder='DD / MM / YYYY']	")).sendKeys(null);
					
		Continuepayment_btn.click();
		
	}
	
}
