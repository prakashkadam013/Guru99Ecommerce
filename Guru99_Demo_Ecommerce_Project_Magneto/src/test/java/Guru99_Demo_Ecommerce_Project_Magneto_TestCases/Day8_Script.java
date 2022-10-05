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
import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.Screenshot;
import Guru99_Demo_Ecommerce_Project_Magneto_Utilities.SelectDropdownUtility;

public class Day8_Script extends TestBase {
	
	HomePage hp;
	WebElement stat;
	WebElement contry;
	BillingForm bf;
	
	@Test
	public void ReorderandChangeQty() throws IOException {
		hp = new HomePage(driver);
		
		hp.clickonMyAccountlink();
		hp.enteremailid(ConfigDataprovider.getemail());
		hp.enterpassword(ConfigDataprovider.getpassword());
		hp.ClickonLoginbtn();
		
		// Click on Reorder Button
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement qty = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input"));
		qty.clear();
		qty.sendKeys("10");
		
		driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button")).click();
		
		WebElement grand_total = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
		String total = grand_total.getText();
		
		Assert.assertEquals("$6,150.00", total);
		System.out.println("Grand Total is changed and verified");
		
		Screenshot.takeScreenshot(driver, "./Screenshot/grandtotal.png");
		
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		WebElement state = driver.findElement(By.xpath("//select[@id='region_id']"));
		
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(country, "United States");
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(state, "New York");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("548296");
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();

		driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label/span")).click();
		driver.findElement(By.xpath("//button[@title='Update Total']")).click();
		driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));

		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span")).click();
		WebElement billing_id = driver.findElement(By.name("billing_address_id"));
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(billing_id, "New Address");
		
		bf = new BillingForm(driver);
		bf.enterfirstname("Prakash");
		bf.enterlastname("Kadam");
		bf.enteraddress("lkjhgfds");
		bf.entercity("New York");
		stat = driver.findElement(By.name("billing[region_id]"));
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(stat, "New York");
		bf.enterzipcode("123466");
		contry = driver.findElement(By.name("billing[country_id]"));
		SelectDropdownUtility.DropdwonSelectionbyVisibleText(contry, "United States");
		bf.entertelephone("9874563210");
		bf.clickonContinue();
		bf.clickonNextContinuebtn();
		bf.clickonpaymentmethod();
		bf.clickonPaymentContinueBtn();
		bf.clickonPlaceOrderBtn();
		
		WebElement confirm_msg = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1"));
		String msg = confirm_msg.getText();
		System.out.println(msg);
		
		WebElement order = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]"));
		String id = order.getText();
		System.out.println("order is palced and id is   "+id);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshot/ReOrderPlaced.png");
		FileHandler.copy(src, target);
		
		Assert.assertEquals(msg, "CHECKOUT", "Sucessfully placed reorder");
		
		Screenshot.takeScreenshot(driver, "./Screenshot/Reorderid.png");
		}
}
