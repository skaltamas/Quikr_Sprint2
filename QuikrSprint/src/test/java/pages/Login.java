/*Author: Altamas Shaikh
 * Date: 08-Jan-2021
 * Description: below code is to verify
 * 					login with invalid credentials
 * 					login with valid credentials
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import base.QuikrBase;

public class Login extends QuikrBase{
	
	//Web elements declared
	static @FindBy(xpath="//div[@class='nls_formContainer']/div[1]/input") WebElement valid;
	static @FindBy(xpath="//button[text()='Continue']") WebElement continuebtn;
	static @FindBy(xpath="//div[@class='nls_formContainer']/div[2]/input") WebElement pwd;
	static @FindBy(xpath="//button[text()='Login']") WebElement loginbtn;
	static @FindBy(xpath="//i[@class='nls_sprite nls_back_btn']") WebElement back;
	static @FindBy(xpath="//button[text()='Continue']") WebElement continuebtn2;
	static @FindBy(xpath="//div[@class='nls_formError']") WebElement errormsg;
	
	//Web elements initialized
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	//method to verify home page and take screenshot
	public void verify_home() {
		initialize();
		String str = driver.getTitle();
		if(str.contains("Free Classified Ads")) {
			testlog=ext.createTest("Homepage");
			testlog.log(Status.PASS, "Homepage title is correct"); 					//test pass
			takescreenshot("HomePage.png");
		}
		else {
			testlog=ext.createTest("Homepage");
			testlog.log(Status.FAIL, "Homepage title is not correct"); 				//test fail
			takescreenshot("HomePage.png");
		}
	}
	
	//method to open login popup
	public void display_login() {
		try {Thread.sleep(5000);}catch(Exception e) {} 								//wait
		new Actions(driver).click().build().perform(); 								//close popup
		try {Thread.sleep(5000);}catch(Exception e) {} 								//wait
		driver.findElement(By.xpath("//label[text()='Login/Register']")).click(); 	//click on login
	}
	
	//method to verify invalid login
	public void enter_invalid(String userid, String password) {
		valid.sendKeys(userid); 													//enter userid
		continuebtn.click();														//click continue
		try {Thread.sleep(3000);}catch(Exception e) {}
		pwd.sendKeys(password);														//enter password
		loginbtn.click();															//click login
		
		try {																		//wait for captcha if any
			if(continuebtn2.isDisplayed()) {
				try {Thread.sleep(10000);}catch(Exception e) {}
				continuebtn2.click();
			}
		}catch(Exception e) {}
		try {																		//wait for captcha if any
			if(continuebtn2.isDisplayed()) {
				try {Thread.sleep(10000);}catch(Exception e) {}
				continuebtn2.click();
			}
		}catch(Exception e) {}
		
		if(errormsg.getText().contains("Incorrect credentials.")) {
			testlog=ext.createTest("Invalid_login");
			testlog.log(Status.PASS, "Error occured while logging in with invalid credentials.");	//test pass
			takescreenshot("InvalidLogin.png");
		}
		else {
			testlog=ext.createTest("Invalid_login");
			testlog.log(Status.FAIL, "No error occured while logging in with invalid credentials."); //test fail
			takescreenshot("InvalidLogin.png");
		}
			
		back.click();																//go back to login
		valid.clear();																//clear text field of userid
	}
	
	//method to verify valid login
	public void enter_valid(String useridd, String passwordd) {
		valid.sendKeys(useridd);													//enter userid
		continuebtn.click();														//click continue
		try {Thread.sleep(5000);}catch(Exception e) {}
		pwd.sendKeys(passwordd);													//enter password
		loginbtn.click();															//click login
			
		try {																		//wait for captcha if any
			if(continuebtn2.isDisplayed()) {
				try {Thread.sleep(10000);}catch(Exception e) {}
				continuebtn2.click();
			}
		}catch(Exception e) {}
		try {Thread.sleep(5000);}catch(Exception e) {}
			
		String str = driver.getTitle();
		if(str.contains("Free Classified Ads")) {
			testlog=ext.createTest("Valid_login");
			testlog.log(Status.PASS, "User is successfully logged in.");			//test pass
			takescreenshot("ValidLogin.png");
		}
		else {
			testlog=ext.createTest("Valid_login");
			testlog.log(Status.FAIL, "User is not logged in.");						//test fail
			takescreenshot("ValidLogin.png");
		}
		
		teardown();
	}
}