package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Quikr_base {
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports ext;
	public static ExtentTest testlog;
	
	@BeforeSuite
	public void initilaize()
	{
		System.out.println("HI");
		prop=new Properties();
		try {
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		htmlreport = new ExtentHtmlReporter(prop.getProperty("reportslocation")+"google.html");
		ext = new ExtentReports();
		ext.attachReporter(htmlreport);
		ext.setSystemInfo("Host Name", "Prerna-Sysname");
		ext.setSystemInfo("Environment", "Test Env");
		ext.setSystemInfo("User Name", "Prerna-username");
		
		htmlreport.config().setDocumentTitle("Google");
		 htmlreport.config().setReportName("Google Functional Testing");
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
		
		public void takescreenshot(String imagename) {
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(f, new File(prop.getProperty("screens")+"\\"+imagename));
				testlog.addScreenCaptureFromPath(prop.getProperty("screens")+"\\"+imagename);
				}catch(Exception e) {}
			}
		@AfterSuite
		public void teardown()
		{
			ext.flush();
			driver.quit();
			try
			{
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im firefoxdriver.exe");
			}catch(Exception e) {}
			
		}

}
