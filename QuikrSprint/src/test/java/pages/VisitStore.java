/*
 * Author: Jyotsna
 * Date: 9th Jan 2021
 * Description: Below code to
 * 					click on visit our store button
 * 					validate visit our store page
*/
package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import base.QuikBase;

public class VisitStore extends QuikBase 
{
	@FindBy(xpath="//span[text()='Visit Our Store']") WebElement st;		//page factory element for visit our store button
	@FindBy(xpath="(//ul)[15]") WebElement w1;
	@FindBy(xpath="//div[@class='qg-expZoneHeader']/h1") WebElement visit;
	
	public void store()
	{
		PageFactory.initElements(driver, this);			//binds element to the driver object
		new Actions(driver).moveToElement(st).click().perform();			//To click on visit our store button
	}
	
	public void display()
	{
			try {
				Thread.sleep(10000);	
			}catch(Exception e) {}
			ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(al.get(1));
			List<WebElement> l=w1.findElements(By.tagName("h1"));			//to validate visit our page
			System.out.println("Number of stores on the page is "+l.size());
			for(int i=0;i<l.size();i++)
			{
				Reporter.log("Title: "+l.get(i).getText()+" ");
				Reporter.log("Address: "+l.get(i).findElement(By.xpath("//h2[text()]")).getText()+" ");
				System.out.println(l.get(i).getText());
			}
			String s=visit.getText();
			if(s.contains("Quikr Experience Zone"))
			{
				testlog=ext.createTest("Quikr-VisitStorePage");
				testlog.log(Status.PASS,"After clicking on visit our store button, text is as expected on the page");
				takescreenshot("quikrvisitstore.png");
			}
			else
			{
				testlog=ext.createTest("Quikr-VisitStorePage");
				testlog.log(Status.FAIL,"After clicking on visit our store button, text is NOT as expected on the page");
				takescreenshot("quikrvisitstore.png");
			}
	}
}
