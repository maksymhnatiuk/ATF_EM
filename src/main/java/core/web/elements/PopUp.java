package core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import core.web.WebComponent;

public class PopUp extends WebComponent<PopUp>{

	public PopUp(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
		
	}
}
