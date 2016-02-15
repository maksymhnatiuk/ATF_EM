package core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.web.WebComponent;

public class DropDown extends WebComponent<DropDown>{

	public DropDown(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
	}
	
	public DropDown selectByVisibleText(String text){
		Select dropDown = new Select(getWebElement());
		dropDown.selectByVisibleText(text);
		return this;		
	}

}
