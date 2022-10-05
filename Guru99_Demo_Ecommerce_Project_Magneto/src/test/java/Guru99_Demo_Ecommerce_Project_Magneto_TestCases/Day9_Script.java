package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.Screenshot;
import junit.framework.Assert;

public class Day9_Script extends TestBase{

	HomePage hp;
	
	@Test
	public void VerifyDiscountCouponIsWorking() throws IOException {
		hp = new HomePage(driver);
		
		hp.clickonMobilelink();
		// Click on Add to Cart for IPHONE
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button/span/span")).click();
	
		WebElement coupon = driver.findElement(By.cssSelector("#coupon_code"));
		coupon.clear();
		coupon.sendKeys("GURU50");
		
		// Click on Apply Button
		
		driver.findElement(By.xpath("//*[@id=\"discount-coupon-form\"]/div/div/div/div/button/span/span")).click();
		
		WebElement discount = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/ul/li/ul/li/span"));
	
		String discount_msg = discount.getText();
		System.out.println(discount_msg);
	
		if(discount.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Discount is generated");
		} else {
			System.out.println("Discount is not generated");
			Assert.assertTrue(false);
		}
	
		Screenshot.takeScreenshot(driver, "./Screenshot/Discountgenerated.png");
		System.out.println("Screenshot taken");
	}
}
