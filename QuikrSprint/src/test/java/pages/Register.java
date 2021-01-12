/*
 * Author: Shalu Bankar
 * Date: 11-Jan-2021
 * Description: below code to 
 *				open the url
 *				Register with credintials such as mobile no., Name, Email, Password
*/
//Register 
package pages;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import base.QuikBase;



public class Register extends QuikBase{
	ChromeDriver driver=new ChromeDriver();
	Actions actions = new Actions(driver);


	static @FindBy(xpath="//label[text()='Login/Register']") WebElement register;   //pagefactory elememts for login page
	static @FindBy(xpath="//div[@class='nls_formContainer']/div[1]/input") WebElement valid;
	static @FindBy(xpath="//button[text()='Continue']") WebElement cont;
	static @FindBy(xpath="//div[@class='nls_formContainer']/div[2]/input") WebElement pwd;
	static @FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]") WebElement uname;
	static @FindBy(xpath="//*[@id='newLoginSignUpModal']/div/div/div/div/form/div[1]/div[3]/input") WebElement emailid;
	static @FindBy(xpath="//*[@id='newLoginSignUpModal']/div/div/div/div/form/div[1]/div[4]/input") WebElement pass;
	
	
	public  Register()
	{
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //bind the elements to the driveobject65
	}

	public void openurl()
	{
		
		driver.get("https://www.quikr.com");
	}
	public void open_registration_page() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Login/Register']")).click();
		Thread.sleep(7000);
		
		actions.click().build().perform();
	}
	
	public void registered_credintials(String userid, String name, String email, String password) throws InterruptedException {
		System.out.println("Registered user");
		try {Thread.sleep(1000);}catch(Exception e){}
		driver.findElement(By.xpath("//div[@class='nls_formContainer']/div[1]/input")).sendKeys(userid);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		uname.sendKeys(name);
		try {Thread.sleep(1000);}catch(Exception e){}
		emailid.sendKeys(email);
		try {Thread.sleep(1000);}catch(Exception e){}
		pass.sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Verify and Login')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
	}
	
}
