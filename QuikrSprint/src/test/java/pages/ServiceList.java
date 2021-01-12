/*Author: Prerna
 * Date: 09-Jan-2021
 * Description: below code to
 *              open the url
 *              validate the list of services and products available
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.QuikBase;



public class ServiceList extends QuikBase {
	@FindBy(xpath=("//ul[@id='fixed-category']")) WebElement service;
	
	public void openurl() 													//opens quikr homepage//
	{   
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
	}
	
public void validate_url() {												//validate the quikr homepage
		
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Free Classified Ads in India"))
		{
			System.out.println("Results as expected");
			testlog=ext.createTest("Quikr_Homepage");
			testlog.log(Status.PASS,"Homepage available");
		}
		else
		{
			System.out.println("Results not as expected");
			testlog=ext.createTest("Quikr_Homepage");
			testlog.log(Status.FAIL,"Homepage not available");
		}
	}
	
	public void services() {													//validate list of services
		String str[]= {"Quikr Assured Products","Furniture & Decor","Appliances, ACs","Services","Jobs","Cars","Bikes","Homes","Mobiles & Tablets","Gift Cards","Personal Loan","Sports, Hobbies, Fashion","Kids & Toys","Education","Commercial Real Estate","Pets & Pet Care","Home & Lifestyle","B2B Suppliers","Entertainment","Community","Events",
				"Matrimonial"};
		List<WebElement> lst=service.findElements(By.tagName("label"));
		
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
		}
		for(int i=0;i<lst.size();i++)
		{
			if(str[i].matches(lst.get(i).getText())){
				System.out.println("Matched");
				testlog=ext.createTest("Quikr_Services");
				testlog.log(Status.PASS,"Service available");
				
				
			}
			else {
				System.out.println("Not Matched");
				testlog=ext.createTest("Quikr_Services");
				testlog.log(Status.FAIL,"Service not available");
				
			}
			
			
		}
		

		takescreenshot("QuikrServices.png");
		
	}
	

	 
}
