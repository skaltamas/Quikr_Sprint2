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
	@FindBy(xpath="//span[text()='Visit Our Store']") WebElement st;
	@FindBy(xpath="(//ul)[15]") WebElement w1;
	@FindBy(xpath="//div[@class='spl-cities']/a[text()='All India']") WebElement h;
	
	public void store()
	{
		PageFactory.initElements(driver, this);
		new Actions(driver).moveToElement(st).click().perform();
		
		if(driver.getTitle().matches(""))
			{
				testlog=ext.createTest("Quikr-ResultsPage");
				testlog.log(Status.PASS,"After search Results are displayed, Title asexpected");
				takescreenshot("quikrresults.png");	
			}			
			else
			{
				testlog=ext.createTest("Quikr-ResultsPage");
				testlog.log(Status.FAIL,"After search Results/Title NOT as expected");
				takescreenshot("quikrresults.png");	
			}
			
	}
	public void display()
	{
			try {
				Thread.sleep(10000);	
			}catch(Exception e) {}
			ArrayList<String> al=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(al.get(1));
			List<WebElement> l=w1.findElements(By.tagName("h1"));
			System.out.println("Number of stores on the page is "+l.size());
			for(int i=0;i<l.size();i++)
			{
				Reporter.log("Title: "+l.get(i).getText()+" ");
				Reporter.log("Address: "+l.get(i).findElement(By.xpath("//h2[text()]")).getText()+" ");
				System.out.println(l.get(i).getText());
			}
	}
}
