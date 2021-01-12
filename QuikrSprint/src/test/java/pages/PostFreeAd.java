/*Author:=Muskan Shaikh
 * Date:=9-jan-2021
 * Description: below code to
 *              open the url
 *              verify post ad button
 *              verify the list of categories            
 */


package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.Status;

import base.QuikBase;



public class PostFreeAd extends QuikBase {
	@FindBy(xpath="//a[@id='postAdBtn']") WebElement pt;                   //pagefactory elements for  post ad page
    @FindBy(xpath="//div[@class='menulist']") WebElement w1;
	//@FindBy(xpath="//div[@class='menulist']/div[2]/div[1]") WebElement w2;
	
	public PostFreeAd() {
		PageFactory.initElements(driver, this);                            //bind the elements to the driver object
	}
	
	public void post_button()
	{
		new Actions(driver).moveToElement(pt).click().perform();            //to click on the post free ad button
		//if(driver.getTitle().matches(""))
		if(driver.getTitle().contains("Post free ads"))                     //to verify the post ad page
		{
			testlog=ext.createTest("Quikr-PostPage");                       
			testlog.log(Status.PASS,"After click on post ad,Title as expected");
			takescreenshot("quik.png");	
		}			
		else
		{
			testlog=ext.createTest("Quikr-PostPage");
			testlog.log(Status.FAIL,"After click on post ad, Title NOT as expected");
			takescreenshot("quik.png");	
		}
		
      }
	
	    
	     public void displayList() 
	      {
	    	String str[]= {"Cars & Bikes","Mobiles & Tablets","Electronics & Appliances","Real Estate", 
	    			 "Home & Lifestyle","Jobs","Services","Education & Training","Others","Entertainment","Pets & Pet Care","Community","Events","Matrimonial"};
	    	 
	    	
			List<WebElement> l=w1.findElements(By.xpath("//div[@class='menu-item-text']"));               //to get the list of categories
	    	//List<WebElement> l=driver.findElements(By.xpath("//div[@class='menulist']"));
			System.out.println("***** Categories of Post Free Ad *****");
			for(int i=0;i<l.size();i++) 
			{
			    System.out.println(l.get(i).getText());
			}
			System.out.println("***** Validate Categories of Post Free Ad *****");
			for(int i=0;i<l.size();i++)
			{
				if(str[i].matches(l.get(i).getAttribute("innerHTML")));                      //to verify the list of categories
				{
				System.out.println("Matched");
				testlog=ext.createTest("Quikr-Categories");
				testlog.log(Status.PASS,"Categories displayed as as expected");
			    }
				takescreenshot("category.png");	
	         }
	    	 
	    	driver.navigate().back();
	   }
}	

