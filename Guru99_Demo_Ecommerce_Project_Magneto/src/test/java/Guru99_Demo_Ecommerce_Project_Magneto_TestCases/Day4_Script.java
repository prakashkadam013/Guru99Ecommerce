package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import junit.framework.Assert;

public class Day4_Script extends TestBase{

	HomePage hp;
	
	@Test
	public void VerifyTwoMobileComparison() {
		hp = new HomePage(driver);
		hp.clickonMobilelink();
		
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(parentwindow);

		System.out.println(windows);
		
		for (String window : windows) {
			
			if(!parentwindow.equals(window)) {
			
			 driver.switchTo().window(window);
			 String title = driver.getTitle();
			 System.out.println(title);
			}	
		}
		
		if(driver.getPageSource().contains("Samsung Galaxy")) {
			Assert.assertTrue(true);
			System.out.println("Samsung Galaxy mobile is added for compare");
		} else {
			System.out.println("Samsung Galaxy mobile is not added for compare");
		}
		
		if(driver.getPageSource().contains("Sony Xperia")) {
			Assert.assertTrue(true);
			System.out.println("Sony Xperia mobile is added for compare");
		} else {
			System.out.println("Sony Xperia mobile is not added for compare");
		
		}
		
		driver.findElement(By.xpath("//button[@onclick='window.close();']")).click();
	//	driver.switchTo().window(parentwindow);
	//	driver.close();
	}
}
