package pages;

import org.openqa.selenium.support.PageFactory;

import base.QuikBase;

public class Quikr extends QuikBase
{
	
	public void openurl()
	{
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
	}
}
