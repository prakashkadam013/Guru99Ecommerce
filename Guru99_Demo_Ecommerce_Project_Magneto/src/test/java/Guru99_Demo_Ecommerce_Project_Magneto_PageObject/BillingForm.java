package Guru99_Demo_Ecommerce_Project_Magneto_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingForm {
	
	WebDriver driver;

	public BillingForm(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="billing[firstname]")
	WebElement firstname;
	
	public void enterfirstname(String name) {
		firstname.clear();
		firstname.sendKeys(name);
	}
	
	@FindBy(name="billing[lastname]")
	WebElement lastname;
	
	public void enterlastname(String lastnm) {
		lastname.clear();
		lastname.sendKeys(lastnm);
	}
	
	@FindBy(xpath="//input[@id='billing:street1']")
	WebElement address;
	
	public void enteraddress(String add) {
		address.clear();
		address.sendKeys(add);
	}
	
	@FindBy(name="billing[city]")
	WebElement city;
	
	public void entercity(String cty) {
		city.clear();
		city.sendKeys(cty);
	}
	
	@FindBy(name="billing[region_id]")
	WebElement stat;
	
	@FindBy(name="billing[postcode]")
	WebElement zipcode;
	
	public void enterzipcode(String zip) {
		zipcode.clear();
		zipcode.sendKeys(zip);
	}
	@FindBy(name="billing[country_id]")
	WebElement contry;
	
	@FindBy(name="billing[telephone]")
	WebElement telephone;
	
	public void entertelephone(String tele) {
		telephone.clear();
		telephone.sendKeys(tele);
	}

	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/button")
	WebElement conti;
	
	public void clickonContinue(){
		conti.click();
	}
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
	WebElement btn;
	
	public void clickonNextContinuebtn() {
		btn.click();
	}
	
	@FindBy(xpath="//input[@id='p_method_checkmo']")
	WebElement moneyorder;
	
	public void clickonpaymentmethod() {
		moneyorder.click();
	}
	
	@FindBy(xpath="//*[@id=\"payment-buttons-container\"]/button/span/span")
	WebElement payment_continue;
	
	public void clickonPaymentContinueBtn() {
		payment_continue.click();
	}
	
	@FindBy(xpath="//*[@id=\"review-buttons-container\"]/button/span/span")
	WebElement place_order;
	
	public void clickonPlaceOrderBtn() {
		place_order.click();
	}
}
