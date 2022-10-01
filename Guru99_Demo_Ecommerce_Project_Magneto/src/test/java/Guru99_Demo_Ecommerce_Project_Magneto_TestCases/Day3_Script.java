package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import junit.framework.Assert;

public class Day3_Script extends TestBase {

	HomePage hp;
	
	@Test
	public void verifyProductQtyinAddtoCart() throws IOException {
		hp = new HomePage(driver);
		hp.clickonMobilelink();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")).click();
		WebElement qty = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input"));
		qty.clear();
		qty.sendKeys("1000");
		driver.findElement(By.xpath("//button[@type='submit']//span[text()='Update']")).click();
		WebElement error_ele = driver.findElement(By.xpath("//p[@class='item-msg error']"));
		String error_msg = error_ele.getText();
		
		if(error_msg.contains("The maximum quantity allowed for purchase is 500.")) {
			Assert.assertTrue(true);
			System.out.println("Error message is verified");
		} else {
			System.out.println("Error message is not verified");
			Assert.assertTrue(false);
		}
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/errormsg.png");
		FileHandler.copy(src, target);
	}
	
	
	@Test
	public void verifyMsgafterEmptyCart() throws IOException {
		hp = new HomePage(driver);
		hp.clickonMobilelink();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button")).click();
		driver.findElement(By.id("empty_cart_button")).click();
		String msg_text = driver.findElement(By.className("cart-empty")).getText();
		
		if(msg_text.contains("You have no items in your shopping cart.")) {
			Assert.assertTrue(true);
			System.out.println("Empty cart message is verified");
		} else {
			System.out.println("Empty cart message is not verified");
			Assert.assertTrue(false);
		}
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/emptycart.png");
		FileHandler.copy(src, target);
	}
}
