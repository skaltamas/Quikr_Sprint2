package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.QuikrBase;

public class Login extends QuikrBase{

		@FindBy(id="loginLink") WebElement popup;
		static @FindBy(xpath="//div[@class='nls_formContainer']/div[1]/input") WebElement valid;
		static @FindBy(xpath="//button[text()='Continue']") WebElement continuebtn;
		static @FindBy(xpath="//div[@class='nls_formContainer']/div[2]/input") WebElement pwd;
		static @FindBy(xpath="//button[text()='Login']") WebElement loginbtn;
		static @FindBy(xpath="//i[@class='nls_sprite nls_back_btn']") WebElement back;
		static @FindBy(xpath="//button[text()='Continue']") WebElement continuebtn2;
		
		public void open_url() {
			initialize();
			PageFactory.initElements(driver, this);
			driver.get(prop.getProperty("url"));
		}
		
		public void verify_home() {
			String str = driver.getTitle();
			if(str.contains("Free Classified Ads")) {
				System.out.println("verified home title");
			}
			else {
				System.out.println("false home title");
			}
		}
		
		public void display_login() {
			popup.click();
		}
		
		public void enter_invalid(String userid, String password) {
			System.out.println("invalid");
			try {Thread.sleep(5000);}catch(Exception e) {}
			new Actions(driver).click().build().perform();
			valid.sendKeys(userid);
			continuebtn.click();
			try {Thread.sleep(3000);}catch(Exception e) {}
			pwd.sendKeys(password);
			loginbtn.click();
			try {
				try {Thread.sleep(10000);}catch(Exception e) {}
				continuebtn2.click();
			}catch(Exception e) {}
			back.click();
			valid.clear();
		}
		
		public void enter_valid(String useridd, String passwordd) {
			valid.sendKeys(useridd);
			continuebtn.click();
			try {Thread.sleep(5000);}catch(Exception e) {}
			pwd.sendKeys(passwordd);
			loginbtn.click();
			try {Thread.sleep(10000);}catch(Exception e) {}
			continuebtn2.click();
		}
}
