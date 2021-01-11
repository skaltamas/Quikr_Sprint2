/*Author: Prerna
 * Date: 09-Jan-2021
 * Description: below code to
 *              select the desired category and sub category
 *              fill the form and post the ad for the product
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Quikr_base;

public class Form extends Quikr_base {
	@FindBy(xpath=("//a[@id='postAdBtn']")) WebElement post;               				 //WebElements to be used in the code//
	@FindBy(id=("petrol")) WebElement fuel;
	@FindBy(name=("Kms_Driven")) WebElement dist;
	@FindBy(name=("Price")) WebElement price;
	@FindBy(name=("contactName")) WebElement name;
	@FindBy(name=("mobile")) WebElement number;
	@FindBy(name=("emailid")) WebElement email;
	@FindBy(xpath=("//div[@class='menu-item-text'][1]")) WebElement vehicles;
	@FindBy(xpath=("//a[text()='Post your Ad']")) WebElement Ad;
	//(xpath=("//h3[@id='myModalLabel']")) WebElement otp;
	
	public void postbutton() {
		PageFactory.initElements(driver, this);      									//method to click the post ad button//
		post.click();	
		
	}
	
	public void postpage() {
		vehicles.click();       														 //selecting category//	
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {}
		System.out.println(driver.getTitle());
		if((driver.getTitle()).contains("Post free ads on Quikr")) {					//validating post free ad page opens//
			testlog=ext.createTest("Quikr_PostFreeAd");
			testlog.log(Status.PASS,"Post free ad page opens");
			takescreenshot("PostFreeAd.png");
			
		}
		else {
			testlog=ext.createTest("Quikr_PostFreeAd");
			testlog.log(Status.FAIL,"Post free ad page does not opens");
			
		}                 
		driver.findElement(By.linkText("Cars")).click();								//selecting sub category//
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {}

		System.out.println(driver.getTitle());											//validating the form that opens to add product details//
		if((driver.getTitle()).contains("Sell Used Car")) {
			testlog=ext.createTest("Quikr_SellProduct");
			testlog.log(Status.PASS,"Form Opening");
			takescreenshot("SellCar.png");
			
		}
		else {
			testlog=ext.createTest("Quikr_SellProduct");
			testlog.log(Status.FAIL,"Form Not Opening");
			
		}
		
	}
	
	public void carform() {																//method to fill the form//
		System.out.println("hi form");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {}
		
		driver.findElement(By.name("Brand_name")).sendKeys("Audi");
		driver.findElement(By.name("Model")).sendKeys("A3");
		fuel.click();
		driver.findElement(By.name("Year")).sendKeys("2019");
		dist.sendKeys("1000");
		driver.findElement(By.name("cityName")).sendKeys("Mumbai");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e) {}
		
		driver.findElement(By.name("adlocality")).sendKeys("Alibag");
		dist.sendKeys("100000");
		name.sendKeys("Prerna");
		number.sendKeys("8976394515");
		email.sendKeys("randomperson58@gmail.com");
		takescreenshot("QuikrForm1.png");
		Ad.click();
		takescreenshot("QuikrForm1.png");
		
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) {}
		/*WebElement otp=driver.findElement(By.xpath("//h3[@id='myModalLabel']"));
		new Actions(driver).moveToElement(otp).perform();
		String otpverify=otp.getText();
		System.out.println(otp.getText());
		if(otpverify.matches("OTP Verification")) {
			testlog=ext.createTest("Quikr_FormFill");
			testlog.log(Status.PASS,"Form filling completed successfully");
			
		}
		else {
			testlog=ext.createTest("Quikr_FormFill");
			testlog.log(Status.FAIL,"Form filling not completed successfully");
			
		}*/
		
		

	}	

}

