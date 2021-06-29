package cleartrip.flightbooking.po;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Verifyloadaingpage {
	
WebDriver driver;
	
	public Verifyloadaingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how = How.XPATH,using = "//p[text()=\"Almost done...\"]")
	WebElement Almotdone_text;
	
	@FindBy(how = How.XPATH,using = "//button[text()=\"Book\"]")
	WebElement Book_btn;
	
	
	public void verifypageload_clickbook() throws InterruptedException
	{
		//String verify_loadtext=Almotdone_text.getText();
		//Assert.assertEquals(verify_loadtext,"Almost done...");
		Book_btn.click();
		Set<String> windows =driver.getWindowHandles();
		for(String actual: windows) {
			driver.switchTo().window(actual);
		}
		System.out.println(driver.getCurrentUrl());
		Actions Act = new Actions(driver);
		Thread.sleep(8000);

		Act.sendKeys(Keys.PAGE_DOWN);
		Act.perform();
		
		
	}
	
	
	
	
	
	

}
