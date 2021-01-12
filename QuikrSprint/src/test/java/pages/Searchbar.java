/* Author: Virali Mehta
 * Date: 09-01-2021
 * Description: Below code is for Search bar in Quikr Homapage
 * 				openurl
 * 				validate_title
 * 				searchbar
 * 				invalidsearch
 * */

package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.QuikBase;



public class Searchbar extends QuikBase
{
	static @FindBy(xpath="//input[@placeholder='Search in All India']") WebElement searchbar; //Pagefactory elements for Search bar 
	static @FindBy(xpath="//button[@id='submitSearch']") WebElement searchbtn;
	static @FindBy(xpath="//span[text()='NOT NOW']") WebElement popup;
	
	public Searchbar() {
		PageFactory.initElements(driver,this);	//bind the elements with page object
	}
	
	public void validate_title() throws Exception //method for validate tilte
	{
		Thread.sleep(5000);
		String title=driver.getTitle();
		if(title.contains("Free Classified Ads in India"))
		{
			testlog=ext.createTest("Homepage_search");
			testlog.log(Status.PASS, "Homepage title is correct");
			takescreenshot("Homepage.png");
		}
		else
		{
			testlog=ext.createTest("Homepage_search");
			testlog.log(Status.FAIL, "Homepage title is not correct");
			takescreenshot("Homepage.png");
		}
	}
	
	public void searchbar(String str) throws Exception  //method for search words
	{
		searchbar.click();
		searchbar.sendKeys(str);
		Thread.sleep(3000);
		searchbtn.click();
		Thread.sleep(5000);
		String title=driver.getTitle();
		if(title.contains(str))
		{
			testlog=ext.createTest(str);
			testlog.log(Status.PASS,str);
			takescreenshot(str+".png");
		}
		else
		{
			testlog=ext.createTest(str);
			testlog.log(Status.FAIL,str);
			takescreenshot(str+".png");
		}
		driver.navigate().back();	
		
	}
	
	public void invalidsearch() //method for invalid search
	{
		searchbar.click();
		searchbar.sendKeys(" "); //enter space in search bar
		searchbtn.click();
		String str=driver.findElement(By.xpath("//input[@placeholder='Search in All India']")).getCssValue("color");
		if(str.contains("rgba(255, 0, 0, 1)")) 	//text must be in red color 
			System.out.println("Color matched");
		else
			System.out.println("Color doesn't match");
		String title=driver.getTitle();
		if(title.contains("Free Classified Ads in India"))
		{
			testlog=ext.createTest("invalid search");
			testlog.log(Status.PASS, "Invalid search is correct");
			takescreenshot("Invalidsearch.png");
		}
		else
		{
			testlog=ext.createTest("invalid search");
			testlog.log(Status.FAIL, "Invalid search is not correct");
			takescreenshot("Invalidsearch.png");
		}
	}

}
