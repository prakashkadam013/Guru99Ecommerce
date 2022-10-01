package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import junit.framework.Assert;

public class Day5_Script extends TestBase {

	HomePage hp;
	
	@Test
	public void CreateNewAccount() {
		
		hp = new HomePage(driver);
		
		driver.findElement(By.linkText("ACCOUNT")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Prakash");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Deshmukh");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("adgtyth@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pk431991");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("Pk431991");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		if(driver.getPageSource().contains("My Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("User registration is sucessful");
		} else {
			System.out.println("User registration is unscucessful");
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void VerifyWishlistisShared() {
		hp = new HomePage(driver);
		driver.findElement(By.linkText("ACCOUNT")).click();
		driver.findElement(By.linkText("Log In")).click();
		
		driver.findElement(By.name("login[username]")).sendKeys("adgtyth@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("Pk431991");
		driver.findElement(By.name("send")).click();
		
		driver.findElement(By.xpath("//li[@class='level0 nav-2 last']")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
		driver.findElement(By.name("save_and_share")).click();
		driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("deshmukhmultiservices21@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("This my first wishlist");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		WebElement confirm_ele = driver.findElement(By.className("success-msg"));
		String confirm_msg = confirm_ele.getText();
		
		if(confirm_msg.contains("Your Wishlist has been shared.")) {
			Assert.assertTrue(true);
			System.out.println("Wishlist is shared sucessfully");
		} else {
			System.out.println("Wishlist is not shared ");
			Assert.assertTrue(false);
		}	
	}
}
