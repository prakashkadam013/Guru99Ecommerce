package Guru99_Demo_Ecommerce_Project_Magneto_Utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Handle_window {
	
	public static void switchToWindow(WebDriver driver) {
		
		String parentwindow = driver.getWindowHandle();
		Set<String> childwindows = driver.getWindowHandles();
		
		for (String id : childwindows) {
			
			if(!parentwindow.equals(id)) {
				driver.switchTo().window(id);
				System.out.println(driver.getTitle());
				
			}
		}
	}
}
