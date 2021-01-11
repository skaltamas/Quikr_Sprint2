package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class QuikBase 
{
	public static WebDriver driver;
	public static Properties prop;
	@FindBy(xpath="//div[@class='select-city']/a/i[2]") WebElement cityarrow;
	@FindBy(xpath="//div[@class='spl-cities']/a[text()='All India']") WebElement h;
	
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports ext;
	public static ExtentTest testlog;
	
	@Before						//execute before entire prog suite 
	public void initialize()
	{
		prop=new Properties();
		try
		{
			prop.load(new FileInputStream("src/test/resources/visit.properties"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 htmlreport = new ExtentHtmlReporter(prop.getProperty("reportslocation")+"\\quikr.html");
		 ext = new ExtentReports();
		 ext.attachReporter(htmlreport);
		 ext.setSystemInfo("Host Name", "Jyotsnapm-sysname");
		 ext.setSystemInfo("Environment", "Test Env");
		 ext.setSystemInfo("User Name", "Jyotsna-testername");
		   
		 htmlreport.config().setDocumentTitle("Quikr");
		 htmlreport.config().setReportName("Quikr Functional Testing");
		 htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlreport.config().setTheme(Theme.STANDARD);	
		   
		if(prop.getProperty("browser").matches("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(prop.getProperty("browser").matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	public void takescreenshot(String imagename)
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		FileUtils.copyFile(f, new File(prop.getProperty("screens")+"\\"+imagename));
		testlog.addScreenCaptureFromPath(prop.getProperty("screens")+"\\"+imagename);
		}catch(Exception e) {}
	}
	public void openurl()
	{
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
		takescreenshot("Homepage.png");
		try {
			cityarrow.click();
			Thread.sleep(2000);
			h.click();
			Thread.sleep(20000);
		}catch(Exception e) {}
		WebElement pop=driver.findElement(By.xpath("//span[text()='NOT NOW']"));
		new Actions(driver).moveToElement(pop).click().perform();
	}
	@After
	public void teardown()
	{
		ext.flush();//save the report
		driver.quit();//close if anyall browsers which are open
		try
		{
		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");//kill the geckodriver process
		}catch(Exception e) {}
	}
}
