package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import junit.framework.Assert;

public class Day2_Script extends TestBase {

	HomePage hp;
	
	@Test
	public void ValueofSonyXperia() {
		
		hp = new HomePage(driver);
		hp.clickonMobilelink();
		
		WebElement ele1 = driver.findElement(By.xpath("//span[@id='product-price-1']/span"));
		String text1 = ele1.getText();
		System.out.println(text1);
		
		driver.findElement(By.id("product-collection-image-1")).click();
		WebElement ele2 = driver.findElement(By.id("product-price-1"));
		String text2 = ele2.getText();
		System.out.println(text2);

		if(text1.equals(text2)) {
			Assert.assertTrue(true);
			System.out.println("Product value in list and details page is same");
		} else {
			System.out.println("Product value in list and details page is not same");
			Assert.assertTrue(false);
		}
	}
}
