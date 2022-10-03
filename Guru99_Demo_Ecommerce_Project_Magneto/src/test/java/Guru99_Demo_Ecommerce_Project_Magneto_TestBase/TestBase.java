package Guru99_Demo_Ecommerce_Project_Magneto_TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.ConfigDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public static ConfigDataProvider ConfigDataprovider;
	
	@BeforeSuite
	public void init() {
		ConfigDataprovider = new ConfigDataProvider("./ConfigData/configdata.properties");
	}
	
	@BeforeTest
	public void SetupBrowser(@Optional("Chrome")String browser) {
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else {
		System.out.println("No browser present");
		}
		
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterTest
	public void ClosetheBrowser() throws InterruptedException {
		Thread.sleep(5000);
	//	driver.quit();
	}
	
	
}
