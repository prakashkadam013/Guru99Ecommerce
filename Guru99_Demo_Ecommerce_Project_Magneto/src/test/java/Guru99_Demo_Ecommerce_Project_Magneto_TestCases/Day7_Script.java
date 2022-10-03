package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.Handle_window;
import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.Screenshot;
import junit.framework.Assert;

public class Day7_Script extends TestBase{
	
	HomePage hp;
	
	@Test
	public void SavePreviouslyAddedItem() throws IOException {
		
		hp = new HomePage(driver);
		hp.clickonMyAccountlink();
		hp.enteremailid(ConfigDataprovider.getemail());
		hp.enterpassword(ConfigDataprovider.getpassword());
		hp.ClickonLoginbtn();
		
		Screenshot.takeScreenshot(driver, "./Screenshot/Recentorders.png");
		
		if(driver.getPageSource().contains("Recent Orders")) {
			Assert.assertTrue(true);
			System.out.println("Recently added items are present in Recent Orders");
		} else {
			System.out.println("Recently added items are not present in Recent Orders");
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.linkText("MY ORDERS")).click();
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]")).click();
	
		Handle_window.switchToWindow(driver);
		
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[4]/button/span/span")).click();
	
	}
	
}
