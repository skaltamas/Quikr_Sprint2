package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.Quikr_base;

public class ServiceList extends Quikr_base {
	@FindBy(xpath=("//ul[@id='fixed-category']")) WebElement service;
	
	public void openurl() 
	{   
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
	}
	
public void validate_url() {
		
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Free Classified Ads in India"))
			System.out.println("Results as expected");
	}
	
	public void services() {
		String str[]= {"Quikr Assured Products","Furniture & Decor","Appliances, ACs","Services","Jobs","Car","Bikes","Homes","Mobiles & Tablets","Gift Cards","Personal Loan","Sports, Hobbies, Fashion","Kids & Toys","Education","Commercial Real Estate","Pets & Pet Care","Home & Lifestyle","B2B Suppliers","Entertainment","Community","Events",
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
			
		}
		takescreenshot("QuikrServices.png");

		
		
	}
	

	 
}
