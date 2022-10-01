package Guru99_Demo_Ecommerce_Project_Magneto_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"nav\"]/ol/li[1]/a")
	WebElement mobile;
	
	public boolean verifyMobilelink(){
		return mobile.isDisplayed();
	}
	
	public void clickonMobilelink(){
		mobile.click();
	}
}
