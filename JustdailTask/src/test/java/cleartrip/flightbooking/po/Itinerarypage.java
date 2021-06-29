package cleartrip.flightbooking.po;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cleartrip.Testdata.Testdata;

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
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"Next\"]")
	WebElement MealsNext_btn;
	
	@FindBy(how = How.XPATH,using = "//span[text()=\"Save and Exit\"]")
	WebElement MealsTooltip;
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"View baggage options\"]")
	WebElement Viewbagage_btn;
	
	
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Choose add-ons\"]/following::button[text()=\"Continue\"]")
	WebElement Continue;
	
	/////////////////////////////////Add contact details///////////////////
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Add contact details\"]")
	WebElement Addcontactdetails_section;
	
	@FindBy(how = How.XPATH,using = "//input[@placeholder=\"Mobile number\"]")
	WebElement Mobilenumber_txtbox;
	
	@FindBy(how = How.XPATH,using = "//input[@placeholder=\"Email address\"]")
	WebElement Email_txtbox;
	
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Add contact details\"]/following::button[text()=\"Continue\"]")
	WebElement Continue_contact;
	
	/////////////////////////Add traveler details/////////////////////
	
	@FindBy(how = How.XPATH,using = "//h2[text()=\"Add traveller details\"]")
	WebElement Addtraverler_section;
	
	@FindBy(how = How.XPATH,using = "//button[text()='Continue to payment']/..")
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
		
		//Act.moveToElement(Selectseats_btn).click().perform();
		Selectseats_btn.click();
		Thread.sleep(5000);
		Done_btn.click();
		Thread.sleep(5000);
		Viewmenu_btn.click(); // Present this button is not responding when clicking
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()=\"Jain Hot Meal\"]/../child::div/child::div/descendant::p/../following-sibling::div[2]/descendant::*")).click();
		MealsNext_btn.click();
		
		Thread.sleep(5000);
		MealsDone_btn.click();
		
		if(MealsTooltip.isEnabled())
		{
			MealsTooltip.click();
		}
		
		Viewbagage_btn.click();
		Thread.sleep(5000);
		String KGS=Testdata.extra_lougeg;
		driver.findElement(By.xpath("//span[text()="+"'"+KGS+" KG']/../child::div/child::div/descendant::p/../following-sibling::div[2]/descendant::*")).click();
		Thread.sleep(5000);
		MealsDone_btn.click();
		if(MealsTooltip.isEnabled())
		{
			MealsTooltip.click();
		}
		
		
			Thread.sleep(2000);
			Continue.click();
			Thread.sleep(3000);
		}

	public void itinearypage_Addcontactdetails() throws InterruptedException {
		//Addcontactdetails_section.click();
		
		Mobilenumber_txtbox.sendKeys(Testdata.mobile_num);
		Thread.sleep(5000);
		Email_txtbox.sendKeys(Testdata.Email);
		Thread.sleep(5000);
		Continue_contact.click();
		
	}

	public void itinearypage_Addtravelerdetails(int totaladults,int totalchild) throws InterruptedException {
				
		for (int i=1;i<=totaladults;i++)	
		{
			String FNvalue = null;
			String LNvalue = null;
			String Genvalue = null;
			
			if(i==1)
			{
				FNvalue=Testdata.Adult_1_FN;
				LNvalue=Testdata.Adult_1_LN;
				Genvalue=Testdata.Adult_1_GEN;
			}
			if(i==2)
			{
				FNvalue=Testdata.Adult_2_FN;
				LNvalue=Testdata.Adult_2_LN;
				Genvalue=Testdata.Adult_2_GEN;
			}

			String adultindex=String.valueOf(i);
			driver.findElement(By.xpath("//h4[text()='Adult "+ adultindex+"'"+"]/../div/div/div/input[@placeholder='First name']")).sendKeys(FNvalue);
			driver.findElement(By.xpath("//h4[text()='Adult "+ adultindex+"'"+"]/../div/div/div/input[@placeholder='Last name']")).sendKeys(LNvalue);
			driver.findElement(By.xpath("//h4[text()='Adult "+ adultindex+"'"+"]/../div/div/div/child::div/button/div[text()='Gender']")).click();
			//driver.findElement(By.xpath("//h4[text()=\"Adult 1\"]/../div/div/div/child::")
			driver.findElement(By.xpath("//h4[text()='Adult "+ adultindex+"'"+"]/../div/div/div/child::div//ul/li[text()="+"'"+Genvalue+"'"+"]")).click();
			
		}
		
		
		for (int j=1;j<=totalchild;j++)
			
		{
			
		String childindex=String.valueOf(j);	
		driver.findElement(By.xpath("//h4[text()='Child "+ childindex+"'"+"]/../div/div/div/input[@placeholder='First name']")).sendKeys(Testdata.child_1_FN);
		driver.findElement(By.xpath("//h4[text()='Child "+ childindex+"'"+"]/../div/div/div/input[@placeholder='Last name']")).sendKeys(Testdata.Adult_1_LN);
		driver.findElement(By.xpath("//h4[text()='Child "+ childindex+"'"+"]/../div/div/div/child::div/button/div[text()='Gender']")).click();
		//driver.findElement(By.xpath("//h4[text()=\"Child 1\"]/../div/div/div/child::")
		driver.findElement(By.xpath("//h4[text()='Child "+ childindex+"'"+"]/../div/div/div/child::div//ul/li[text()="+"'"+Testdata.child_1_GEN+"'"+"]")).click();
		driver.findElement(By.xpath("//h4[text()='Child "+ childindex+"'"+"]/../div/div/div/input[@placeholder='DD / MM / YYYY']	")).sendKeys(Testdata.child_1_DOB);
		}
		
		Thread.sleep(5000);
		Actions Act = new Actions(driver);
		
		Act.sendKeys(Keys.PAGE_DOWN);
		Act.perform();
		Thread.sleep(5000);
		Continuepayment_btn.click();
		Thread.sleep(10000);
		String Paymentconfirm=Paymentpageconfirm_text.getText();
		Assert.assertEquals(Paymentconfirm, "Pay to complete your booking");
		
		
	}
	
}
