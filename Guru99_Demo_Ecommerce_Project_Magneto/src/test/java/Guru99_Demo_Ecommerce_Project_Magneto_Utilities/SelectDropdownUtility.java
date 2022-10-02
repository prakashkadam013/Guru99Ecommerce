package Guru99_Demo_Ecommerce_Project_Magneto_Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownUtility {

	public static void DropdwonSelectionbyVisibleText(WebElement dropdown, String visibletext) {
		
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(visibletext);
	}
}
