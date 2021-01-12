/*
 * Author: Shalu Bankar
 * Date: 11-Jan-2021
 * Description: below code to 
 *				open the url
 *				Register with credintials such as mobile no., Name, Email, Password
*/
//Register 
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.QuikBase;

public class Register extends QuikBase{
	
	static @FindBy(xpath="//div[@class='nls_formContainer']/div[1]/input") WebElement user;
	static @FindBy(xpath="//div[@class='nls_formControl nls_formField'])[2]/input") WebElement uname;
	static @FindBy(xpath="//div[@class='nls_formControl nls_formField'])[3]/input") WebElement mail;
	static @FindBy(xpath="//div[@class='nls_formControl']/input") WebElement pass;
	static @FindBy(xpath="//button[text()='Continue") WebElement cont;
	
	public Register()
	{
		PageFactory.initElements(driver,this);
	}

	public void open_registration_page(){
		initialize();
		try {Thread.sleep(5000);}catch(Exception e) {} 								//wait
		new Actions(driver).click().build().perform(); 								//close popup
		try {Thread.sleep(5000);}catch(Exception e) {} 								//wait
		driver.findElement(By.xpath("//label[text()='Login/Register']")).click(); 	//click on login
	}
	
	public void registered_credintials(String userid, String name, String email, String password) throws InterruptedException {
		try {Thread.sleep(1000);}catch(Exception e){}
		user.sendKeys(userid);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		try {Thread.sleep(1000);}catch(Exception e){}
		//driver.findElement(By.xpath("//label[text()='Name']")).click();
		uname.sendKeys(name);
		try {Thread.sleep(1000);}catch(Exception e){}
		mail.sendKeys(email);
		try {Thread.sleep(1000);}catch(Exception e){}
		pass.sendKeys(password);
		
		cont.click();
		
		try {																		//wait for captcha if any
			if(cont.isDisplayed()) {
				try {Thread.sleep(10000);}catch(Exception e) {}
				cont.click();
			}
		}catch(Exception e) {}
		
		cont.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Verify and Login')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
	}
	
}
