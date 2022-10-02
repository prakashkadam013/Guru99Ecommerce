package Guru99_Demo_Ecommerce_Project_Magneto_TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.BillingForm;
import Guru99_Demo_Ecommerce_Project_Magneto_PageObject.HomePage;
import Guru99_Demo_Ecommerce_Project_Magneto_TestBase.TestBase;
import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.SelectDropdownUtility;

public class Day6_Script extends TestBase {

	HomePage hp;
	BillingForm bf;
	WebElement stat;
	WebElement cntry;
	WebElement lg_tv;
	String lg_tv_price;
	WebElement tax;
	String tax_price;
	WebElement grand_ele;
	
	@Test(priority=1)
	public void OrderProdtuctFromValidUser() {
		
		hp = new HomePage(driver);
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.name("login[username]")).sendKeys("adgtyth@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("Pk431991");
		driver.findElement(By.id("send2")).click();
		
		driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
		lg_tv = driver.findElement(By.id("product-price-4"));
		String lg_tv_price = lg_tv.getText();
		System.out.println("Price of LG TV is  " +lg_tv_price);
		
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();
		
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		WebElement state = driver.findElement(By.xpath("//select[@id='region_id']"));
		
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(country, "United States");
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(state, "New York");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("548296");
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();
		
		tax = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label/span"));
		String tax_price = tax.getText();
		System.out.println("Shipping price for LG tv is  " +tax_price);
		
		if(tax.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Shipping price is calculted");
		} else {
			System.out.println("Shipping price is not calculated");
			Assert.assertTrue(false); 
		}
	}
		@Test(priority=2)
		public void VerifyShippingCostAddedInFinalPrice() {
		tax.click();
		driver.findElement(By.xpath("//button[@title='Update Total']")).click();
		
		grand_ele = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
		String grand_price = grand_ele.getText();
		System.out.println("Final price of LG TV is  " +grand_price);
		
		if((grand_price)!=(lg_tv_price+tax_price)) {
			Assert.assertTrue(true);
			System.out.println("Shipping Cost is Added to toal price");
		} else {
			System.out.println("Shipping Cost is not Added to toal price");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test(priority=3)
	public void EnterBillingInformation() throws IOException {
		
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span")).click();

		bf = new BillingForm(driver);
		bf.enterfirstname("Rajesh");
		bf.enterlastname("Kadam");
		bf.enteraddress("abcde");
		bf.entercity("New York");
		
		stat = driver.findElement(By.name("billing[region_id]"));
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(stat, "New York");
		bf.enterzipcode("542896");

		cntry = driver.findElement(By.name("billing[country_id]"));
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(cntry, "United States");
		bf.entertelephone("12345678");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		bf.clickonContinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		bf.clickonNextContinuebtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		bf.clickonpaymentmethod();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		bf.clickonPaymentContinueBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		bf.clickonPlaceOrderBtn();
		
		WebElement confirm_msg = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]"));
		String msg = confirm_msg.getText();
		System.out.println(msg);
		
		WebElement order = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]"));
		String id = order.getText();
		System.out.println("order is palced and id is   "+id);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/OrderPlaced.png");
		FileHandler.copy(src, target);
		
		if(msg.contains("Your order has been received.")) {
			Assert.assertTrue(true);
			System.out.println("Your order is successfully placed");
		} else {
			System.out.println("Your order is not successfully placed");
			Assert.assertTrue(false);
		}
	}

}