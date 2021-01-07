package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class sample {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.name("firstname")).sendKeys("abcd");
		driver.findElement(By.name("lastname")).sendKeys("xyza");
		
		
	}


	
}
