package core.web.elements;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertPopUp{

	protected WebDriver driver;
	protected boolean acceptNextAlert = true;
	private Alert currentAlert;
	
	public Alert getAlert(){
		if(isAvailable()){
			return currentAlert;
		} else {
			currentAlert = null;
			return currentAlert;
		}
	}
	
	public AlertPopUp(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isAvailable(){
		try {
			currentAlert = driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}		
	}
	
	public String getText(){
		Alert alert = getAlert();
		if (alert != null) {
			return alert.getText();
		} else {
			return "";
		}		
	}
	
	public String closeAlertAndGetItsText(){
		  try {
		      String alertText = getText();
		      if (acceptNextAlert) {
		        currentAlert.accept();
		      } else {
		        currentAlert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
	}

}
