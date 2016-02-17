package core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.web.WebComponent;

public class CheckBox extends WebComponent<CheckBox>{

	public CheckBox(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
	}
	
	public boolean isSelected (){
		return getWebElement().isSelected();
	}
}
