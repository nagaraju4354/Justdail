package cleartrip.flightbooking.po;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import okio.Timeout;

public class Bookticketpage {
	
	WebDriver driver;
	
	public Bookticketpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how = How.XPATH,using = "//p[text()=\"Round trip\"]")
	WebElement roundtrip_rbt;
	
	@FindBy(how = How.XPATH,using = "//h4[text()=\"From\"]/../div/descendant::input")
	WebElement From_txt;
	
	@FindBy(how = How.XPATH,using = "//h4[text()=\"To\"]/../div/descendant::input")
	WebElement To_txt;
	
	@FindBy(how = How.XPATH,using = "//div[@class=\"p-relative\"]/descendant::li/p")
	WebElement suggoption;
	
	
	@FindBy(how = How.XPATH,using = "//h4[text()=\"Depart on\"]/../../following-sibling::div/descendant::button/div")
	WebElement Departdate;
	
	@FindBy(how = How.XPATH,using = "//h4[text()=\"Return on\"]/../../following-sibling::div/descendant::button[2]/div")
	WebElement Returndate;
	
	
	@FindBy(how = How.XPATH,using = "//h4[text()=\"Adults\"]/../select")
	WebElement Adult_dropdown;
	
	
	@FindBy(how = How.XPATH,using = "//h4[text()=\"Children\"]/../select")
	WebElement Child_dropdown;
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"Search flights\"]")
	WebElement SearchFlight_btn;
	


	public void Booktickectroundtrip(String From,String To,int DepatureDays,int ReturnDays,String Adult,String Child) throws InterruptedException {
		roundtrip_rbt.click();
		From_txt.sendKeys(From);
		Thread.sleep(500);
		String From_option=suggoption.getText();
		
		if (From_option.contains(From))
		{
			System.out.println("click");
			suggoption.click();
		}
		else
		{
			suggoption.click();
			Reporter.log("No Such kind of From Location in our journet list please provird valid option");
		}
		
		To_txt.sendKeys(To);
		Thread.sleep(500);
		String To_option=suggoption.getText();
		if (To_option.contains(To))
		{
			System.out.println("click");
			suggoption.click();
		}
		else
		{
			System.out.println("notclick");
			Reporter.log("No Such kind of TO Location in our journet list please provird valid option");
		}
		
		
		
		Departdate.click();

		LocalDate xdate=java.time.LocalDate.now();
		String ydate=xdate.toString();
		LocalDate date1 = LocalDate.parse(ydate);
		
		
		//add 2 days to Departure date//
		LocalDate date2 = date1.plusDays(DepatureDays);;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d LLLL yyyy");
		String DeptformattedString = date2.format(formatter);
		System.out.println(DeptformattedString);
		String[] split1=DeptformattedString.split(" ");
		
		String DMonth=split1[1];
		String DDate=split1[0];
		
		//add 2 days to Returndate//
		LocalDate date3 = date2.plusDays(ReturnDays);
		String ReturnformattedString = date3.format(formatter);
		System.out.println(ReturnformattedString);
		String[] split2=ReturnformattedString.split(" ");
		
		
		String RMonth=split2[1];
		String RDate=split2[0];
		

		Thread.sleep(5000);
		
		Actions Act = new Actions(driver);
		Act.sendKeys(Keys.PAGE_DOWN);
		Act.perform();
		
		
		Thread.sleep(5000);
		System.out.println("//div[@class='DayPicker-Caption']/div[contains(.,"+"'"+DMonth+"'"+")]/../../descendant::div[contains(@class,'Day-grid flex')]/div[text()="+"'"+DDate+"'"+"]/../..");
		WebElement Departdateoption=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div[contains(.,"+"'"+DMonth+"'"+")]/../../descendant::div[contains(@class,'Day-grid flex')]/div[text()="+"'"+DDate+"'"+"]/../.."));
		Act.moveToElement(Departdateoption);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.elementToBeClickable(Departdateoption));
		Act.click().perform();
		Act.sendKeys(Keys.ENTER);
		Act.perform();
		
		Thread.sleep(3000);
		
		Returndate.click();
		
		Thread.sleep(5000);	
		System.out.println("//div[@class='DayPicker-Caption']/div[contains(.,"+"'"+RMonth+"'"+")]/../../descendant::div[contains(@class,'Day-grid flex')]/div[text()="+"'"+RDate+"'"+"]/../..");
		WebElement Returndateoption=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div[contains(.,"+"'"+RMonth+"'"+")]/../../descendant::div[contains(@class,'Day-grid flex')]/div[text()="+"'"+RDate+"'"+"]/../.."));
		Act.moveToElement(Returndateoption);
		Thread.sleep(5000);	
		Act.click().perform();
		
		
		
		Select AdultDD= new Select(Adult_dropdown);
		AdultDD.selectByValue(Adult);
		
		Select ChildDD= new Select(Child_dropdown);
		ChildDD.selectByValue(Child);
		
		SearchFlight_btn.click();
		

	}
	

}
