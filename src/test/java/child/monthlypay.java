package child;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import parent.testbase;

public class monthlypay extends testbase {
public static String actualtext , expectedtext;
	public monthlypay() throws IOException {
		super();
		// TODO Auto-generated constructor stub	
		
	}
	@BeforeMethod
	public void set() {
		launchbrowser();
	}
	@Test
	public void monthlypayment() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("loanamount"))).clear();
		driver.findElement(By.xpath(prop.getProperty("loanamount"))).sendKeys("6000");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("loanyear"))).clear();
		driver.findElement(By.xpath(prop.getProperty("loanyear"))).sendKeys("10");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("loaninterest"))).clear();
		driver.findElement(By.xpath(prop.getProperty("loaninterest"))).sendKeys("5");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("calcbutton"))).click();
		Thread.sleep(3000);
		expectedtext="$100";
		actualtext =driver.findElement(By.xpath(prop.getProperty("monthlyreq"))).getText();
		System.out.println("actual amount is--->"+actualtext);
		Assert.assertEquals(actualtext, expectedtext);
		
	}
	
	
	
	
   @AfterMethod
   public void stop() {
	   driver.quit();
   }
}
