package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) {
		
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.google.com");
	driver.findElement(By.name("q")).sendKeys("Selenium");
	
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.close(); 
}
}
