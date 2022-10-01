package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;


public class Day1_Script extends TestBase{
	
	HomePage hp;
	@Test
	public void TitleofthePage_001() {
		
		String pagetitle = driver.getTitle();
		if(pagetitle.equals("Home page")) {
			Assert.assertTrue(true);
			System.out.println("HomePage title is verified");
		} else {
			System.out.println("HomePage title is not verified");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyMobileLink_002(){
		
		HomePage hp = new HomePage(driver);
		if(hp.verifyMobilelink()) {
			Assert.assertTrue(true);
			System.out.println("Mobile link is present on HomePage");
		} else {
			System.out.println("Mobile link is not present on HomePage");
			Assert.assertTrue(false);
		}	
	}
	
	@Test
	public void clickonMobilelink_003() {
		hp = new HomePage(driver);
		hp.clickonMobilelink();
		String title = driver.getTitle();
		
		if(title.equals("Mobile")) {
			Assert.assertTrue(true);
			System.out.println("MobilePage title is verified");
		} else {
			System.out.println("MobilePage title is not verified");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Selectthedropdown_004() throws IOException {
		hp = new HomePage(driver);
		hp.clickonMobilelink();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@title='Sort By']"));
	
		Select sel = new Select(dropdown);
				
		sel.selectByVisibleText("Name");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/Product_list_by_Name.png");
		FileHandler.copy(src, target);
		
	}
}
