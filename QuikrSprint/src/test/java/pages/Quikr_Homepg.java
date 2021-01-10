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

import base.Quikr_base;

public class Quikr_Homepg extends Quikr_base
{
	static @FindBy(xpath="//input[@placeholder='Search in All India']") WebElement searchbar;
	static @FindBy(xpath="//button[@id='submitSearch']") WebElement searchbtn;
	static @FindBy(xpath="//span[text()='NOT NOW']") WebElement popup;
	
	public void openurl() throws Exception 
	{
		initialize();
		PageFactory.initElements(driver,this);	
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		new Actions(driver).moveToElement(popup).click().perform();		
	}
	
	public void validate_title() throws Exception
	{
		Thread.sleep(5000);
		String title=driver.getTitle();
		if(title.contains("Free Classified Ads in India, Post Ads Online | Quikr  India"))
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
	
	public void searchbar(String str) throws Exception 
	{
		
		searchbar.click();
		searchbar.sendKeys(str);
		Thread.sleep(3000);
		searchbtn.click();
		Thread.sleep(5000);
		takescreenshot("searchbar.png");
		driver.navigate().back();	
	}
	
	public void invalidsearch() {
		searchbar.click();
		searchbar.sendKeys(" ");
		searchbtn.click();
		String str=driver.findElement(By.xpath("//input[@placeholder='Search in All India']")).getCssValue("color");
		System.out.println(str);
		if(str.contains("rgba(255, 0, 0, 1)")) {
			
			System.out.println("Color matched");
		}
		else
			System.out.println("Color doesn't match");
		takescreenshot("invalid_input.png");
	
	}

}
